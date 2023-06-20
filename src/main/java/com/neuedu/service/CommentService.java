package com.neuedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.VO.CommentVO;
import com.neuedu.entity.Comment;

import java.util.List;


public interface CommentService extends IService<Comment> {

    //    get comment by productId
    List<CommentVO> getCommentVOList(Integer productId);

}
