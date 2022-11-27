package com.myfruits.dao.impl;

import com.myfruits.dao.CartDao;
import com.myfruits.domain.Fruit;
import com.myfruits.domain.Shop;
import com.myfruits.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CartDaoImpl implements CartDao {

    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    @Override
    public int add(int uid, Shop shop) {
        String sql = "insert into shop (uid, fid, isStar, isCart) values (?, ?, ?, ?)";
        Object[] params = {uid, shop.getFid(), shop.isStar(),shop.isCart()};
        try {
            int num = queryRunner.update(sql, new BeanHandler<Shop>(Shop.class), params);
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int update(int uid, Shop shop) {
        String sql = "update shop set isStar=?, isCart=? where uid=? and fid=?";
        Object[] params = {shop.isStar(),shop.isCart(), uid, shop.getFid()};
        try {
            int num = queryRunner.update(sql, new BeanHandler<Shop>(Shop.class), params);
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int del(int uid, int fid) {
        String sql = "delete from shop where fid=? and uid=?";
        Object[] params = {fid, uid};
        try {
            int num = queryRunner.update(sql, params);
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Shop find(int uid, int fid) {
        String sql = "select * from shop where uid=? or fid=?";
        Object[] params = {uid, fid};
        try {
            Shop shop = queryRunner.query(sql, new BeanHandler<Shop>(Shop.class), params);
            return shop;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Shop> findByUid(int uid) {
        String sql = "select * from shop where uid=?";
        Object[] params = {uid};
        try {
            List<Shop> cardList = queryRunner.query(sql, new BeanListHandler<Shop>(Shop.class), params);
            return cardList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
