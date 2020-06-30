package top.BinGCU.dao;

import org.apache.ibatis.annotations.Param;
import top.BinGCU.pojo.User;

/**
 *
 * @author BinGCU
 * @version 1.0
 */
public interface UserMapper {
    int insertOneUser(@Param("user") User user);

    User queryUserByUserAccount(String userAccount);

    User queryUserAccountAndPwd(@Param("user") User user);

    String queryAvatarPathByUserAccountStr(@Param("account") String userAccountStr);

    String queryUserNameByUserAccountStr(@Param("account") String userAccountStr);
}
