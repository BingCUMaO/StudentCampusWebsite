package top.BinGCU.service;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

/**
 *  Provide the parsing services about static file resources.
 *
 * @author BinGCU
 * @version 1.0
 */
public interface ResourcesParsingService {

    /**
     * The method is defined to obtain the user avatar' s real binary datas.
     *
     * @param downloadFileName 客户端下载文件时的文件名
     * @param realPath 文件在服务器磁盘中的全路径
     * @return 返回可供客户端解析的响应实体
     * @throws IOException
     * @see ResponseEntity
     */
    ResponseEntity<byte[]> obtainAvatarReponseEntity(String downloadFileName, String realPath ) throws IOException;

    String queryAvatarPathByUserAccountStr( String userAccountStr);

}
