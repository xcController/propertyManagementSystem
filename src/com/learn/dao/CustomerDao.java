package com.learn.dao;

import com.learn.bean.Customer;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: CustomerDao
 * @create 2023-04-06 15:07
 * @Description:
 */
public interface CustomerDao {
    List<Customer> getAllCustomer();

    Customer getCustomerById(String id);

    Customer getCustomerByUsernameAndPassword(String username,String password);

    int save(Customer customer);

    int update(Customer customer);

    int delete(String id);


}
