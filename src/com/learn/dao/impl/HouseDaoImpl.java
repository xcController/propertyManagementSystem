package com.learn.dao.impl;

import com.learn.bean.House;
import com.learn.dao.HouseDao;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: HouseDaoImpl
 * @create 2023-04-06 19:52
 * @Description:
 */
public class HouseDaoImpl extends BaseDao implements HouseDao {
    @Override
    public List<House> getAllHouse() {
        String sql = "select * from house";
        return queryForList(House.class,sql);
    }

    @Override
    public List<House> getHouseByOwnerid(String id) {
        String sql = "select * from house where ownerid = ?";
        return queryForList(House.class,sql,id);
    }

    @Override
    public House getHouseById(String id) {

        String sql = "select * from house where id = ?";

        return queryOne(House.class,sql,id);
    }

    @Override
    public int save(House house) {
        String sql = "insert into house(num,unit,floor,type,area,sell,direction,note,ownerid) values (?,?,?,?,?,?,?,?,?)";
        return update(sql,house.getNum(),house.getUnit(),house.getFloor(),house.getType(),
                house.getArea(),house.getSell(),house.getDirection(),house.getNote(),house.getOwnerid());
    }

    @Override
    public int update(House house) {
        String sql = "update house set num = ?,unit = ?,floor = ?,type = ?,area = ?," +
                "sell = ?,direction = ?,note = ?,ownerid = ? where id = ?";
        return update(sql,house.getNum(),house.getUnit(),house.getFloor(),house.getType(),
                house.getArea(),house.getSell(),house.getDirection(),house.getNote(),house.getOwnerid(),house.getId());
    }

    @Override
    public int delete(String id) {
        String sql = "delete from house where id = ?";
        return update(sql,id);
    }
}
