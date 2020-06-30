package top.BinGCU.service;

import top.BinGCU.pojo.User;


/**
 *  Provide the services about operating account.
 *
 * @author BinGCU
 * @version 1.0
 */
public interface AccountService {
    /**
     * To check to see if the account exists in the database.
     *
     * @param account User' s account string
     * @return return true if the account string exist in the database
     */
    boolean exist(String account);

    /**
     * Generate one new account string for caller.
     *
     * @return return the new account string
     */
    String generateNewAccountString();

    /**
     * Create one new user account for user.
     * The operation will insert one log into the database to save information of user.
     *
     * @param user the user's information that will being loaded
     * @return return true if it is successful to be created
     */
    boolean createNewUserAccount(User user);

    /**
     * Obtain the user name by user account string .
     *
     * @param userAccountStr
     * @return
     */
    String getUserName(String userAccountStr);

    /**
     * Obtain user' s revealable information for class {@link top.BinGCU.vo.UserVO}
     * which is as view layer object.
     *
     * @param userAccountStr
     * @return return type {@link User} which as pojo layer object
     */
    User getRevealableUserMessages(String userAccountStr);
}
