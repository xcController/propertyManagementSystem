package test;

import com.learn.bean.Admin;
import com.learn.dao.impl.AdminDaoImpl;
import com.learn.util.MD5Util;
import org.junit.jupiter.api.Test;



/**
 * @author shkstart
 * @ClassName: AdminDaoImplTest
 * @create 2023-04-05 15:36
 * @Description:
 */
class AdminDaoImplTest {

    private AdminDaoImpl adminDao =  new AdminDaoImpl();

    @Test
    void getAllAdmin() {
        System.out.println(adminDao.getAllAdmin());
    }

    @Test
    void save() {
        System.out.println(adminDao.save(new Admin("张三", "123456", "男", 25,
                "324776", "赣州", "", "2")));
    }

    @Test
    void getAdminById() {
        System.out.println(adminDao.getAdminById("2"));
        System.out.println(adminDao.getAdminById("3"));
    }

    @Test
    void getAdminByNameAndPassword() {
        System.out.println(adminDao.getAdminByNameAndPassword("admin", "root"));
        System.out.println(adminDao.getAdminByNameAndPassword("admin", "1234567"));
    }

    @Test
    void update() {
        System.out.println(adminDao.update(new Admin(5,"李四", MD5Util.encode("123456"), "男", 25,
                "324776", "赣州", "", "2")));
    }

    @Test
    void delete() {
        System.out.println(adminDao.delete("4"));
    }
}