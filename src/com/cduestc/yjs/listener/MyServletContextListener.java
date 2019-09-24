package com.cduestc.yjs.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		//Ӧ�ý�������ʱ��������,�������������
		System.out.println("Ӧ�ý�������..");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		//Ӧ�ý��̳�ʼ��ʱ�������ã��Ӵ��̶������
		System.out.println("Ӧ�ý��̳�ʼ��..");
		ServletContext ctx = arg0.getServletContext();
		ctx.setAttribute("COUNTER", 0);
	}

}
