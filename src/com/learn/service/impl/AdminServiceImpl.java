package com.learn.service.impl;

import com.learn.bean.Admin;
import com.learn.dao.AdminDao;
import com.learn.dao.impl.AdminDaoImpl;
import com.learn.service.AdminService;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: AdminServiceImpl
 * @create 2023-04-05 16:41
 * @Description:
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public List<Admin> getAllAdmin() {
        return adminDao.getAllAdmin();
    }

    @Override
    public int save(Admin a) {
        return adminDao.save(a);
    }

    @Override
    public Admin getAdminById(String id) {
        return adminDao.getAdminById(id);
    }

    @Override
    public Admin getAdminByNameAndPassword(String name, String password) {
        return adminDao.getAdminByNameAndPassword(name,password);
    }

    @Override
    public int update(Admin a) {
        return adminDao.update(a);
    }

    @Override
    public int delete(String id) {
        return adminDao.delete(id);
    }
}
