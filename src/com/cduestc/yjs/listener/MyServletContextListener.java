package com.cduestc.yjs.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		//应用进程销毁时，被调用,将计数存入磁盘
		System.out.println("应用进程销毁..");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		//应用进程初始化时，被调用，从磁盘读入计数
		System.out.println("应用进程初始化..");
		ServletContext ctx = arg0.getServletContext();
		ctx.setAttribute("COUNTER", 0);
	}

}
