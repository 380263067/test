package com.ydgk.dao;

import org.junit.Test;

import javax.xml.crypto.Data;
import java.sql.*;

public class UserDao {
    String url="jdbc:mysql:///stu?serverTimezone=UTC";
    String username="root";
    String password="123456";

    public Connection getConnection() throws Exception {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
   //利用陈述对象访问数据库 connection.createStatement();
    @Test
    public void statementTest() throws Exception {
        Connection connection=getConnection();
        Statement st = connection.createStatement();
        String sql="insert into usertbl values('aaa',"+"'123456') ";
        int i = st.executeUpdate(sql);
        System.out.println("i = " + i);
        connection.close();
    }
    //预编译陈述对象访问数据库 connection.prepareStatement();
@Test
    public void testPrepareStatement() throws Exception {
        Connection connection=getConnection();
     //增加
     String sql="insert into usertbl values(?,?)";
    PreparedStatement pst = connection.prepareStatement(sql);
    pst.setString(1,"bbb");
    pst.setString(2,"000000");
    int row = pst.executeUpdate();
    System.out.println("row = " + row);
    connection.close();

}
//对于dml(修改)要使用显示的事务处理
@Test
    public void testUpdate() throws Exception {
    Connection connection=null;
        try {
            connection = getConnection();
            //开始事务；
            connection.setAutoCommit(false);
            String sql="update usertbl set pass=? where username=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,"123456");
            pst.setString(2,"bbb");
            int i = pst.executeUpdate();
            connection.commit();

        }catch (Exception e){
            connection.rollback();
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
}
 @Test
    public void  testQuery() throws Exception {
     Connection connection = getConnection();
     String sql="select username, pass from usertbl ";
     PreparedStatement pst = connection.prepareStatement(sql);
     //查询的结果返回的是ResultSet接口对象，称为结果集对象，可以看作一个迭代器
     ResultSet rs = pst.executeQuery();
     //结果集对象查询元数据
     ResultSetMetaData metaData = rs.getMetaData();
     int columnCount = metaData.getColumnCount();
     //从结果中取记录遍历while
     while (rs.next()){
      /*   String name = rs.getString(1);
         String pass = rs.getString(2);
         System.out.println(name+" "+pass);*/
      //动态的查询数据
         for (int i = 1; i <= columnCount; i++) {
             System.out.print(rs.getObject(metaData.getColumnName(i)));
         }
         System.out.println("\r\n");
     }
     connection.close();
 }
}


