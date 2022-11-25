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
}
