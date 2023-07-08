package test;

import com.learn.bean.Notice;
import com.learn.dao.NoticeDao;
import com.learn.dao.impl.NoticeDaoImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author shkstart
 * @ClassName: NoticeDaoImplTest
 * @create 2023-04-07 15:31
 * @Description:
 */
class NoticeDaoImplTest {
    private NoticeDao noticeDao = new NoticeDaoImpl();

    @Test
    void getAllNotice() {

        System.out.println(noticeDao.getAllNotice());
    }

    @Test
    void getNoticeById() {
    }

    @Test
    void save() {
        System.out.println(noticeDao.save(new Notice("小测试", "2023-04-07", "测试", "李四")));
    }

    @Test
    void update() {
        noticeDao.update(new Notice(3,"测试", "2023-04-07", "测试", "李四"));

    }

    @Test
    void delete() {
    }
}