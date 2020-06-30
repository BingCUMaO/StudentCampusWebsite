package top.BinGCU.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FleaProductCoverVO {

    private String title;
    private double price;
    private LocalDate startTime;
    private String coverPicurePath;

}
