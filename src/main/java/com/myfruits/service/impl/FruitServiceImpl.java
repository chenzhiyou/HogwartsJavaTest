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
}
