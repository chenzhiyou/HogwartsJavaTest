package com.myfruits.service;

import com.github.javafaker.Bool;
import com.myfruits.domain.Fruit;
import com.myfruits.domain.Shop;

import java.util.List;

public interface CartService {
    /**
     * 加入购物车或者关注
     * @param uid
     * @param shop
     * @return
     */
    Boolean add(int uid, Shop shop);

    /**
     * 更新数据
     * @param uid
     * @param shop
     * @return
     */
    Boolean update(int uid, Shop shop);

    /**
     * 从购物车删除或者取消关注
     * @param uid
     * @param fid
     * @return
     */
    Boolean del(int uid, int fid);

    /**
     * 查看购物车或者关注列表中是否存在该商品
     * @param uid
     * @param fid
     * @return
     */
    Shop find(int uid, int fid);


    /**
     * 根据uid查询购物车列表或者关注列表
     * @param uid
     * @return
     */
    List<Shop> findByUid(int uid);


    /** 显示列表
     * @param uid
     * @param flag 根据这个boolean来决定是显示购物车列表还是我的关注列表
     * @return
     */
    List<Fruit> show(int uid, boolean flag);



}
