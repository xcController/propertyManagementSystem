package com.learn.dao;

import com.learn.bean.Notice;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: NoticeDao
 * @create 2023-04-06 21:13
 * @Description:
 */
public interface NoticeDao {
    List<Notice> getAllNotice();
    Notice getNoticeById(String id);

    int save(Notice notice);
    int update(Notice notice);
    int delete(String id);

}
