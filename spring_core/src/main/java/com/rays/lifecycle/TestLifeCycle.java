package com.rays.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifeCycle {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("lifecycle.xml");

		MyBean m = context.getBean("myBean", MyBean.class);

//		m.service();

		((ClassPathXmlApplicationContext) context).close();
	}
}
