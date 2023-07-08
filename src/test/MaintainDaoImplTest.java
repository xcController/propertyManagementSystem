package test;

import com.learn.bean.Maintain;
import com.learn.dao.MaintainDao;
import com.learn.dao.impl.MaintainDaoImpl;
import org.junit.jupiter.api.Test;
import sun.applet.Main;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author shkstart
 * @ClassName: MaintainDaoImplTest
 * @create 2023-04-07 17:24
 * @Description:
 */
class MaintainDaoImplTest {
    private MaintainDao maintainDao = new MaintainDaoImpl();

    @Test
    void getAllMaintain() {
        System.out.println(maintainDao.getAllMaintain());
    }

    @Test
    void getMaintainById() {
        System.out.println(maintainDao.getMaintainById("3"));
    }

    @Test
    void getMaintainByMaintainer() {
        System.out.println(maintainDao.getMaintainByMaintainer("张三"));
    }

    @Test
    void save() {
        for(int i = 0;i < 10;i++) {
            maintainDao.save(new Maintain("灯" + i,"处理完成",Integer.toString(200 + i),"2023-04-" + Integer.toString(i + 10),"2023-04-" + Integer.toString(i + 20),
                    200 + i,100 + i,"张" + i,"记录" + i));
        }
    }

    @Test
    void update() {
        maintainDao.update(new Maintain(17,"门","处理完成","606","2025-05-05","2025-05-09",33,55,
                "李四","拆了"));
    }

    @Test
    void delete() {
        maintainDao.delete("18");

    }
}