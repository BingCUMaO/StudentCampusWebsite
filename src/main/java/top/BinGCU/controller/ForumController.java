package top.BinGCU.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForumController {

    @RequestMapping("/forumPage")
    public String forumPage(){
        return "/html/forum";
    }

}
