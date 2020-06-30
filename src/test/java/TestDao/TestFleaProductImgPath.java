package TestDao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.BinGCU.dao.FleaProductImgPathMapper;

import java.util.List;

public class TestFleaProductImgPath {

    @Test
    public void obtainImgPathOfUserTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        FleaProductImgPathMapper imgPathMapper = applicationContext.getBean(FleaProductImgPathMapper.class);

        List<String> paths = imgPathMapper.obtainImgPathOfUser(2);

        for (String path : paths) {
            System.out.println(path);
        }
    }

    @Test
    public void obtainOneImgPathOfUserTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        FleaProductImgPathMapper imgPathMapper = applicationContext.getBean(FleaProductImgPathMapper.class);

        String path = imgPathMapper.obtainOneImgPathOfUser(1);

        System.out.println("Path："+path);

    }
}
