package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Nana
 */
@WebServlet("/add")
public class Add extends HttpServlet {

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		ServletContext application = request.getServletContext();
		
		int x = 0;
		int y = 0;
		int result = 0;
		

		if (request.getMethod().equals("POST")) {

			String _result = request.getParameter("result");
			if(_result !=null){
				result = Integer.parseInt(_result);
			}
			
				String _btn = request.getParameter("btn");
				if (_btn.equals("application")) {
					
					application.setAttribute("a", result);
					out.write("<p>application�� ���� �Ϸ�</p>");
					
				} else if (_btn.equals("session")) {
					
					HttpSession session = request.getSession();
					session.setAttribute("s", result);
					
					out.write("<p>session�� ���� �Ϸ�</p>");
					
				} else if (_btn.equals("cookie")) {
					Cookie cookie = new Cookie("c", String.valueOf(result));
					cookie.setMaxAge(24*60*60);
					response.addCookie(cookie);
					
					out.write("<p>cookie�� ���� �Ϸ�</p>");
					
				} else{

				String _x = request.getParameter("x");
				String _y = request.getParameter("y");

				if (_x != null && !_x.equals(""))
					x = Integer.parseInt(_x);

				if (_y != null && !_y.equals(""))
					y = Integer.parseInt(_y);

				result = x + y;
				}

		}
		out.write("<form action=\"add\" method=\"post\">");
		out.write("		<ul>");
		out.write("<li><label for=\"x\">X:</label><input name=\"x\" /></li>");
		out.write("<li><label for=\"y\">Y:</label><input name=\"y\" /></li>");
		out.write("		</ul>");
		out.write("		<p>");
		out.printf("<input type=\"hidden\" name=\"result\" value=\"%d\"/>",result);
		out.write("<input type=\"submit\" name=\"btn\" value=\"����\" />");
		out.write("<input type=\"submit\" name=\"btn\" value=\"application\" />");
		out.write("<input type=\"submit\" name=\"btn\" value=\"session\" />");
		out.write("<input type=\"submit\" name=\"btn\" value=\"cookie\" />");
		out.write("		</p>");
		out.write("		</form>");
		out.printf("%d+%d��%d�Դϴ�.", x, y, result);
		out.println("<a href=\"Mypage\">����������</a>");
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		service(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
