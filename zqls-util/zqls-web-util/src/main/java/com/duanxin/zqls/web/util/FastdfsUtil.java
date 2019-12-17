package com.duanxin.zqls.web.util;

import lombok.extern.slf4j.Slf4j;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * fastdfs工具类
 * @author duanxin
 * @version 1.0
 * @date 2019/12/8 14:55
 */
@Slf4j
public class FastdfsUtil {

    private static TrackerClient trackerClient = null;
    private static TrackerServer trackerServer = null;
    private static StorageClient storageClient = null;
    private static StorageServer storageServer = null;
    private final static String GROUP_NAME = "group1";

    static {
        // 加载配置文件
        try {
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            // 初始化连接数据

        } catch (IOException | MyException e) {
            log.error("加载fastdfs配置文件失败", e);
        }
    }

    /**
     * 初始化连接
     * @date 2019/12/8 15:09
     **/
    private static void init() {
        try {
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageClient = new StorageClient(trackerServer, storageServer);
        } catch (IOException e) {
            log.error("初始化连接失败", e);
        }
    }

    /**
     * 上传文件
     * @param filePath 文件路径
     * @param fileName 文件名
     * @date 2019/12/8 15:20
     * @return java.lang.String[]
     **/
    public static String[] uploadFile(String filePath, String fileName) {
        return uploadFile(null, filePath, fileName);
    }

    /**
     * 上传文件
     * @param fileBuff 文件数据流
     * @param fileName 文件名
     * @date 2019/12/8 15:22
     * @return java.lang.String[]
     **/
    public static String[] uploadFile(byte[] fileBuff, String fileName) {
        return uploadFile(fileBuff, null, fileName);
    }

    /**
     * 上传文件
     * @param fileBuff 文件字节数组
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @date 2019/12/8 15:07
     * @return java.lang.String[]
     **/
    private static String[] uploadFile(byte[] fileBuff, String filePath, String fileName) {

        try {
          if (fileBuff == null && filePath == null) {
              return new String[0];
          }
          // 初始化数据
          if (storageClient == null) {
              init();
          }
          // 获取文件扩展名
          String fileExtName = "";
          if (fileName != null && !"".equals(fileName) && fileName.contains(".")) {
              fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
          } else {
              return new String[0];
          }
          // 判断是否是本地文件数据
          if (null == fileBuff) {
              File file = new File(filePath + File.separator + fileName);
              fileBuff = new byte[(int) file.length()];
              FileInputStream fis = new FileInputStream(file);
              fis.read(fileBuff);
              fis.close();
          }
          // 设置图片元数据
          NameValuePair[] metaList = new NameValuePair[2];
          metaList[0] = new NameValuePair("fileName", fileName);
//          metaList[1] = new NameValuePair("fileExtName", fileExtName);
          metaList[1] = new NameValuePair("fileSize", String.valueOf(fileBuff.length));
          // 上传文件
          String[] uploadFile = null;
          if (fileBuff != null && filePath == null) {
              if (fileBuff.length == 0) {
                  return new String[0];
              }
              uploadFile = storageClient.upload_file(fileBuff, fileExtName, metaList);
          } else {
              //路径匹配Windown和Linux
              if ("".equals(filePath)) {
                  return new String[0];
              }
              uploadFile = storageClient.upload_file(filePath, fileExtName, metaList);
          }
          return uploadFile == null ? new String[0] : uploadFile;
        } catch (IOException | MyException e) {
            log.error("上传文件失败", e);
        } finally {
            try {
                if (trackerServer != null) {
                    trackerServer.close();
                    trackerServer = null;
                }
                if (storageServer != null) {
                    storageServer.close();
                    storageServer = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new String[0];
    }

    /**
     * 删除文件
     * @param remoteFileName 文件在服务器中的名称
     * @date 2019/12/8 16:13
     * @return int
     **/
    public static int deleteFile(String remoteFileName) {
        try {
            if (remoteFileName == null || "".equals(remoteFileName) || !remoteFileName.contains(GROUP_NAME)) {
                return -1;
            }
            if (storageClient == null) {
                init();
            }
            String fileURL = remoteFileName.substring(remoteFileName.indexOf(GROUP_NAME));
            String group = fileURL.substring(0, remoteFileName.indexOf("/") + 1);
            String fileName = fileURL.substring(remoteFileName.indexOf("/") + 2);
            int code = storageClient.delete_file(group, fileName);
            return code;
        } catch (Exception e) {
            log.error("删除文件失败", e);
        }
        return -1;
    }

    /**
     * 获取文件信息
     * @param groupName 组名
     * @param remoteFileName 远程文件名
     * @date 2019/12/9 8:28
     * @return org.csource.fastdfs.FileInfo
     **/
    public static FileInfo getFileInfo(String groupName, String remoteFileName) {
        if (null == storageClient) {
            init();
        }
        try {
            FileInfo fileInfo = storageClient.get_file_info(groupName, remoteFileName);
            return fileInfo;
        } catch (IOException | MyException e) {
            log.error("获取文件信息失败", e);
        }
        return null;
    }
}
