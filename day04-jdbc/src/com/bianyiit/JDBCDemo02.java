package com.bianyiit;

import java.sql.*;

/**
 * @Author: Steel.D虫洞时空
 * @Date: 2019-8-22 11:34
 * @Version 1.0
 */
public class JDBCDemo02 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement =null;
        ResultSet resultSet=null;
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2/获得连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "123");
            //3、定义sql
            String sql = "select ename from emp where id=1001";
            //4、获得执行sql的对象
            statement = connection.createStatement();  //.var 或者 ctrl+alt+v
            //5/执行sql获得结果集
            resultSet= statement.executeQuery(sql);
            //6、处理结果集
            while (resultSet.next()){
                String ename = resultSet.getString("ename");
                System.out.println(ename);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet!=null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
