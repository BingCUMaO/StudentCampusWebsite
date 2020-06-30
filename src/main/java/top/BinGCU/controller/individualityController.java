package top.BinGCU.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.BinGCU.Util.VoPojoConverter;
import top.BinGCU.pojo.User;
import top.BinGCU.service.AccountService;
import top.BinGCU.service.Impl.AccountServiceImpl;
import top.BinGCU.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Manager request of individual center html page.
 *
 * @author BinGCU
 * @version 1.0
 */
@Controller
public class individualityController {
    private AccountService accountService = new AccountServiceImpl();
    private static String sessionName = "userAccountStr";


    public individualityController() {
    }

    /**
     * Lead the home html page to the individual center html page.
     * @return Forward to "/html/individualCenter"
     */
    @RequestMapping("/individual/center")
    public String individualPage(){
        return "/html/individualCenter";
    }

    /**
     * Obtain the the user's revealable information. Then show on the user' s individual
     * center html page.
     * @param request
     * @return user' s revealable information
     * @throws JsonProcessingException
     */
    @PostMapping(value = "/individual/center/loader/msg", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String revealableUserMessages(HttpServletRequest request) throws JsonProcessingException {
        HttpSession session = request.getSession();
        String userAccountStr = (String) session.getAttribute(sessionName);

        if (userAccountStr != null) {
            User user = accountService.getRevealableUserMessages(userAccountStr);
            UserVO userVO = VoPojoConverter.pojoToVo(user);

            //define jackson convertor object
            ObjectMapper objectMapper = new ObjectMapper();
            String result = objectMapper.writeValueAsString(userVO);

            return result;
        } else {
            return "";
        }
    }

}
