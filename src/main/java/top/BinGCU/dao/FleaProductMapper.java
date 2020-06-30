package top.BinGCU.dao;

import top.BinGCU.pojo.FleaProduct;

import java.util.List;

public interface FleaProductMapper {

    List<FleaProduct> obtainAllFleaProduct();

    List<FleaProduct> obtainAllTitleAndPriceAndDate();
}
