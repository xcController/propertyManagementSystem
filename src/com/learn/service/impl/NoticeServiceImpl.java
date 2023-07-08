package com.learn.service.impl;

import com.learn.bean.Notice;
import com.learn.dao.NoticeDao;
import com.learn.dao.impl.NoticeDaoImpl;
import com.learn.service.NoticeService;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: NoticeServiceImpl
 * @create 2023-04-07 19:47
 * @Description:
 */
public class NoticeServiceImpl implements NoticeService {
    private NoticeDao noticeDao = new NoticeDaoImpl();

    @Override
    public List<Notice> getAllNotice() {
        return noticeDao.getAllNotice();
    }

    @Override
    public Notice getNoticeById(String id) {
        return noticeDao.getNoticeById(id);
    }

    @Override
    public int save(Notice notice) {
        return noticeDao.save(notice);
    }

    @Override
    public int update(Notice notice) {
        return noticeDao.update(notice);
    }

    @Override
    public int delete(String id) {
        return noticeDao.delete(id);
    }
}
