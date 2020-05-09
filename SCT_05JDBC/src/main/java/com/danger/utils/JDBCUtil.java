package com.danger.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JDBCUtil {

    private static String url;
    private static String username;
    private static String password;
    private  static String driver;

    static {
        Properties pro = new Properties();
        try {
            pro.load(JDBCUtil.class.getClassLoader().getResourceAsStream("mysql.properties"));
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //注册驱动
            Class.forName(driver);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection(url,username,password);
    }


    /**
     * 释放资源
     *
     * @param conn
     * @param pst
     */
    public static void close(Connection conn, PreparedStatement pst) {

        try {
            if (conn != null) {
                conn.close();
            }
            if (pst != null) {
                pst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 释放资源
     *
     * @param conn
     * @param pst
     * @param rs
     */
    public static void close(Connection conn, PreparedStatement pst, ResultSet rs) {

        try {
            if (conn != null) {
                conn.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
