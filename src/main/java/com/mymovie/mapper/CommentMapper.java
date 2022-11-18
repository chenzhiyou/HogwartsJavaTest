package com.mymovie.mapper;

import com.mymovie.entity.Comment;

import java.util.List;

public interface CommentMapper {
    /**
     * 根据电影ID查询评论列表
     * @param movieId
     * @return
     */
    List<Comment> findCommentByMovieId(long movieId);
}
