package top.BinGCU.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FleaProduct {

    private int productID;
    private String productName;
    private int productFineness;
    private String address;
    private String contactPersonAccount;
    private String title;
    private String description;
    private double price;
    private LocalDate startTime;
    private int quantifyInStock;
}
