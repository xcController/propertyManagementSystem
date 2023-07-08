package com.learn.dao.impl;


import com.learn.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * @author shkstart
 * @ClassName: HouseDaoImpl
 * @create 2023-04-05 15:23
 * @Description:
 */

public abstract class BaseDao {

    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();



    /*
    * @return 如果返回-1说明执行失败,其他值为影响的行数
    * */
    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();

        try {
           return queryRunner.update(connection, sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /*
    * 返回一个JavaBean对象
    * */
    public <T> T queryOne(Class<T> aClass,String sql,Object ... args) {
        Connection connection = JdbcUtils.getConnection();

        try {
           return queryRunner.query(connection,sql,new BeanHandler<>(aClass),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

    /*
    * 查询返回多个JavaBean
    * */

    public <T>List<T> queryForList(Class<T> aClass,String sql,Object ... args) {
        Connection connection = JdbcUtils.getConnection();

        try {
           return queryRunner.query(connection,sql,new BeanListHandler<>(aClass),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }

        return null;
    }

    //返回一行一列的sql语句
    public Object queryForStringValues(String sql,Object ... args) {
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }

        return null;
    }
}
