package com.bianyiit.utis;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: Steel.D虫洞时空
 * @Date: 2019-8-22 16:43
 * @Version 1.0
 * 工具类，用于简化jdbc的一些常用代码，是的代码可阅读性更高
 */
public class JDBCUtil {
    private static String url;
    private static String username;
    private static String password;
    private static String driver;

    static {
        try {
            //创建一个properties用于加载配置文件
            Properties properties = new Properties();
            //获得类加载器
            ClassLoader classLoader = JDBCUtil.class.getClassLoader();
            //获得资源
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();
            System.out.println(path);
            //加载配置文件
           properties.load(new FileReader(path));
            //赋值
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获得连接的方法
    public  static Connection getConn() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    //释放资源
    public  static  void close(Connection connection, Statement statement, ResultSet resultSet){
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    //释放资源
    public  static  void close(Connection connection, Statement statement){

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
