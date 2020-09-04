package com.bianyiit;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author: Steel.D虫洞时空
 * @Date: 2019-8-22 15:48
 * @Version 1.0
 */
public class JDBCDemo05 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2/获得连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "123");
            //3、定义sql select * from tuser where name ='aa' and password =‘123’
            // select * from tuser where  name ='dd' and password ='dd' or 'a'='a';
            String sql = "select * from tuser where  name = '"+name+"' and password = '"+password;
           // String sql = "select * from tuser where name ='aa' and password ='123'";
            //4、获得执行sql的对象
            statement = connection.createStatement();  //.var 或者 ctrl+alt+v
            //5/执行sql获得结果集
            resultSet = statement.executeQuery(sql);
            //6、处理结果集
           if (resultSet.next()){
               System.out.println("登录成功");
           }else{
               System.out.println("登录失败");
           }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    }
}
