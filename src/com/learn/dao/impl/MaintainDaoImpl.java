package com.learn.dao.impl;

import com.learn.bean.Maintain;
import com.learn.dao.MaintainDao;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: MaintainDaoImpl
 * @create 2023-04-07 17:00
 * @Description:
 */
public class MaintainDaoImpl extends BaseDao implements MaintainDao {
    @Override
    public List<Maintain> getAllMaintain() {
        String sql = "select id,thing,status,homesnumber,date_format(sdate,'%Y-%m-%d') sdate, date_format(enddate," +
                "'%Y-%m-%d') enddate,precost,relcost,maintainer,note from maintain order by sdate";
        return queryForList(Maintain.class,sql);
    }

    @Override
    public Maintain getMaintainById(String id) {
        String sql = "select id,thing,status,homesnumber,date_format(sdate,'%Y-%m-%d') sdate, date_format(enddate," +
                "'%Y-%m-%d') enddate,precost,relcost,maintainer,note from maintain where id = ?";
        return queryOne(Maintain.class,sql,id);
    }

    @Override
    public List<Maintain> getMaintainByMaintainer(String maintainer) {
        String sql = "select id,thing,status,homesnumber,date_format(sdate,'%Y-%m-%d') sdate, date_format(enddate," +
                "'%Y-%m-%d') enddate,precost,relcost,maintainer,note from maintain where maintainer = ?";
        return queryForList(Maintain.class,sql,maintainer);
    }

    @Override
    public int save(Maintain maintain) {
        String sql = "insert into maintain(thing,status,homesnumber,sdate,enddate,precost,relcost,maintainer,note) " +
                "values(?,?,?,str_to_date(?,'%Y-%m-%d'),str_to_date(?,'%Y-%m-%d'),?,?,?,?)";
        return update(sql,maintain.getThing(),maintain.getStatus(),maintain.getHomesnumber(),maintain.getSdate(),
                maintain.getEnddate(),maintain.getPrecost(),maintain.getRelcost(),maintain.getMaintainer(),maintain.getNote());
    }

    @Override
    public int update(Maintain maintain) {

        String sql = " update maintain set thing = ?,status = ?,homesnumber = ?,sdate=str_to_date(?,'%Y-%m-%d'),enddate=str_to_date(?,'%Y-%m-%d')," +
                "precost = ?,relcost = ?,maintainer = ?,note = ? where id = ? ";
        return update(sql,maintain.getThing(),maintain.getStatus(),maintain.getHomesnumber(),maintain.getSdate(),
                maintain.getEnddate(),maintain.getPrecost(),maintain.getRelcost(),maintain.getMaintainer(),maintain.getNote(),maintain.getId());
    }

    @Override
    public int delete(String id) {
        String sql = "delete from maintain where id = ?";
        return update(sql,id);

    }
}
