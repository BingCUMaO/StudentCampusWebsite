package top.BinGCU.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 *
 * @author BinGCU
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int userID;
    private String userName;
    private String account;
    private String password;
    private String sex;
    private int age;
    private LocalDate creatingAccountDate;
    private String avatarPath;
}
