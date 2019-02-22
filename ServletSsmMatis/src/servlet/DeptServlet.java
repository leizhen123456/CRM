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
		//���������Ķ���  ��ȡspring�������ļ�
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
		//����id��ȡDeptServiceImpl
		DeptServiceImpl dsi = (DeptServiceImpl)ctx.getBean("deptServiceImpl");
			if(action==null){				
				//���ò�ѯ����
				List<Dept> list = dsi.find();
				//�����ݱ��浽Session��
				request.getSession().setAttribute("list", list);
				response.sendRedirect("index.jsp");
				
			}else if("del".equals(action)){
				//ɾ��
			int  id=Integer.parseInt(request.getParameter("id"));
				int count=dsi.del(id);
				if(count>0){
				out.print("<script>alert('ɾ���ɹ���');location='DeptServlet';</script>");
				}else {
					out.print("<script>alert('ɾ��ʧ�ܣ�');location='DeptServlet';</script>");
				}
				
			}else if ("add".equals(action)) {
				//���
				String dname=request.getParameter("dname");
				int empCount=Integer.parseInt(request.getParameter("empCount"));
				Dept dept=new Dept(0,dname,empCount);
					int count=dsi.add(dept);
					if(count>0){
						out.print("<script>alert('��ӳɹ���');location='DeptServlet';</script>");
					}else {
						out.print("<script>alert('���ʧ�ܣ�');location='add.jsp';</script>");
					}
					
					
			}else if ("update".equals(action)) {
					//����id��ѯ
					int id=Integer.parseInt(request.getParameter("id"));
						Dept dept=dsi.findId(id);
						request.getSession().setAttribute("dept",dept);
						response.sendRedirect("Update.jsp");						
						
				}else	if ("upd".equals(action)) {
					//�޸�
					int id=Integer.parseInt(request.getParameter("dno"));
					String dname=request.getParameter("dname");
					int empCount=Integer.parseInt(request.getParameter("empCount"));
					Dept dept=new Dept(id,dname,empCount);
					int count=dsi.modify(dept);
					System.out.println(count);
					if(count>0){
						out.print("<script>alert('�޸ĳɹ���');location='DeptServlet';</script>");
					}else {
						out.print("<script>alert('�޸�ʧ�ܣ�');location='update.jsp';</script>");
					}
					}
				}	
			}



