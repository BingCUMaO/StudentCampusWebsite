package top.BinGCU.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private String userName;
    private String account;
    private String sex;
    private int age;
    private LocalDate creatingAccountDate;

}
