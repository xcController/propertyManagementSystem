package com.learn.service;

import com.learn.bean.Carport;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: CarportService
 * @create 2023-04-07 18:01
 * @Description:
 */
public interface CarportService {
    List<Carport> getAllCarport();
    List<Carport> getCarportByOwnerid(String ownerid);
    Carport getCarPortById(String id);


    int save(Carport carport);
    int update(Carport carport);
    int delete(String id);
}
