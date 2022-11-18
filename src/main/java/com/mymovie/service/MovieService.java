package com.mymovie.service;

import com.mymovie.entity.Movie;

import java.util.List;

public interface MovieService {
    /**
     * 根据电影状态查询电影
     * @param movieState
     * @return
     */
    List<Movie> findAllMovies(int movieState);

    /**
     * 根据票房进行排序
     * @return
     */
    List<Movie> sortMovieByBoxOffice();

    /**
     * 根据热门进行排序
     * @return
     */
    List<Movie> sortMovieByCommentCount();

    /**
     * 根据上映时间进行排序
     * @return
     */
    List<Movie> sortMovieByReleaseDate();

    /**
     * 根据评价排序
     * @return
     */
    List<Movie> sortMovieByScore();

    /**
     * 根据电影类型进行查找
     * @param type
     * @return
     */
    List<Movie> findMoviesByType(String type);

    /**
     * 根据ID查询电影详情
     * @param movieId
     * @return
     */
    Movie findMovieById(long movieId);
}
