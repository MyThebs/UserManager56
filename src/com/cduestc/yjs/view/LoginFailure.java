package com.cduestc.yjs.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFailure extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	 response.setContentType("text/html;charset=utf-8");
	 PrintWriter out = response.getWriter();
	 out.println("<html>");
	 out.println("<head>");
	 out.println("<center>");
	 out.println("��¼���");
	 out.println("</center>");
	 out.println("</head></br>");
	 out.println("<hr>");
	 out.println("<body bgcolor=#CED3FF>");
	 out.println("<center>");
	 out.println("��¼ʧ��");
	 out.println("</center>");         
	 out.println("</body>");
	 out.println("</html>");
}


public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
doGet(request, response);
}

}
