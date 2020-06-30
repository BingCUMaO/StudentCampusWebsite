package top.BinGCU.service.Impl;

import org.springframework.context.ApplicationContext;
import top.BinGCU.Util.ApplicationContextShortcut;
import top.BinGCU.dao.UserMapper;
import top.BinGCU.pojo.User;
import top.BinGCU.service.LoginService;

/**
 *  Provide the services about log in operation.
 *  <p> The class implement some simply functions
 *  about log in operation.</p>
 *
 * @author BinGCU
 * @version 1.0
 */
public class LoginServiceImpl implements LoginService {
    private ApplicationContext applicationContext;

    public LoginServiceImpl() {
        this.applicationContext = ApplicationContextShortcut.getInstance();
    }

    @Override
    public boolean verifyLoginInfo(User user){
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        User found = userMapper.queryUserAccountAndPwd(user);

        if (found==null) return false;
        else return true;
    }
}
