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
    //���췽��
	public LoginServlet(){
    	System.out.println("LoginServlet ���󱻴����ˣ�");
    }

    @Override
    public void init(){
    	System.out.println("LoginServlet ���󱻳�ʼ���ˣ�");
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 System.out.println("LoginServlet request:" + request.hashCode());
		 System.out.println("��ǰ����" + this);
		 String name = request.getParameter("user_name");
		 String pwd = request.getParameter("pass_word");
         System.out.println("name = " + name);
         System.out.println("pwd = " + pwd);
         if(JdbcUtils.login(name, pwd)){
        	 ServletContext ctx = getServletContext();
        	 Integer count = (Integer) ctx.getAttribute("COUNTER");
        	 count++;
        	 ctx.setAttribute("COUNTER", count);
             //��¼�ɹ�����ת��LoginSucess.�����ַ�ʽ��1���ض���2��ת��
        	 //�ض���
        	 //response.sendRedirect("/UserManager56/LoginSucess?USER_NAME="+name);
             //ת��
        	 //request.setAttribute("COUNTER", count);
        	 request.setAttribute("USER_NAME" , name);
        	 RequestDispatcher disp = request.getRequestDispatcher("/UserList");
        	 disp.forward(request, response);
         }else{
        	 //��¼ʧ�ܣ���ת��LoginFailure
        	 response.sendRedirect("/UserManager56/LoginFailure");
         }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{
        doGet(request, response);
	}

	//����ʱ������
	@Override
	public void destroy(){
		System.out.println("LoginServlet �ڴ���ţ����������ˣ�");
	}
}
