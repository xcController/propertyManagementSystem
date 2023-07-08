package com.learn.dao.impl;

import com.learn.bean.Admin;
import com.learn.dao.AdminDao;


import java.util.List;

/**
 * @author shkstart
 * @ClassName: AdminDaoImpl
 * @create 2023-04-05 15:19
 * @Description:
 */
public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public List<Admin> getAllAdmin() {
        String sql = "select * from admin";

        return queryForList(Admin.class,sql);
    }

    @Override
    public int save(Admin a) {
        String sql = "insert into admin(name,password,sex,age,phone,addr,note,perms) values(?,?,?,?,?,?,?,?)";

        return update(sql,a.getName(),a.getPassword(),a.getSex(),a.getAge(),a.getPhone(),
                a.getAddr(),a.getNote(),a.getPerms());
    }

    @Override
    public Admin getAdminById(String id) {

        String sql = "select * from admin where id = ?";

        return queryOne(Admin.class,sql,id);
    }

    @Override
    public Admin getAdminByNameAndPassword(String name, String password) {
        String sql = "select * from admin where name = ? and password = ?";

        return queryOne(Admin.class,sql,name, password);
    }

    @Override
    public int update(Admin a) {
        String sql = "update admin set name = ?,password = ?,sex = ?,age = ?," +
                "phone = ?,addr = ?,note = ?,perms = ? where id = ?";
        return update(sql,a.getName(),a.getPassword(),a.getSex(),a.getAge(),a.getPhone(),
                a.getAddr(),a.getNote(),a.getPerms(),a.getId());
    }

    @Override
    public int delete(String id) {
        String sql = "delete from admin where id = ?";
        return update(sql,id);
    }
}
