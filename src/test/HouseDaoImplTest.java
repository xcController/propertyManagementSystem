package test;

import com.learn.bean.House;
import com.learn.dao.HouseDao;
import com.learn.dao.impl.HouseDaoImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author shkstart
 * @ClassName: HouseDaoImplTest
 * @create 2023-04-06 20:22
 * @Description:
 */
class HouseDaoImplTest {
    private HouseDao houseDao = new HouseDaoImpl();

    @Test
    void getAllHouse() {
        System.out.println(houseDao.getAllHouse());
    }

    @Test
    void getHouseByOwnerid() {
        System.out.println(houseDao.getHouseByOwnerid("20"));
    }

    @Test
    void getHouseById() {
        System.out.println(houseDao.getHouseById("2"));
    }

    @Test
    void save() {
        System.out.println(houseDao.save(new House("6", "202", "2", "独栋", "江西", "已售",
                "南", "", 20)));
    }

    @Test
    void update() {

        System.out.println(houseDao.update(new House(3, "6", "303", "3", "独栋", "广东", "已售",
                "南", "", 20)));
    }

    @Test
    void delete() {
        System.out.println(houseDao.delete("6"));
    }
}