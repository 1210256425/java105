package com.bianyiit;

import com.bianyiit.domain.Emp;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Steel.D虫洞时空
 * @Date: 2019-8-22 15:14
 * @Version 1.0
 */
public class JDBCDemo04 {

    public static void main(String[] args)throws Exception {
        List<Emp> all = findAll();
        int size = all.size();
        System.out.println(size);
        for (Emp emp : all) {
            System.out.println(emp);
        }
    }

    public  static List<Emp> findAll() throws Exception{
        ArrayList<Emp> emps = new ArrayList<>();
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2/获得连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2", "root", "123");
        //3、定义sql
        String sql = "select id, ename,salary from emp ";
        //4、获得执行sql的对象
       Statement statement = connection.createStatement();  //.var 或者 ctrl+alt+v
        //5/执行sql获得结果集
        ResultSet resultSet= statement.executeQuery(sql);
        //6、处理结果集
        while (resultSet.next()){
            //getXxx
            int id = resultSet.getInt(1);
            String ename = resultSet.getString(2);
            double aDouble = resultSet.getDouble(3);
            //进行数据封装
            Emp emp = new Emp();
            emp.setId(id);
            emp.setEname(ename);
            emp.setSalary(aDouble);
            emps.add(emp);
        }
        //关闭资源
        resultSet.close();
        statement.close();
        connection.close();

        return emps;

    }
}
