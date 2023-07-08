package com.learn.service;

import com.learn.bean.Notice;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: NoticeService
 * @create 2023-04-07 18:01
 * @Description:
 */
public interface NoticeService {
    List<Notice> getAllNotice();
    Notice getNoticeById(String id);

    int save(Notice notice);
    int update(Notice notice);
    int delete(String id);
}
