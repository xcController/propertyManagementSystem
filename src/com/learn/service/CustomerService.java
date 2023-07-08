package com.learn.service;

import com.learn.bean.Customer;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: CustomerService
 * @create 2023-04-06 15:50
 * @Description:
 */
public interface CustomerService {
    List<Customer> getAllCustomer();

    Customer getCustomerById(String id);

    Customer getCustomerByUsernameAndPassword(String username,String password);

    int save(Customer customer);

    int update(Customer customer);

    int delete(String id);
}
