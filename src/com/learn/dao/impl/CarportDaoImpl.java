package com.learn.dao.impl;

import com.learn.bean.Carport;
import com.learn.dao.CarportDao;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: CarportDaoImpl
 * @create 2023-04-07 16:29
 * @Description:
 */
public class CarportDaoImpl extends BaseDao implements CarportDao {
    @Override
    public List<Carport> getAllCarport() {
        String sql = "select * from carport";
        return queryForList(Carport.class,sql);
    }

    @Override
    public List<Carport> getCarportByOwnerid(String ownerid) {
        String sql = "select * from carport where ownerid = ?";
        return queryForList(Carport.class,sql,ownerid);
    }

    @Override
    public Carport getCarPortById(String id) {
        String sql = "select * from carport where id = ?";
        return queryOne(Carport.class,sql,id);
    }

    @Override
    public int save(Carport carport) {

        return 0;
    }

    @Override
    public int update(Carport carport) {
        String sql = "update carport set state = ?,ownerid = ?,phone = ? where id = ?";
        return update(sql,carport.getState(),carport.getOwnerid(),carport.getPhone(),carport.getId());
    }

    @Override
    public int delete(String id) {
        return 0;
    }
}
