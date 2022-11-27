package com.myfruits.service.impl;

import com.myfruits.dao.CartDao;
import com.myfruits.dao.impl.CartDaoImpl;
import com.myfruits.domain.Shop;
import com.myfruits.service.CartService;

public class CartSerViceImp implements CartService {

    private CartDao cartDao = new CartDaoImpl();

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
    public int del(int uid, int fid) {
        return 0;
    }

    @Override
    public Shop find(int uid, int fid) {
        return cartDao.find(uid, fid);
    }
}
