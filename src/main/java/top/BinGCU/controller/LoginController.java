package top.BinGCU.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.BinGCU.pojo.User;
import top.BinGCU.service.LoginService;
import top.BinGCU.service.Impl.LoginServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Manager the transaction about loging.
 *
 * @author BinGCU
 * @version 1.0
 */
@Controller
public class LoginController {
    private static LoginService loginService = new LoginServiceImpl();

    /**
     * Global users' session attribute name.
     * Key is attribute name.
     * Value is from user' s browser.
     */
    private static String sessionName = "userAccountStr";

    public LoginController() {
    }

    /**
     * Lead the home html page to the loging html page.
     *
     * @return Forward to "/html/login"
     */
    @RequestMapping("/loginPage")
    public String loginPage(){
        return "/html/login";
    }

    /**
     * Verify user' s session to check the legality.
     * If passing the verification, it will login successfully.
     *
     * @param user Judge whether the obtained account string and password are right
     * @param request
     * @return return the associated status code
     * @throws Exception
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(User user, HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();

        if (session.getAttribute(sessionName)!=null) {
            System.out.println("现在这里的session已存在");
            return "501";
        }

        System.out.println("一开始这里的session是空的");
        boolean areSuccessful = loginService.verifyLoginInfo(user);
        if (areSuccessful) {

            request.setCharacterEncoding("utf-8");
            session.setAttribute(sessionName, user.getAccount());

            return "200";
        } else {
            return "500";
        }
    }

    /**
     * Let the user to log out
     * @param request
     * @return return the associated status code
     */
    @PostMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();

        if (session.getAttribute(sessionName) == null) {
            return "502";
        } else {
            session.removeAttribute(sessionName);
            return "201";
        }
    }

}
