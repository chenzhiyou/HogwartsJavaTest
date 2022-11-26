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

    /**
     * 模糊搜索
     * @param str
     * @return
     */
    List<Fruit> findByStr(String str);

    /**
     * 查询所有商品
     * @return
     */
    List<Fruit> findAll();

    /**
     * 添加商品
     * @param fruit
     * @return
     */
    int add(Fruit fruit);

    /**
     * 更新商品
     * @param fruit
     * @return
     */
    int update(Fruit fruit);

    /**
     * 删除商品
     * @param fid
     * @return
     */
    int del(int fid);
}
