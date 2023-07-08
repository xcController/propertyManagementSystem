package com.learn.dao.impl;

import com.learn.bean.Inspection;
import com.learn.dao.InspectionDao;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: InspectionDaoImpl
 * @create 2023-04-07 17:59
 * @Description:
 */
public class InspectionDaoImpl extends BaseDao implements InspectionDao {
    @Override
    public List<Inspection> getAllInspection() {
        String sql = "select id,person,type,date_format(itime,'%Y-%m-%d') itime,conductor,party,result,note" +
                " from inspection order by itime";
        return queryForList(Inspection.class,sql);
    }

    @Override
    public Inspection getInspectionById(String id) {
        String sql = "select id,person,type,date_format(itime,'%Y-%m-%d') itime,conductor,party,result,note" +
                " from inspection where id = ?";
        return queryOne(Inspection.class,sql,id);
    }

    @Override
    public int save(Inspection i) {
        String sql = "insert into inspection(person,type,itime,conductor,party,result,note) values(?,?,str_to_date(?,'%Y-%m-%d'),?,?,?,?)";
        return update(sql,i.getPerson(),i.getType(),i.getItime(),i.getConductor(),i.getParty(),i.getResult(),i.getNote());
    }

    @Override
    public int update(Inspection i) {
        String sql = "update inspection set person = ?,type = ?,itime = str_to_date(?,'%Y-%m-%d'),conductor = ?," +
                "party = ?,result = ?,note = ? where id = ?";
        return  update(sql,i.getPerson(),i.getType(),i.getItime(),i.getConductor(),i.getParty(),i.getResult(),i.getNote(),i.getId());
    }

    @Override
    public int delete(String id) {
        String sql = "delete from inspection where id = ?";
        return update(sql,id);
    }
}
