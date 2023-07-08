package test;

import com.learn.bean.Customer;
import com.learn.dao.CustomerDao;
import com.learn.dao.impl.CustomerDaoImpl;
import com.learn.util.MD5Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author shkstart
 * @ClassName: CustomerDaoImplTest
 * @create 2023-04-06 15:28
 * @Description:
 */
class CustomerDaoImplTest {

    private CustomerDao customerDao = new CustomerDaoImpl();

    @Test
    void getAllCustomer() {
        System.out.println(customerDao.getAllCustomer());
    }

    @Test
    void getCustomerById() {
        System.out.println(customerDao.getCustomerById("7"));
    }

    @Test
    void getCustomerByUsernameAndPassword() {
        System.out.println(customerDao.getCustomerByUsernameAndPassword("张三", MD5Util.encode("root")));
        System.out.println(customerDao.getCustomerByUsernameAndPassword("张三三", MD5Util.encode("123456")));
    }

    @Test
    void save() {
        for (int i = 0;i < 100;i++) {
            customerDao.save(new Customer("王" + i,MD5Util.encode("123456"),
                    Integer.toString(1000+i), "珠穆朗玛峰"));
        }
    }

    @Test
    void update() {
        System.out.println(customerDao.update(new Customer(5, "王老六", MD5Util.encode("12356"),
                "3122214", "三清山")));
    }

    @Test
    void delete() {
        System.out.println(customerDao.delete("6"));
    }
}