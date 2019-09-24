package com.cduestc.yjs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cduestc.yjs.model.JdbcUtils;

public class LoginServlet extends HttpServlet {
//http://127.0.0.1:8080/UserManager56/LoginServlet?user_name=hu&pass_word=123
    //构造方法
	public LoginServlet(){
    	System.out.println("LoginServlet 对象被创建了！");
    }

    @Override
    public void init(){
    	System.out.println("LoginServlet 对象被初始化了！");
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 System.out.println("LoginServlet request:" + request.hashCode());
		 System.out.println("当前对象：" + this);
		 String name = request.getParameter("user_name");
		 String pwd = request.getParameter("pass_word");
         System.out.println("name = " + name);
         System.out.println("pwd = " + pwd);
         if(JdbcUtils.login(name, pwd)){
        	 ServletContext ctx = getServletContext();
        	 Integer count = (Integer) ctx.getAttribute("COUNTER");
        	 count++;
        	 ctx.setAttribute("COUNTER", count);
             //登录成功，跳转到LoginSucess.有两种方式：1）重定向；2）转发
        	 //重定向
        	 //response.sendRedirect("/UserManager56/LoginSucess?USER_NAME="+name);
             //转发
        	 //request.setAttribute("COUNTER", count);
        	 request.setAttribute("USER_NAME" , name);
        	 RequestDispatcher disp = request.getRequestDispatcher("/UserList");
        	 disp.forward(request, response);
         }else{
        	 //登录失败，跳转到LoginFailure
        	 response.sendRedirect("/UserManager56/LoginFailure");
         }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{
        doGet(request, response);
	}

	//销毁时被调用
	@Override
	public void destroy(){
		System.out.println("LoginServlet 内存紧张，对象被销毁了！");
	}
}
