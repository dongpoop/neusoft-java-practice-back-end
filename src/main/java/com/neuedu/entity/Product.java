package com.neuedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Product implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer productId;

    private Integer typeId;
    private String productName;
    private Integer productPrice;
    private String productImage;
    private Integer productStock;
    private Integer sellCount;
    private Integer isRecommend;

//    @JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒", timezone = "GMT+8")
    private Date createTime;
}
