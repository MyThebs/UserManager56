package com.cduestc.yjs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cduestc.yjs.model.JdbcUtils;

public class UpdateUser extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取浏览器传来的数据，然后执行一个update
		String id = request.getParameter("userid");
		String name = request.getParameter("username");
		String pwd = request.getParameter("passwd");
		String email = request.getParameter("email");
		String grade = request.getParameter("grade");
        String updateSql = "update student set"
				            + " name='" + name
				            + "', pwd='" + pwd
				            + "', email='" + email
				            + "', grade='" + grade
				            + "' where id='" + id + "'";
        System.out.println(updateSql);
        if(JdbcUtils.updateUser(updateSql)){
        	//修改成功，跳转到成功页面
        	System.out.println("修改成功");
        	RequestDispatcher dsp = request.getRequestDispatcher("/UpdateOk");
        	dsp.forward(request, response);
        }else{
        	//修改失败，跳转到失败页面
        	System.out.println("修改失败");
        	RequestDispatcher dsp = request.getRequestDispatcher("/UpdateFailure");
        	dsp.forward(request, response);        	
        }
        	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doGet(request, response);
	}

}
