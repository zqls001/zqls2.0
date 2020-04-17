package com.duanxin.zqls.ucenter.service;

import com.duanxin.zqls.ucenter.api.FdfsService;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author duanxin
 * @version 1.0
 * @date 2020/4/6 20:27
 */
@Service(version = "0.0.1", delay = -1)
public class FdfsServiceImpl implements FdfsService {

    @Resource
    private FastFileStorageClient fastFileStorageClient;

    @Override
    public String upload(byte[] data, long size, String fileExtName) throws Exception {
        InputStream is = new ByteArrayInputStream(data);
        StorePath storePath = fastFileStorageClient.uploadFile(is,
                                size,
                                fileExtName,
                                null);
        String path = storePath.getFullPath();
        return path;
    }
}
