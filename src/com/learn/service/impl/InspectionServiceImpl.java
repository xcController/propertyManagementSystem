package com.learn.service.impl;

import com.learn.bean.Inspection;
import com.learn.dao.InspectionDao;
import com.learn.dao.impl.InspectionDaoImpl;
import com.learn.service.InspectionService;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: InspectionServiceImpl
 * @create 2023-04-07 19:05
 * @Description:
 */
public class InspectionServiceImpl implements InspectionService {
    private InspectionDao inspectionDao = new InspectionDaoImpl();
    @Override
    public List<Inspection> getAllInspection() {
        return inspectionDao.getAllInspection();
    }

    @Override
    public Inspection getInspectionById(String id) {
        return inspectionDao.getInspectionById(id);
    }

    @Override
    public int save(Inspection i) {
        return inspectionDao.save(i);
    }

    @Override
    public int update(Inspection i) {
        return inspectionDao.update(i);
    }

    @Override
    public int delete(String id) {
        return inspectionDao.delete(id);
    }
}
