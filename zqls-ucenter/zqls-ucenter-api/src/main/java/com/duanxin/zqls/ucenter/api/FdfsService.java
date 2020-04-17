package com.duanxin.zqls.ucenter.api;

/**
 * fasfdfs service接口
 * @author duanxin
 * @version 1.0
 * @date 2020/4/6 20:24
 */
public interface FdfsService {

    /**
     * 文件上传
     * @throws Exception
     * @date 2020/4/6 20:25
     * @return java.lang.String
     **/
    String upload(byte[] data, long size, String fileExtName) throws Exception;
}
