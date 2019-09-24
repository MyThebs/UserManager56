package com.cduestc.yjs.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cduestc.yjs.model.JdbcUtils;
import com.cduestc.yjs.model.UserInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserList extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = (String) request.getAttribute("USER_NAME");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String lastTime = null;
		Cookie[] cookies = request.getCookies();
		boolean exist = false;
		
		//��cookie����
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("LAST_TIME")){
					//���ǵ�һ�ε�¼
					exist = true;
					lastTime = cookie.getValue();
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
					String newDate = sdf.format(date);
				    cookie.setValue(newDate);
				    cookie.setMaxAge(3600*24);			    
				    response.addCookie(cookie);
				}
			}
		}
		
		//��һ�ε�¼
		if(exist == false){
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
			String dateString = sdf.format(date);
			Cookie cookie = new Cookie("LAST_TIME", dateString);
			//�������е����ã�������ͻ��˻��Cookie�������־û��洢,���û�����У���Cookie���ݽ���������������ڴ�
			cookie.setMaxAge(3600*24);
			response.addCookie(cookie);			
		}

		out.println("<html>");
		out.println("<center>");
		out.println("<head bgcolor=#CED3EF>");
		if(exist == false){
		    out.println("<h2>" + name +", ��ӭ��!</h2>");
		}else{
		    out.println("<h2>" + name +", ��ӭ�㣬���ϴε�¼ʱ�䣺" + lastTime +"</h2>");
		}
		out.println("</head>");
		out.println("<body bgcolor=#CED3EF>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>id</th>");
		out.println("<th>name</th>");
		out.println("<th>password</th>");
		out.println("<th>email</th>");
		out.println("<th>grade</th>");
		out.println("</tr>");
		List<UserInfo> list = JdbcUtils.getUserList();
		for(int i = 0; i < list.size(); i++){
			out.println("<tr>");
			out.println("<td>"+ list.get(i).getId() +"</td>");
			out.println("<td>"+list.get(i).getName()+"</td>");
			out.println("<td>" + list.get(i).getPwd()+ "</td>");
			out.println("<td>" + list.get(i).getEmail() + "</td>");
			out.println("<td>"+ list.get(i).getGrade() +"</td>");
			String parameters = "?id="+list.get(i).getId()
			                    +"&name=" + list.get(i).getName()
			                    +"&pass=" + list.get(i).getPwd()
			                    +"&email=" + list.get(i).getEmail()
			                    +"&grade=" + list.get(i).getGrade();
			out.println("<td> <a href='/UserManager56/UpdateUserView"+parameters+"'>�޸��û�</td>");
			
			out.println("</tr>");
		}
		out.println("</table>");
		ServletContext ctx = getServletContext();
		Integer count = (Integer) ctx.getAttribute("COUNTER");
		out.println("����վ���ʴ�����" + count.toString());
		out.println("</body>");
		out.println("<center>");		
		out.println("</html>");
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
