package com.learn.service;

import com.learn.bean.Inspection;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: InspectionService
 * @create 2023-04-07 18:02
 * @Description:
 */
public interface InspectionService {
    List<Inspection> getAllInspection();

    Inspection getInspectionById(String id);

    int save(Inspection i);

    int update(Inspection i);

    int delete(String id);
}
