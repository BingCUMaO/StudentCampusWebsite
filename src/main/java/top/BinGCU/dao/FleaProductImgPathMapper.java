package top.BinGCU.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FleaProductImgPathMapper {

    List<String> obtainImgPathOfUser(@Param("productID") int productID);

    String obtainOneImgPathOfUser(@Param("productID") int productID);

}
