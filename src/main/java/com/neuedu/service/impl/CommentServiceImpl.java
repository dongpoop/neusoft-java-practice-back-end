package com.neuedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.VO.CommentVO;
import com.neuedu.entity.Comment;
import com.neuedu.entity.User;
import com.neuedu.mapper.CommentMapper;
import com.neuedu.mapper.UserMapper;
import com.neuedu.service.CommentService;
import com.neuedu.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<CommentVO> getCommentVOList(Integer productId) {

        List<CommentVO> commentVOList = new ArrayList<>();

        List<Comment> commentList = this.query().eq("product_id", productId).orderByDesc("comment_time").list();

        for (Comment comment : commentList) {

            CommentVO commentVO = new CommentVO();
            BeanUtils.copyProperties(comment, commentVO);

            User user = userMapper.selectById(comment.getUserId());

            commentVO.setUserName(user.getUserName());
            commentVO.setPhoto(user.getPhoto());
            commentVO.setCommentTime(StringUtil.convertDateTime(comment.getCommentTime()));

            commentVOList.add(commentVO);
        }

        return commentVOList;

    }
}
