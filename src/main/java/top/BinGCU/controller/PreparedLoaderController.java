package top.BinGCU.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.BinGCU.service.AccountService;
import top.BinGCU.service.Impl.AccountServiceImpl;
import top.BinGCU.service.Impl.ResourcesParsingServiceImpl;
import top.BinGCU.service.ResourcesParsingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用来处理每个主页加载时，账号的当前情况。
 * 比如已登陆的（含有Session的）就需要返回头像信息之类的
 *
 * @author BinGCU
 * @version 1.0
 */
@Controller
public class PreparedLoaderController {
    private static String sessionName = "userAccountStr";
    private ResourcesParsingService resourcesParsingService = new ResourcesParsingServiceImpl();
    private AccountService accountService = new AccountServiceImpl();

    /**
     * Do the user session authentication.
     * @param request
     * @return return string which express whether pass authentication.
     */
    @RequestMapping("/preparedLoader/session/verifier")
    @ResponseBody
    public String sessionVerifier(HttpServletRequest request){
        HttpSession session = request.getSession();

        if (session.getAttribute(sessionName) == null)
            return "false";
        else
            return "true";
    }

    /**
     * Only obtain user' s username.
     * @param request
     * @return reuturn username
     */
    @PostMapping(value = "/preparedLoad/obtainable/username",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String obtainUserName(HttpServletRequest request){
        String sessionValue = (String) request.getSession().getAttribute(sessionName);

        if (sessionValue != null) {
            return accountService.getUserName(sessionValue);
        } else {
            return "";
        }
    }

}
