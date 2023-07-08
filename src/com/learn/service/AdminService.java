package com.learn.service;

import com.learn.bean.Admin;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: AdminService
 * @create 2023-04-05 16:40
 * @Description:
 */
public interface AdminService {
    List<Admin> getAllAdmin();

    Admin getAdminById(String id);

    Admin getAdminByNameAndPassword(String name,String password);

    int save(Admin a);

    int update(Admin a);

    int delete(String id);
}
