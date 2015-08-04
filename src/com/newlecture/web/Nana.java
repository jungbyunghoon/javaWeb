package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Nana
 */
@WebServlet("/jaja")
public class Nana extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();

		String _cnt = request.getParameter("cnt");
		int cnt = 10;
		if(_cnt!=null && _cnt.equals("")==false){
			cnt=Integer.parseInt(_cnt);
		}

		
		for (int i = 0; i < cnt; i++) {
			out.println("ÁöÀ± <b>sleepy</b><br/>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String _x = request.getParameter("x");
		String _y = request.getParameter("y");
		
		int x = 0;
		int y = 0;
		
		if(_x!=null && !_x.equals("")){
			x=Integer.parseInt(_x);
		}

		if(_y!=null && !_y.equals("")){
			y=Integer.parseInt(_y);
		}
		
		int result = x+y;
		
		out.write("<form action=\"jaja\" method=\"post\">");
		out.write("		<ul>");
		out.write("<li><label for=\"x\">X:</label><input name=\"x\" /></li>");
		out.write("<li><label for=\"y\">Y:</label><input name=\"y\" /></li>");
		out.write("		</ul>");
		out.write("		<p>");
		out.write("<input type=\"submit\" value=\"µ¡¼À\" />");
		out.write("		</p>");
		out.write("		</form>");
		out.printf("%d+%d´Â%dÀÔ´Ï´Ù.",x,y,result);
		

	}
	
}
