package top.BinGCU.service.Impl;

import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import top.BinGCU.Util.ApplicationContextShortcut;
import top.BinGCU.dao.UserMapper;
import top.BinGCU.service.ResourcesParsingService;

import java.io.File;
import java.io.IOException;

/**
 *  Provide the parsing services about static file resources.
 *  <p> The class implement some basic functions
 *  about the parsing process of static resources  .</p>
 *
 * @author BinGCU
 * @version 1.0
 */
public class ResourcesParsingServiceImpl implements ResourcesParsingService {
    private ApplicationContext applicationContext;

    public ResourcesParsingServiceImpl() {
        this.applicationContext = ApplicationContextShortcut.getInstance();
    }


    /**
     * The method is defined to obtain the user avatar' s real binary datas.
     *
     * @param downloadFileName 客户端下载文件时的文件名
     * @param realPath 文件在服务器磁盘中的全路径
     * @return 返回可供客户端解析的响应实体
     * @throws IOException
     * @see ResponseEntity
     */
    @Override
    public ResponseEntity<byte[]> obtainAvatarReponseEntity(String downloadFileName, String realPath ) throws IOException {
        File img = new File(realPath);
        System.out.println("File img："+img);

        //设置httpHeaders，使浏览器响应下载
        HttpHeaders headers = new HttpHeaders();
        //告诉浏览器执行下载的操作
        //attachment 告诉了浏览器进行下载
        headers.setContentDispositionFormData("attachment", downloadFileName);
//        headers.setContentDispositionFormData("inline", downloadFileName);
        //设置响应方式为二进制
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        headers.setContentType(MediaType.IMAGE_JPEG);

        byte[] result = FileUtils.readFileToByteArray(img);
        int index = 0;
        int lineFeed = 0;

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(img), headers, HttpStatus.CREATED);
    }

    @Override
    public String queryAvatarPathByUserAccountStr(String userAccountStr) {
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);

        return userMapper.queryAvatarPathByUserAccountStr(userAccountStr);
    }
}
