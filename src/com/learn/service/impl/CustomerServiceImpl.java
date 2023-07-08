package com.learn.service.impl;

import com.learn.bean.Customer;
import com.learn.dao.CustomerDao;
import com.learn.dao.impl.CustomerDaoImpl;
import com.learn.service.CustomerService;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: CustomerSeriviceIpml
 * @create 2023-04-06 15:52
 * @Description:
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public List<Customer> getAllCustomer() {
        return customerDao.getAllCustomer();
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public Customer getCustomerByUsernameAndPassword(String username, String password) {
        return customerDao.getCustomerByUsernameAndPassword(username,password);
    }

    @Override
    public int save(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public int update(Customer customer) {
        return customerDao.update(customer);
    }

    @Override
    public int delete(String id) {
        return customerDao.delete(id);
    }
}
