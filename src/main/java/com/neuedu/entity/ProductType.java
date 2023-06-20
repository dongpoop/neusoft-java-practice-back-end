package com.neuedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductType implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer typeId;
    private String typeName;
    private String typeImage;
}
