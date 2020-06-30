package top.BinGCU.service;

import top.BinGCU.dao.UserMapper;
import top.BinGCU.pojo.User;

/**
 *  Provide the services about log in operation.
 *
 * @author BinGCU
 * @version 1.0
 */
public interface LoginService {

    boolean verifyLoginInfo(User user);
}
