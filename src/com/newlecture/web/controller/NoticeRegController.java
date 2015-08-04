package com.newlecture.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeFileDao;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;

//@WebServlet("/Customer/noticeReg")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, // 5메가
maxRequestSize = 1024 * 1024 * 5 * 5 // 5aprkrk 5개까지
)
public class NoticeRegController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getMethod().equals("POST")) {

			Part part = request.getPart("file");
			ServletContext application = request.getServletContext();
			
			String url = "/Customer/upload";

			String path = application.getRealPath(url);	//이 위치에 파일명을 얻어서 fullpath에 저장
			String temp = part.getSubmittedFileName();
			String fname = temp.substring(temp.lastIndexOf("\\")+1);
			String fpath = path +"\\"+ fname;
			//response.getWriter().println(fpath);

			InputStream ins = part.getInputStream();
			OutputStream outs = new FileOutputStream(fpath); // fpath=full path

			byte[] 대야 = new byte[1024];
			int len = 0;

			while((len = ins.read(대야, 0, 1024)) >= 0)
				outs.write(대야, 0, len);
				
				outs.flush();
				outs.close();
				ins.close();

			
			  String title = request.getParameter("title"); 
			  String file = request.getParameter("file"); 
			  String content = request.getParameter("content");
			  
			  Notice notice = new Notice();
			  NoticeFile noticeFile = new NoticeFile();
			  
			  notice.setTitle(title); 
			  notice.setWriter("닭갈비");
			  notice.setContent(content);
			  //response.getWriter().println("<br/>"+title);
			  NoticeDao noticeDao = new MyBatisNoticeDao();
			  noticeDao.addNotice(notice);
			  
			  NoticeFileDao noticeFileDao = new MyBatisNoticeFileDao();
			  noticeFile.setName(fname);
			  noticeFile.setNoticeCode(noticeDao.getLastCode());
			  noticeFileDao.addNoticeFile(noticeFile);

			  response.sendRedirect("notice"); // notice는 컨트롤러를 말한다. post에서 실행
			  
			  
			 } else {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/view/Customer/noticeReg.jsp");
			dispatcher.forward(request, response); // get요청에서 얘가실행
		}
	}
}
