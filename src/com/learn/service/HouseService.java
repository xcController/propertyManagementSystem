package com.learn.service;

import com.learn.bean.House;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: HouseService
 * @create 2023-04-07 18:01
 * @Description:
 */
public interface HouseService {
    List<House> getAllHouse();
    List<House> getHouseByOwnerid(String id);
    House getHouseById(String id);

    int save(House house);
    int update(House house);
    int delete(String id);
}

