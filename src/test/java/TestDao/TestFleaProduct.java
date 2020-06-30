package TestDao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.BinGCU.dao.FleaProductMapper;
import top.BinGCU.dao.UserMapper;
import top.BinGCU.pojo.FleaProduct;

import java.util.Iterator;
import java.util.List;

public class TestFleaProduct {

    @Test
    public void obtainAllFleaProductTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        FleaProductMapper productMapper = applicationContext.getBean(FleaProductMapper.class);

        List<FleaProduct> fleaProductsList = productMapper.obtainAllFleaProduct();

        Iterator<FleaProduct> iterator = fleaProductsList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    @Test
    public void obtainAllTitleAndPriceAndDateTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        FleaProductMapper productMapper = applicationContext.getBean(FleaProductMapper.class);

        List<FleaProduct> fleaProducts = productMapper.obtainAllTitleAndPriceAndDate();

        for (FleaProduct fleaProduct : fleaProducts) {
            System.out.println("Flea Product："+fleaProduct);
        }


    }
}
