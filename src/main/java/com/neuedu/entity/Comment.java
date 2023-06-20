package com.neuedu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Comment {

    @TableId(type = IdType.AUTO)
    private Integer commentId;

    private Integer userId;
    private Integer productId;
    private String content;
    private Integer score;

    private Date commentTime;
}
