package com.learn.dao;

import com.learn.bean.House;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: HouseDao
 * @create 2023-04-06 19:51
 * @Description:
 */
public interface HouseDao {
    List<House> getAllHouse();
    List<House> getHouseByOwnerid(String id);
    House getHouseById(String id);

    int save(House house);
    int update(House house);
    int delete(String id);
}
