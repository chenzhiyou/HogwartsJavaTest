package com.myfruits.service;

import com.github.javafaker.Bool;
import com.myfruits.domain.Shop;

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
    int del(int uid, int fid);

    /**
     * 查看购物车或者关注列表中是否存在该商品
     * @param uid
     * @param fid
     * @return
     */
    Shop find(int uid, int fid);




}
