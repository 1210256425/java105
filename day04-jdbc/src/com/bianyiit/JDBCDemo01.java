package com.bianyiit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Steel.D虫洞时空
 * @Date: 2019-8-22 9:35
 * @Version 1.0
 */
public class JDBCDemo01 {
    public static void main(String[] args) {
//        1. 导入驱动jar包 mysql-connector-java-5.1.37-bin.jar'
        Connection connection = null;
        Statement statement = null;
        try {
            //2. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3. 获取数据库连接对象 Connection
            //url  要连接的一个数据库 localhost代表ip地址：3306 端口号 db2是数据库
            connection = DriverManager.getConnection("jdbc:mysql://lcoalhost:3306/db2", "root", "123");
            //4. 定义sql
            String sql = "UPDATE emp SET salary =salary-1000 WHERE id =1001";
            //  5. 获取执行sql语句的对象 Statement
            statement = connection.createStatement();
            //6. 执行sql，接受返回结果
            int i = statement.executeUpdate(sql);
            // 7. 处理结果
            System.out.println("影响了" + i + "行");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //8. 释放资源
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }
}
