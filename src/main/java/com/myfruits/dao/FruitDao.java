package com.myfruits.dao;

import com.myfruits.domain.Fruit;

import java.util.List;

public interface FruitDao {

    /**
     * 热卖专区
     * @return
     */
    List<Fruit> findHot();

    /**
     * 根据ID查询水果详情
     * @param fid
     * @return
     */
    Fruit findById(int fid);
}
