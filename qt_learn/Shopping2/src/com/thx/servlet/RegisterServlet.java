package com.thx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thx.bean.User;
import com.thx.factory.DaoFactory;


@WebServlet("/com/thx/servlet/RegisterServlet.java")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String uname = request.getParameter("uname");
		String passwd = request.getParameter("passwd");
		String email = request.getParameter("Email");
		String path = "jsp/register.jsp";
		String message = "ע��ʧ�ܣ��û����������ѱ�ʹ��";
		try {
			if (resister(uname, passwd, email)) {
				message = "ע��ɹ�";
				path = "jsp/login.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String truePath = request.getContextPath() + "/" + path;
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>ע��</TITLE>");
		out.println("<meta http-equiv=\"refresh\" content=\"5;url=" + truePath
				+ "\">");
		out.println("</HEAD>");
		out.println("  <BODY>");
		out.print("<div align=\"center\">");
		out.print(message);
		out.print("<br/>");
		out.print("���Զ���ת����Ӧҳ��");
		out.print("<br/>");
		out.print("�������");
		out.print("<a href=\"" + truePath + "\"" + ">����" + "</a>");
		out.print("</div>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
		
	public boolean resister(String uname, String passwd, String email)
			throws Exception {
		User user = new User();
		user.setUname(uname);
		user.setPasswd(passwd);
		user.setEmail(email);
		return DaoFactory.getUserServiceInstance().addUser(user);
	}

}
