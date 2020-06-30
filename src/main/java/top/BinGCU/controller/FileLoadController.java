package top.BinGCU.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.BinGCU.service.Impl.ResourcesParsingServiceImpl;
import top.BinGCU.service.ResourcesParsingService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * The class is to manager files which is like some of
 * images file abount user' s datas, public file and so on.
 *
 * @author BinGCU
 * @version 1.0
 */
@Controller
public class FileLoadController {
    private static String sessionName = "userAccountStr";
    private ResourcesParsingService resourcesParsingService = new ResourcesParsingServiceImpl();

    /**
     * The method support to download the user' s avatar.
     * And it' s invoking are by to request the url '/fileLoader/avatar/download'.
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/fileLoader/avatar/download")
    @ResponseBody
    public ResponseEntity<byte[]> avatarDownload(HttpServletRequest request) throws IOException {
        //1、根据session.getAttribute，获取userAccount
        String userAccountStr = (String) request.getSession().getAttribute(sessionName);
        //2、根据userAccount 从数据库中查找avatarPath
        String realPath = resourcesParsingService.queryAvatarPathByUserAccountStr(userAccountStr);
        String downName = realPath.substring(
                request.getServletContext().getRealPath("/WEB-INF/static/img/avatar").length(),
                realPath.length()
        );

        System.out.println("downName："+downName);

        //3、根据avatarPath 从服务器的磁盘中读取图片文件到缓存中
        //4、想办法将图片文件发送到前端
        //（本来预想第3、4步是需要在controller中实现的，但误打误撞地发现其实在service层就能够简单实现）
        return resourcesParsingService.obtainAvatarReponseEntity(downName, realPath);
    }

    /**
     * The url '/avatar/path' provide the user' s avatar path to be analyse,
     * and then according the path, analysis tool in front-end web will be to
     * find the real image data.
     * @param request
     * @return the real path of the user' s avatar
     */
    @RequestMapping("/avatar/path")
    @ResponseBody
    public String obtainAvatarPath(HttpServletRequest request){
        String userAccountStr = (String) request.getSession().getAttribute(sessionName);
        String realPath = resourcesParsingService.queryAvatarPathByUserAccountStr(userAccountStr);

        String[] arr = realPath.split("\\\\");
        realPath = "/static/img/avatar/"+arr[arr.length - 1];
        System.out.println("VVVVVVVVVVVVVVVVV");
        System.out.println("readPath："+realPath);
        return realPath;
    }
}
