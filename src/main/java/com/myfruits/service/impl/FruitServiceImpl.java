package com.myfruits.service.impl;

import com.myfruits.dao.FruitDao;
import com.myfruits.dao.impl.FruitDaoImpl;
import com.myfruits.domain.Fruit;
import com.myfruits.service.FruitService;

import java.util.List;

public class FruitServiceImpl implements FruitService {

    private FruitDao fruitDao = new FruitDaoImpl();
    @Override
    public List<Fruit> findHot() {
        return fruitDao.findHot();
    }

    @Override
    public Fruit findById(int fid) {
        return fruitDao.findById(fid);
    }

    @Override
    public List<Fruit> findByStr(String str) {
        return fruitDao.findByStr(str);
    }

    @Override
    public List<Fruit> findAll() {
        return fruitDao.findAll();
    }

    @Override
    public boolean add(Fruit fruit) {
        int num = fruitDao.add(fruit);
        if (num ==1){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean update(Fruit fruit) {
        int num = fruitDao.update(fruit);
        if (num ==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean del(int fid) {
        int num = fruitDao.del(fid);
        if (num ==1){
            return true;
        }else {
            return false;
        }
    }
}
