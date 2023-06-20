package com.neuedu.VO;

import lombok.Data;

import java.util.Date;

@Data
public class CommentVO {

    private Integer commentId;
    private String userName;
    private String photo;
    private String content;
    private Integer score;

    private String commentTime;

}
