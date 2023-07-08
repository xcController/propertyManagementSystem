package com.learn.dao;

import com.learn.bean.Inspection;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: InspectionDao
 * @create 2023-04-07 17:58
 * @Description:
 */
public interface InspectionDao {
    List<Inspection> getAllInspection();

    Inspection getInspectionById(String id);

    int save(Inspection i);

    int update(Inspection i);

    int delete(String id);
}
