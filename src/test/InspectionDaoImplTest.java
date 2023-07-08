package test;

import com.learn.bean.Inspection;
import com.learn.dao.InspectionDao;
import com.learn.dao.impl.InspectionDaoImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author shkstart
 * @ClassName: InspectionDaoImplTest
 * @create 2023-04-08 16:51
 * @Description:
 */
class InspectionDaoImplTest {
    private InspectionDao inspectionDao = new InspectionDaoImpl();

    @Test
    void getAllInspection() {
        System.out.println(inspectionDao.getAllInspection());
    }

    @Test
    void getInspectionById() {
        System.out.println(inspectionDao.getInspectionById("1"));
    }

    @Test
    void save() {
        System.out.println(inspectionDao.save(new Inspection("李四", "清洁", "2023-04-05", "李四", "李四", "处理完成", "")));

    }

    @Test
    void update() {
        System.out.println(inspectionDao.update(new Inspection(2,"王五", "清洁", "2023-04-05", "李四", "李四", "处理完成", "")));
    }

    @Test
    void delete() {
        inspectionDao.delete("3");
    }
}