package com.learn.dao.impl;

import com.learn.bean.Customer;
import com.learn.dao.CustomerDao;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: CustomerDaoImpl
 * @create 2023-04-06 15:13
 * @Description:
 */
public class CustomerDaoImpl extends BaseDao implements CustomerDao {
    @Override
    public List<Customer> getAllCustomer() {
        String sql = "select * from custom_account";
        return queryForList(Customer.class,sql);
    }

    @Override
    public Customer getCustomerById(String id) {
        String sql = "select * from custom_account where accountid = ?";
        return queryOne(Customer.class,sql,id);
    }

    @Override
    public Customer getCustomerByUsernameAndPassword(String username, String password) {
        String sql = "select * from custom_account where username = ? and password = ?";

        return queryOne(Customer.class,sql,username,password);
    }

    @Override
    public int save(Customer customer) {

        String sql = "insert into custom_account(username,password,phone,addr) values(?,?,?,?)";

        return update(sql,customer.getUsername(),customer.getPassword(),customer.getPhone(),customer.getAddr());
    }

    @Override
    public int update(Customer customer) {

        String sql = "update custom_account set username = ?,password = ?,phone = ?,addr = ? where accountid = ?";

        return update(sql,customer.getUsername(),customer.getPassword(),customer.getPhone(),customer.getAddr(),customer.getAccountid());
    }

    @Override
    public int delete(String id) {

        String sql = "delete from custom_account where accountid = ?";

        return update(sql,id);
    }
}
