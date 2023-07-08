package com.learn.service.impl;

import com.learn.bean.Carport;
import com.learn.dao.CarportDao;
import com.learn.dao.impl.CarportDaoImpl;
import com.learn.service.CarportService;

import java.util.List;
import java.util.Queue;

/**
 * @author shkstart
 * @ClassName: CarportServiceImpl
 * @create 2023-04-07 18:04
 * @Description:
 */
public class CarportServiceImpl implements CarportService {
    private CarportDao carportDao = new CarportDaoImpl();
    @Override
    public List<Carport> getAllCarport() {
        return carportDao.getAllCarport();
    }

    @Override
    public List<Carport> getCarportByOwnerid(String ownerid) {
        return carportDao.getCarportByOwnerid(ownerid);
    }

    @Override
    public Carport getCarPortById(String id) {
        return carportDao.getCarPortById(id);
    }

    @Override
    public int save(Carport carport) {
        return carportDao.save(carport);
    }

    @Override
    public int update(Carport carport) {
        return carportDao.update(carport);
    }

    @Override
    public int delete(String id) {
        return carportDao.delete(id);
    }
}
