package com.learn.dao;

import com.learn.bean.Admin;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: AdminDao
 * @create 2023-04-05 15:04
 * @Description:
 */
public interface AdminDao {

    List<Admin> getAllAdmin();

    Admin getAdminById(String id);

    Admin getAdminByNameAndPassword(String name,String password);

    int save(Admin a);

    int update(Admin a);

    int delete(String id);
}
