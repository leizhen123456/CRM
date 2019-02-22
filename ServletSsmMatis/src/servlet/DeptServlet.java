package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Dept;

import service.impl.DeptServiceImpl;

public class DeptServlet extends HttpServlet {

	ClassPathXmlApplicationContext ctx = null;

	public DeptServlet() {
		//创建上下文对象  读取spring的配置文件
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action=request.getParameter("action");
		PrintWriter out=response.getWriter();
		//根据id获取DeptServiceImpl
		DeptServiceImpl dsi = (DeptServiceImpl)ctx.getBean("deptServiceImpl");
			if(action==null){				
				//调用查询方法
				List<Dept> list = dsi.find();
				//将数据保存到Session中
				request.getSession().setAttribute("list", list);
				response.sendRedirect("index.jsp");
				
			}else if("del".equals(action)){
				//删除
			int  id=Integer.parseInt(request.getParameter("id"));
				int count=dsi.del(id);
				if(count>0){
				out.print("<script>alert('删除成功！');location='DeptServlet';</script>");
				}else {
					out.print("<script>alert('删除失败！');location='DeptServlet';</script>");
				}
				
			}else if ("add".equals(action)) {
				//添加
				String dname=request.getParameter("dname");
				int empCount=Integer.parseInt(request.getParameter("empCount"));
				Dept dept=new Dept(0,dname,empCount);
					int count=dsi.add(dept);
					if(count>0){
						out.print("<script>alert('添加成功！');location='DeptServlet';</script>");
					}else {
						out.print("<script>alert('添加失败！');location='add.jsp';</script>");
					}
					
					
			}else if ("update".equals(action)) {
					//按照id查询
					int id=Integer.parseInt(request.getParameter("id"));
						Dept dept=dsi.findId(id);
						request.getSession().setAttribute("dept",dept);
						response.sendRedirect("Update.jsp");						
						
				}else	if ("upd".equals(action)) {
					//修改
					int id=Integer.parseInt(request.getParameter("dno"));
					String dname=request.getParameter("dname");
					int empCount=Integer.parseInt(request.getParameter("empCount"));
					Dept dept=new Dept(id,dname,empCount);
					int count=dsi.modify(dept);
					System.out.println(count);
					if(count>0){
						out.print("<script>alert('修改成功！');location='DeptServlet';</script>");
					}else {
						out.print("<script>alert('修改失败！');location='update.jsp';</script>");
					}
					}
				}	
			}



