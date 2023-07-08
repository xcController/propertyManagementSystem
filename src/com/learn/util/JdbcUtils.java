package com.learn.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DruidDataSource dataSource;

    static {

        try {
            Properties properties = new Properties();

            InputStream is = com.alibaba.druid.util.JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
     * 获取数据库连接池中的连接
     * @return 如果返回null,就是获取失败
     * */
    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }

    /*
     * 关闭连接，并放回数据库连接池
     * */
    public static void close(Connection conn) {

        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//        System.out.println(JdbcUtils.getConnection());
//
//    }
}
