package com.myfruits.service.impl;

import com.myfruits.dao.CartDao;
import com.myfruits.dao.FruitDao;
import com.myfruits.dao.impl.CartDaoImpl;
import com.myfruits.dao.impl.FruitDaoImpl;
import com.myfruits.domain.Fruit;
import com.myfruits.domain.Shop;
import com.myfruits.service.CartService;

import java.util.ArrayList;
import java.util.List;

public class CartSerViceImp implements CartService {

    private CartDao cartDao = new CartDaoImpl();
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public Boolean add(int uid, Shop shop) {
        int add = cartDao.add(uid, shop);
        if (add ==1){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Boolean update(int uid, Shop shop) {

        int add = cartDao.update(uid, shop);
        if (add ==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean del(int uid, int fid) {
        int del = cartDao.del(uid, fid);
        if (del == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Shop find(int uid, int fid) {
        return cartDao.find(uid, fid);
    }

    @Override
    public List<Shop> findByUid(int uid) {
        return cartDao.findByUid(uid);
    }

    @Override
    public List<Fruit> show(int uid, boolean flag) {
        List<Shop> shops = findByUid(uid);
        List<Fruit> fruits = new ArrayList<>();
        if (flag){// 那么显示购物车列表
            for (Shop shop:shops){
                if (shop.isCart()){
                    Fruit fruit = fruitDao.findById(shop.getFid());
                    fruits.add(fruit);
                }
            }
        }else {// 显示我的关注列表
            for (Shop shop:shops) {
                if (shop.isStar()) {
                    Fruit fruit = fruitDao.findById(shop.getFid());
                    fruits.add(fruit);
                }
            }
        }
        return fruits;
    }
}
