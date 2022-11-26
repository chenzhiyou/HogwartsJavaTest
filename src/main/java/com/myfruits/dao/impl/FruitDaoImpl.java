package com.myfruits.dao.impl;

import com.myfruits.dao.FruitDao;
import com.myfruits.domain.Fruit;
import com.myfruits.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class FruitDaoImpl implements FruitDao {

    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    @Override
    public List<Fruit> findHot() {
        String sql = "select t2.* from hotfruits t1, fruits t2 where t1.fid = t2.fid";
        try {
            List<Fruit> fruitList = queryRunner.query(sql, new BeanListHandler<Fruit>(Fruit.class));
            return fruitList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Fruit findById(int fid) {
        String sql = "select * from fruits where fid= ?";
        Object[] params = {fid};
        try {
            Fruit fruit = queryRunner.query(sql, new BeanHandler<Fruit>(Fruit.class), params);
            return fruit;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Fruit> findByStr(String str) {
        String sql = "select * from fruits where fname like ?";
        Object[] params = {"%"+str+"%"};
        try {
            List<Fruit> fruitsList = queryRunner.query(sql, new BeanListHandler<Fruit>(Fruit.class), params);
            return fruitsList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Fruit> findAll() {
        String sql = "select * from fruits";
        try {
            List<Fruit> fruitsList = queryRunner.query(sql, new BeanListHandler<Fruit>(Fruit.class));
            return fruitsList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(Fruit fruit) {
        String sql = "insert into fruits (fname, spec, up, t1, t2, inum) values (?, ?, ?, ?, ?, ?)";
        Object[] params = {fruit.getFname(), fruit.getSpec(), fruit.getUp(),
        fruit.getT1(), fruit.getT2(), fruit.getInum()};
        try {
            int num = queryRunner.update(sql, params);
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Fruit fruit) {
        String sql = "update fruits fname=?, spec=?, up=?, t1=?, t2=?, inum=? where fid=?";
        Object[] params = {fruit.getFname(), fruit.getSpec(), fruit.getUp(),
                fruit.getT1(), fruit.getT2(), fruit.getInum(), fruit.getFid()};
        try {
            int num = queryRunner.update(sql, params);
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    @Override
    public int del(int fid) {
        String sql = "delete from fruits where fid=? ";
        Object[] params ={fid};
        try {
            int num = queryRunner.update(sql, params);
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }
}
