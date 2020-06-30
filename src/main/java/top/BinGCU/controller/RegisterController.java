package top.BinGCU.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.BinGCU.pojo.User;
import top.BinGCU.service.AccountService;
import top.BinGCU.service.Impl.AccountServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

/**
 * Manager the transaction about registering operation.
 *
 * @author BinGCU
 * @version 1.0
 */
@Controller
public class RegisterController {
    private static AccountService accountService = new AccountServiceImpl();

    public RegisterController() {
    }

    /**
     * Lead the home html page to the register html page.
     * @return Foward to '/html/register'
     */
    @RequestMapping("/registerPage")
    public String registerPage(){
        return "/html/register";
    }


    /**
     *Verify user' s information to check the legality.
     * If passing the verification, it will register one account for user successfully.
     *
     * @param user user' s information
     * @param request
     * @return return just registered account string to front-end browser
     */
    @PostMapping("/register")
    @ResponseBody
    public String register(User user, HttpServletRequest request){

        String failMsg = "fail to register! Please check your messages.";
        String successMsg =  "Successfully!";

//        1、检查前端传过来的数据是否合法
        if(areNull(user.getUserName())||areNull(user.getAge())||areNull(user.getPassword())||areNull(user.getSex()))
            return failMsg;


//        2、随机生成一定规则的账号account，然后检查该新生成的账号是否存在于数据库中，如果存在，则重新生成
        String account;
        do {
            account = accountService.generateNewAccountString();
            System.out.println("The new account："+account);
        } while (accountService.exist(account));
        user.setAccount(account);

//        3、检查avatorPath是否为空，如果为空，则使用默认的头像图片
        String readPath = request.getSession().getServletContext().getRealPath("/WEB-INF/static/img/avatar");

        if (user.getAvatarPath() == null||"".equals(user.getAvatarPath())) {
            user.setAvatarPath(readPath + "\\"+"defaultAvatar.jpg");
        } else {
            user.setAvatarPath(readPath +"\\"+ user.getAvatarPath());
        }
        System.out.println(" user.getAvatarPath："+ user.getAvatarPath());
        System.out.println(user);

//        4、创建新用户
        boolean areSuccessful = accountService.createNewUserAccount(user);
        if (areSuccessful)
            return successMsg+"\n"+"Your account number is : "+account;
        else
            return failMsg;
    }


    /**
     * The method provides upload user' s avatar function when
     * it first started registering.
     *
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/uploadAvatar")
    @ResponseBody
    public String saveAvatar(@RequestParam("avatar") MultipartFile file, HttpServletRequest request) throws IOException {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String uploadFileName = uuid+file.getOriginalFilename();

        if ("".equals(uploadFileName)) return "fail to upload avatar!";

        System.out.println("所上传的文件名："+uploadFileName);

//        上传路径
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/static/img/avatar");
//        如果路径不存在，就创建一个
        File readPath = new File(path);
        if (!readPath.exists())  readPath.mkdirs();

        System.out.println("上传文件的保存地址："+readPath);

        file.transferTo(new File(readPath + "/" + uploadFileName));

        return uploadFileName;
    }


    private boolean areNull(Object obj){
        if (obj==null) return true;
        else return false;
    }
}
