package com.learn.service.impl;

import com.learn.bean.Maintain;
import com.learn.dao.MaintainDao;
import com.learn.dao.impl.MaintainDaoImpl;
import com.learn.service.MaintainService;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: MaintainServiceImpl
 * @create 2023-04-07 19:26
 * @Description:
 */
public class MaintainServiceImpl implements MaintainService {
    private MaintainDao maintainDao = new MaintainDaoImpl();
    @Override
    public List<Maintain> getAllMaintain() {
        return maintainDao.getAllMaintain();
    }

    @Override
    public Maintain getMaintainById(String id) {
        return maintainDao.getMaintainById(id);
    }

    @Override
    public List<Maintain> getMaintainByMaintainer(String maintainer) {
        return maintainDao.getMaintainByMaintainer(maintainer);
    }

    @Override
    public int save(Maintain maintain) {
        return maintainDao.save(maintain);
    }

    @Override
    public int update(Maintain maintain) {
        return maintainDao.update(maintain);
    }

    @Override
    public int delete(String id) {
        return maintainDao.delete(id);
    }
}
