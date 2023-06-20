package com.neuedu.VO;

import lombok.Data;

import java.util.Date;

@Data
public class ProductVO {

    private Integer productId;

    private String typeName;
    private String productName;
    private Integer productPrice;
    private String productImage;
    private Integer productStock;
    private Integer sellCount;

    //    @JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒", timezone = "GMT+8")
    private Date createTime;

}
