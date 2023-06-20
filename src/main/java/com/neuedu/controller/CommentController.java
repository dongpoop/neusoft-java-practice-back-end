package com.neuedu.controller;

import com.neuedu.VO.CommentVO;
import com.neuedu.common.ServerResponse;
import com.neuedu.entity.Comment;
import com.neuedu.service.CommentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping("/getCommentVOList/{productId}")
    public ServerResponse getCommentList(@PathVariable Integer productId) {

        List<CommentVO> commentVOList = commentService.getCommentVOList(productId);
        if (commentVOList.size() > 0)
            return ServerResponse.success("").addData("commentVOList", commentVOList);
        else
            return ServerResponse.failure("当前商品还没有评论").addData("commentVOList", commentVOList);
    }
}
