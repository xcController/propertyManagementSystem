package com.learn.dao.impl;

import com.learn.bean.Notice;
import com.learn.dao.NoticeDao;

import java.util.List;

/**
 * @author shkstart
 * @ClassName: NoticeDaoImpl
 * @create 2023-04-06 21:16
 * @Description:
 */
public class NoticeDaoImpl extends BaseDao implements NoticeDao {
    @Override
    public List<Notice> getAllNotice() {
        String sql = "select id,content,date_format(sdate,'%Y-%m-%d') sdate ,title,publisher from notice order by sdate desc";
        return queryForList(Notice.class,sql);
    }

    @Override
    public Notice getNoticeById(String id) {

        String sql = "select id,content,date_format(sdate,'%Y-%m-%d') sdate ,title,publisher from notice where id = ?";
        return queryOne(Notice.class,sql,id);
    }

    @Override
    public int save(Notice notice) {

        String sql = "insert into notice(content,sdate,title,publisher) values(?,str_to_date(?,'%Y-%m-%d'),?,?)";
        return update(sql,notice.getContent(),notice.getSdate(),notice.getTitle(),notice.getPublisher());
    }

    @Override
    public int update(Notice notice) {
        String sql = "update notice set content = ?,sdate=str_to_date(?,'%Y-%m-%d'),title = ?,publisher = ? where id = ?";
        return update(sql,notice.getContent(),notice.getSdate(),notice.getTitle(),notice.getPublisher(),notice.getId());
    }

    @Override
    public int delete(String id) {
        String sql = "delete from notice where id = ?";
        return update(sql,id);
    }
}
