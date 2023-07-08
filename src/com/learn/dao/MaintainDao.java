package com.learn.dao;

import com.learn.bean.Maintain;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: MaintainDao
 * @create 2023-04-07 16:49
 * @Description:
 */
public interface MaintainDao {

    List<Maintain> getAllMaintain();

    Maintain getMaintainById(String id);

    List<Maintain> getMaintainByMaintainer(String maintainer);

    int save(Maintain maintain);

    int update(Maintain maintain);

    int delete(String id);
}
