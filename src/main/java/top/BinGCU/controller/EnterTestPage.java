package top.BinGCU.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnterTestPage {

    @RequestMapping("/template")
    public String testTemplate(){
        return "/html/template";
    }

    @RequestMapping("/testPage")
    public String toTestPage(){
        return "/html/testPage";
    }
}
