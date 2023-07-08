package com.learn.service;

import com.learn.bean.Maintain;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: MaintainService
 * @create 2023-04-07 18:01
 * @Description:
 */
public interface MaintainService {
    List<Maintain> getAllMaintain();

    Maintain getMaintainById(String id);

    List<Maintain> getMaintainByMaintainer(String maintainer);

    int save(Maintain maintain);

    int update(Maintain maintain);

    int delete(String id);
}
