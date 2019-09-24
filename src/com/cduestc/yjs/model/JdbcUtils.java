package com.cduestc.yjs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class JdbcUtils {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://127.0.0.1/test";
   static final String USER = "root";
   static final String PASS = "";
//   static String sql = "SELECT id,name,pwd,email,grade FROM student";
   static String tableName = "student";	

   public static boolean updateUser(String sql){
	 //select * from student where name='haha' and pwd='1234';
	 	   Connection conn = null;
	 	   Statement stmt = null;
	 	   ResultSet rs = null;
	 	   boolean result = false;

	 	   try{
	 		  //加载数据库驱动
	 		  Class.forName(JDBC_DRIVER);
	 		  System.out.println("Connecting to database...");
	 		  //建立客户端和mysql服务的TCP链接
	 		  conn = DriverManager.getConnection(DB_URL,USER,PASS);
	 		  //创建statement对象
	 		  stmt = conn.createStatement();
	 		  //执行查询语句，并且得到查询结果（以ResultSet 对象封装）
	 		  //rs = stmt.executeQuery(sql);
	 		  int count = stmt.executeUpdate(sql);
	          if(count >= 1){
	        	  result = true;
	          }
	 	   }catch(SQLException se){
	 		  result = false;
	 		  se.printStackTrace();
	 	   }catch(Exception e){
	 		  result = false;
	 		  e.printStackTrace();
	 	   }finally{
	 		  //在finally字句中进行资源释放
	 		  try{
	 			  if(rs != null)
	 			      rs.close();
	 			  //rs = null;
	 		  }catch(SQLException e){
	 			  e.printStackTrace();
	 		  }
	 		  try{
	 			 if(stmt!=null)
	 				stmt.close();
	 			 //stmt = null;
	 		  }catch(SQLException e){
	 			  e.printStackTrace();
	 		  }
	 		  try{
	 			 if(conn!=null)
	 				conn.close();
	 			 //conn = null;
	 		  }catch(SQLException se){
	 			 se.printStackTrace();
	 		  }
	 	   }
	 	   System.out.println("Over!");
	 	   return result;
	    }   
   
   public static boolean login(String name, String pwd){
//select * from student where name='haha' and pwd='1234';
	   Connection conn = null;
	   Statement stmt = null;
	   ResultSet rs = null;
	   boolean result = false;

	   try{
		  //加载数据库驱动
		  Class.forName(JDBC_DRIVER);
		  System.out.println("Connecting to database...");
		  //建立客户端和mysql服务的TCP链接
		  conn = DriverManager.getConnection(DB_URL,USER,PASS);
		  //创建statement对象
		  stmt = conn.createStatement();
		  //执行查询语句，并且得到查询结果（以ResultSet 对象封装）
		  String sql = "select * from student where name='" 
			                 + name + "' and pwd='" + pwd + "'";
		  rs = stmt.executeQuery(sql);
          result = rs.next();
	   }catch(SQLException se){
		  se.printStackTrace();
	   }catch(Exception e){
		  e.printStackTrace();
	   }finally{
		  //在finally字句中进行资源释放
		  try{
			  if(rs != null)
			      rs.close();
			  //rs = null;
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
		  try{
			 if(stmt!=null)
				stmt.close();
			 //stmt = null;
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
		  try{
			 if(conn!=null)
				conn.close();
			 //conn = null;
		  }catch(SQLException se){
			 se.printStackTrace();
		  }
	   }
	   System.out.println("Over!");
	   return result;
   }
   
   public static List<UserInfo> getUserList(){
		List<UserInfo> users = new ArrayList<UserInfo>();
		
	   Connection conn = null;
	   Statement stmt = null;
	   ResultSet rs = null;
	   try{
		  //加载数据库驱动
		  Class.forName(JDBC_DRIVER);
		  System.out.println("Connecting to database...");
		  //建立客户端和mysql服务的TCP链接
		  conn = DriverManager.getConnection(DB_URL,USER,PASS);
		  //创建statement对象
		  stmt = conn.createStatement();
		  //执行查询语句，并且得到查询结果（以ResultSet 对象封装）
		  rs = stmt.executeQuery("SELECT id,name,pwd,email,grade FROM student");
		  while(rs.next()){
			 //取出查询结果，并打印
			 String id  = rs.getString("id");
			 String name = rs.getString("name");
			 String pwd = rs.getString("pwd");
			 String email = rs.getString("email");
			 String grade = rs.getString("grade");
			 System.out.print("id: " + id);
			 System.out.print(" name: " + name);
			 System.out.print(" pwd: " + pwd);
			 System.out.print(" email: " + email);
			 System.out.println(" grade: " + grade);
			 UserInfo user = new UserInfo(id, name, pwd, email, grade);
             users.add(user);
		  }
	   }catch(SQLException se){
		  se.printStackTrace();
	   }catch(Exception e){
		  e.printStackTrace();
	   }finally{
		  //在finally字句中进行资源释放
		  try{
			  if(rs != null)
			      rs.close();
			  //rs = null;
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
		  try{
			 if(stmt!=null)
				stmt.close();
			 //stmt = null;
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
		  try{
			 if(conn!=null)
				conn.close();
			 //conn = null;
		  }catch(SQLException se){
			 se.printStackTrace();
		  }
	   }
	   System.out.println("Over!");
		
	   return users;    	
    }
}
