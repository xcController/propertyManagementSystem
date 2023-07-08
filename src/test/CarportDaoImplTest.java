package test;

import com.learn.bean.Carport;
import com.learn.dao.CarportDao;
import com.learn.dao.impl.CarportDaoImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author shkstart
 * @ClassName: CarportDaoImplTest
 * @create 2023-04-07 17:52
 * @Description:
 */
class CarportDaoImplTest {
    private CarportDao carportDao = new CarportDaoImpl();

    @Test
    void getAllCarport() {

        System.out.println(carportDao.getAllCarport());
    }

    @Test
    void getCarportByOwnerid() {
        System.out.println(carportDao.getCarportByOwnerid("10"));

    }

    @Test
    void getCarPortById() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
        carportDao.update(new Carport(6,"已出售",10,"45446"));
    }

    @Test
    void delete() {
    }
}