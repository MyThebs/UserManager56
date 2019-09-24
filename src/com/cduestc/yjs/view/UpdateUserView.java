package com.cduestc.yjs.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserView extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	               throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pass");
		String email = request.getParameter("email");
		String grade = request.getParameter("grade");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println("UpdateUser doGet()....");
		out.println("<html>");
		out.println("<body bgcolor=#CED3FF><center>");
		out.println("<h2>修改用户</h2>");
		out.println("<br><a href='/UserManager56/UserListUrl'>返回用户列表</a>");
		out.println("<form action='/UserManager56/UpdateUser' method='post'>");
		out.println("<table border=1>");
		out.println("<tr><td>id</td><td><input readonly type=text name=userid value="+ id + "></td></tr>");
		out.println("<tr><td>name</td><td><input type=text name=username value="+ name + "></td></tr>");
		out.println("<tr><td>passwd</td><td><input type=text name=passwd value="+ pwd + "></td></tr>");
		out.println("<tr><td>email</td><td><input type=text name=email value="+ email + "></td></tr>");
		out.println("<tr><td>grade</td><td><input type=text name=grade value="+ grade + "></td></tr>");
		out.println("<tr><td colspan=2><input type=submit value=修改用户></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<hr></center></body>");
		out.println("</html>");

		out.flush();
		out.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request, response);
	
	}
}
