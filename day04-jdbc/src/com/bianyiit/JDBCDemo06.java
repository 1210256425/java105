package com.bianyiit;

import com.bianyiit.utis.JDBCUtil;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author: Steel.D虫洞时空
 * @Date: 2019-8-22 16:08
 * @Version 1.0
 */
public class JDBCDemo06 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        try {
          /*  //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2/获得连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "123");*/
            connection = JDBCUtil.getConn();
            //3、定义sql select * from tuser where name ='aa' and password =‘123’
            // select * from tuser where  name ='dd' and password ='dd' or 'a'='a';
            String sql = "select * from tuser where  name = ? and password= ?";
            // String sql = "select * from tuser where name ='aa' and password ='123'";
            //4、获得执行sql的对象
            statement = connection.prepareStatement(sql);//.var 或者 ctrl+alt+v
            statement.setString(1,name);
            statement.setString(2,password);
            //5/执行sql获得结果集
            ResultSet resultSet1 = statement.executeQuery();
            //6、处理结果集
            if (resultSet1.next()){
                System.out.println("登录成功");
            }else{
                System.out.println("登录失败");
            }

        } /*catch (ClassNotFoundException e) {
            e.printStackTrace();
        } */catch (SQLException e) {
            e.printStackTrace();
        } finally {
           JDBCUtil.close(connection,statement,resultSet);
        }

    }
}
