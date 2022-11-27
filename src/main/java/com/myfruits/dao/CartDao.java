package com.myfruits.dao;

import com.myfruits.domain.Fruit;
import com.myfruits.domain.Shop;

import java.util.List;

public interface CartDao {

    /**
     * 加入购物车或者关注
     *
     * @param uid
     * @param shop
     * @return
     */
    int add(int uid, Shop shop);

    /**
     * 更新数据
     *
     * @param uid
     * @param shop
     * @return
     */
    int update(int uid, Shop shop);

    /**
     * 从购物车删除或者取消关注
     *
     * @param uid
     * @param fid
     * @return
     */
    int del(int uid, int fid);

    /**
     * 查看购物车或者关注列表中是否存在该商品
     *
     * @param uid
     * @param fid
     * @return
     */
    Shop find(int uid, int fid);

    /**
     * 根据uid查询购物车列表或者关注列表
     *
     * @param uid
     * @return
     */
    List<Shop> findByUid(int uid);

}
