package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.impl.DeptServiceImpl;

import bean.Dept;

public class DepeTest {
public static void main(String []args){
	
	
	ClassPathXmlApplicationContext ctx = 
			 new ClassPathXmlApplicationContext("applicationContext.xml");
	DeptServiceImpl dsi = (DeptServiceImpl)ctx.getBean("deptServiceImpl");
	Dept dept=dsi.findId(3);
	System.out.println(dept.getEmpCount());
	
	}
}
