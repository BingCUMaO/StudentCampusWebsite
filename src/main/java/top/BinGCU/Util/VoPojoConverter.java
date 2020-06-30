package top.BinGCU.Util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.BinGCU.dao.FleaProductImgPathMapper;
import top.BinGCU.pojo.FleaProduct;
import top.BinGCU.pojo.User;
import top.BinGCU.vo.FleaProductCoverVO;
import top.BinGCU.vo.UserVO;

/**
 * Provide simply and easy to use function to realize interconversion function
 * between VO object and POJO object.
 *
 * @author BinGCU
 * @version 1.0
 */
public class VoPojoConverter {
    private static ApplicationContext applicationContext;

    static {
        applicationContext = ApplicationContextShortcut.getInstance();
    }

    public VoPojoConverter() {
    }

    public static User voToPojo(UserVO userVO){
        User user = new User();
        user.setUserName(userVO.getUserName());
        user.setAccount(userVO.getAccount());
        user.setSex(userVO.getSex());
        user.setAge(userVO.getAge());
        user.setCreatingAccountDate(userVO.getCreatingAccountDate());

        return user;
    }

    public static UserVO pojoToVo(User user){
        UserVO userVO = new UserVO();
        userVO.setUserName(user.getUserName());
        userVO.setAccount(user.getAccount());
        userVO.setSex(user.getSex());
        userVO.setAge(user.getAge());
        userVO.setCreatingAccountDate(user.getCreatingAccountDate());

        return userVO;
    }

    public static FleaProductCoverVO pojoToVo(FleaProduct fleaProduct){
        FleaProductImgPathMapper productImgPathMapper = applicationContext.getBean(FleaProductImgPathMapper.class);

        FleaProductCoverVO fpc = new FleaProductCoverVO();
        fpc.setTitle(fleaProduct.getTitle());
        fpc.setPrice(fleaProduct.getPrice());
        fpc.setStartTime(fleaProduct.getStartTime());

        String realPath = productImgPathMapper.obtainOneImgPathOfUser(fleaProduct.getProductID());
        String[] arr = realPath.split("\\\\");
        String coverPath = "/static/img/fleaProduct/"+arr[arr.length - 1];
        fpc.setCoverPicurePath(coverPath);

        return fpc;
    }

    public static FleaProduct voToPojo(FleaProductCoverVO fleaProductCoverVO){
        FleaProduct fleaProduct = new FleaProduct();
        fleaProduct.setTitle(fleaProductCoverVO.getTitle());
        fleaProduct.setPrice(fleaProductCoverVO.getPrice());
        fleaProduct.setStartTime(fleaProductCoverVO.getStartTime());

        return fleaProduct;
    }
}
