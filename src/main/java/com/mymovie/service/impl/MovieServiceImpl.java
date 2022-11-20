package com.mymovie.service.impl;

import com.mymovie.entity.Comment;
import com.mymovie.entity.Movie;
import com.mymovie.entity.User;
import com.mymovie.mapper.CommentMapper;
import com.mymovie.mapper.MovieMapper;
import com.mymovie.mapper.UserMapper;
import com.mymovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Movie> findAllMovies(int movieState) {
        return movieMapper.findAllMovies(movieState);
    }

    @Override
    public List<Movie> sortMovieByBoxOffice() {
        return movieMapper.sortMovieByBoxOffice();
    }

    @Override
    public List<Movie> sortMovieByCommentCount() {
        return movieMapper.sortMovieByCommentCount();
    }

    @Override
    public List<Movie> sortMovieByReleaseDate() {
        return movieMapper.sortMovieByReleaseDate();
    }

    @Override
    public List<Movie> sortMovieByScore() {
        return movieMapper.sortMovieByScore();
    }

    @Override
    public List<Movie> findMoviesByType(String type) {
        return movieMapper.findMoviesByType(type);
    }

    @Override
    public Movie findMovieById(long movieId) {
        Movie movie = movieMapper.findMovieById(movieId);
        // 查询评论列表
        List<Comment> commentList = commentMapper.findCommentByMovieId(movieId);
        if (commentList!=null && commentList.size()>0){
            for (Comment comment: commentList){
                User commentUser = userMapper.findUserById(comment.getUserId());
                comment.setCommentUser(commentUser);
            }
        }
        movie.setCommentList(commentList);
        return movie;
    }

    @Override
    public Integer addMovie(Movie movie) {
        return movieMapper.addMovie(movie);
    }
}
