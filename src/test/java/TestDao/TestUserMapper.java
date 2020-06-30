package TestDao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.BinGCU.dao.UserMapper;
import top.BinGCU.pojo.User;

import java.util.UUID;

public class TestUserMapper {
    @Test
    public void insertOneUserTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = new User();
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 19);
        user.setAccount(uuid);
        user.setUserName("小明");
        user.setPassword("~~password~~");
        user.setAge(10);
        user.setSex("man");
        user.setAvatarPath(uuid);

        UserMapper userMapper = applicationContext.getBean(UserMapper.class);

        int i = userMapper.insertOneUser(user);
        System.out.println("影响的行"+i);
    }

    @Test
    public void queryUserByUserAccountTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserMapper userMapper = applicationContext.getBean(UserMapper.class);

        User u1 = userMapper.queryUserByUserAccount("e3adac8b16eb47bdb33");
        System.out.println("CCCCCCCCC："+u1);

    }

    @Test
    public void queryUserAccountAndPwdTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);

        User user01 = new User();
        user01.setAccount("ea7d19158d0b4fa29a6");
        user01.setPassword("a");
        User result01 = userMapper.queryUserAccountAndPwd(user01);


        User user02 = new User();
        user02.setAccount("5c9616a8c7d449b3873");
        user02.setPassword("a");
        User result02 = userMapper.queryUserAccountAndPwd(user02);

        System.out.println(result01);
        System.out.println(result02);
    }

    @Test
    public void queryAvatarPathByUserAccountStrTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);

        String path = userMapper.queryAvatarPathByUserAccountStr("0e689f0aa51a4a14af4");

        System.out.println("Path"+path);
    }

    @Test
    public void queryUserNameByUserAccountStrTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);

        String username = userMapper.queryUserNameByUserAccountStr("6ac37e2936df49cda4a");

        System.out.println("username："+username);
    }
}
