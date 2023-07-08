package com.learn.dao;

import com.learn.bean.Carport;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: Carport
 * @create 2023-04-07 16:21
 * @Description:
 */
public interface CarportDao {
    List<Carport> getAllCarport();
    List<Carport> getCarportByOwnerid(String ownerid);
    Carport getCarPortById(String id);


    int save(Carport carport );
    int update(Carport carport);
    int delete(String id);
}
