package top.BinGCU.service.Impl;

import org.springframework.context.ApplicationContext;
import top.BinGCU.Util.ApplicationContextShortcut;
import top.BinGCU.Util.VoPojoConverter;
import top.BinGCU.dao.FleaProductImgPathMapper;
import top.BinGCU.dao.FleaProductMapper;
import top.BinGCU.pojo.FleaProduct;
import top.BinGCU.service.FleaProductService;
import top.BinGCU.vo.FleaProductCoverVO;

import java.util.LinkedList;
import java.util.List;

public class FleaProductServiceImpl  implements FleaProductService {
    private ApplicationContext applicationContext;

    public FleaProductServiceImpl() {
        applicationContext = ApplicationContextShortcut.getInstance();
    }

    @Override
    public List<FleaProductCoverVO> obtainCovers() {
        FleaProductMapper productMapper = applicationContext.getBean(FleaProductMapper.class);

        List<FleaProduct> fleaProducts = productMapper.obtainAllTitleAndPriceAndDate();

        List<FleaProductCoverVO> covers = new LinkedList<>();
        for (FleaProduct fleaProduct : fleaProducts) {
            FleaProductCoverVO fpc = VoPojoConverter.pojoToVo(fleaProduct);

            covers.add(fpc);
        }

        return covers;
    }
}
