package com.thx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thx.bean.User;
import com.thx.dao.UserDao;
import com.thx.factory.DaoFactory;

@WebServlet("/com/thx/servlet/LoginServlet.java")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//��ȡ�û�����ĵ�¼��Ϣ
		String uname = request.getParameter("uname");
		String passwd = request.getParameter("passwd");
		User user = null;
		String message = "";  //��ʾ��Ϣ
		String path = "jsp/login.jsp";
		try {
			UserDao dao = DaoFactory.getUserServiceInstance();
			if ((user = dao.queryByName(uname)) != null) {      //���û���ע��
				if (user.getPasswd().equals(passwd)) {         //������ȷ
					//����session
					String lastLoginTime = user.getLastLogin();
					dao.editLoginTime(user.getUid());        //��¼��¼ʱ��
					System.out.println("uid="+user.getUid());
					request.getSession().setAttribute("uname", uname);
					request.getSession().setAttribute("uid", String.valueOf(user.getUid()));
					request.getSession().setAttribute("lastLoginTime", lastLoginTime);
					path = "index.jsp";
				} else {
					message = "�����������������";
				}
			} else {
				message = "�����ڸ��û�������������";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String truePath = request.getContextPath() + "/" + path;
		if ("".equals(message)) {
			response.sendRedirect(truePath);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>��¼����</TITLE>");
			out.println("<meta http-equiv=\"refresh\" content=\"5;url="
					+ truePath + "\">");
			out.println("</HEAD>");
			out.println("  <BODY>");
			out.print("<div align=\"center\">");
			out.print(message);
			out.print("<br/>");
			out.print("���Զ���ת����¼ҳ��");
			out.print("<br/>");
			out.print("�������ﷵ�أ�");
			out.print("<a href=\"" + truePath+"\"" +">��¼"+"</a>");
			out.print("</div>");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
	}

}
