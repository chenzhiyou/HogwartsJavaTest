package com.filterPro;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenerDemo1 implements ServletContextListener {

    /**
     * 当servletContext对象创建的时候，会调用
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
        System.out.println("contextInitialized......");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent){
        System.out.println("contextDestroyed....");
    }
}
