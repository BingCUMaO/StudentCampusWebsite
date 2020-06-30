package top.BinGCU.service.Impl;

import org.springframework.context.ApplicationContext;
import top.BinGCU.dao.UserMapper;
import top.BinGCU.pojo.User;
import top.BinGCU.Util.ApplicationContextShortcut;
import top.BinGCU.service.AccountService;

import java.util.UUID;

/**
 *  Provide the services about operating account.
 *  <p> The class implement some simply functions
 *  about account service.</p>
 *
 * @author BinGCU
 * @version 1.0
 */
public class AccountServiceImpl implements AccountService {
      private ApplicationContext applicationContext;

     public AccountServiceImpl() {
          this.applicationContext = ApplicationContextShortcut.getInstance();
     }

     /**
      * To check to see if the account exists in the database.
      *
      * @param account User' s account string
      * @return return true if the account string exist in the database
      */
     @Override
     public  boolean exist(String account){
          UserMapper userMapper = applicationContext.getBean(UserMapper.class);
          User user = userMapper.queryUserByUserAccount(account);

          if (user==null) return false;
          else return true;
     }

     /**
      * Generate one new account string for caller.
      *
      * @return return the new account string
      */
     @Override
     public  String generateNewAccountString(){
          return UUID.randomUUID().toString().replace("-", "").substring(0, 19);
     }

     /**
      * Create one new user account for user.
      * The operation will insert one log into the database to save information of user.
      *
      * @param user the user's information that will being loaded
      * @return return {@code true} if it is successful to be created
      */
     @Override
     public  boolean createNewUserAccount(User user){
          UserMapper userMapper = applicationContext.getBean(UserMapper.class);
          int affectNum = userMapper.insertOneUser(user);

          if (affectNum==1) return true;
          else return false;
     }


     /**
      * Obtain the user name by user account string .
      *
      * @param userAccountStr
      * @return
      */
     @Override
     public String getUserName(String userAccountStr){
          UserMapper userMapper = applicationContext.getBean(UserMapper.class);

          String userName = userMapper.queryUserNameByUserAccountStr(userAccountStr);
          return userName;
     }

     /**
      * Obtain user' s revealable information for class {@link top.BinGCU.vo.UserVO}
      * which is as view layer object.
      *
      * @param userAccountStr
      * @return return type {@link User} which as pojo layer object
      */
     @Override
     public User getRevealableUserMessages(String userAccountStr) {
          UserMapper userMapper = applicationContext.getBean(UserMapper.class);

          User user = userMapper.queryUserByUserAccount(userAccountStr);
          return user;
     }
}
