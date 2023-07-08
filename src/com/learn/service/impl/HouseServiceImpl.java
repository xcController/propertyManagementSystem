package com.learn.service.impl;

import com.learn.bean.House;
import com.learn.dao.HouseDao;
import com.learn.dao.impl.HouseDaoImpl;
import com.learn.service.HouseService;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: HouseServiceImpl
 * @create 2023-04-07 18:48
 * @Description:
 */
public class HouseServiceImpl implements HouseService {
    private HouseDao houseDao = new HouseDaoImpl();

    @Override
    public List<House> getAllHouse() {
        return houseDao.getAllHouse();
    }

    @Override
    public List<House> getHouseByOwnerid(String id) {
        return houseDao.getHouseByOwnerid(id);
    }

    @Override
    public House getHouseById(String id) {
        return houseDao.getHouseById(id);
    }

    @Override
    public int save(House house) {
        return houseDao.save(house);
    }

    @Override
    public int update(House house) {
        return houseDao.update(house);
    }

    @Override
    public int delete(String id) {
        return houseDao.delete(id);
    }
}
