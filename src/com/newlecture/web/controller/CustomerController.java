package com.newlecture.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeDao;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;

@Controller
@RequestMapping("/Customer/*")
public class CustomerController {
	
	@Autowired
	 private NoticeDao noticeDao;
	@Autowired
	 private NoticeFileDao noticeFileDao;
	 
	
	 
	 @Autowired
	public void setNoticeFileDao(NoticeFileDao noticeFileDao) {
		this.noticeFileDao = noticeFileDao;
	}

	@Autowired
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	@RequestMapping("notice")
	public String notice(Model model) {
		//NoticeDao noticeDao = new MyBatisNoticeDao();
		List<Notice> list = noticeDao.getNotices();

		/*
		 * ModelAndView mv = new ModelAndView();
		 * mv.setViewName("/WEB-INF/view/Customer/notice.jsp");
		 */
		model.addAttribute("list", list);
	
		
		return "Customer.notice";
	//첫번째 별 두번째 별
	}
	
	@RequestMapping("noticeDetail")
	public String noticeDetail(String c, Model model) {
		//NoticeDao noticeDao = new MyBatisNoticeDao();
		Notice n = noticeDao.getNotice(c);

		model.addAttribute("n", n);

		return "Customer.noticeDetail";
	}

	@RequestMapping(value = "noticeReg", method = RequestMethod.GET)
	public String noticeReg() { // get요청일때는 얘를 쓴다.

		return "Customer.noticeReg";
	}

	@RequestMapping(value = "noticeReg", method = RequestMethod.POST)
	public String noticeReg(Notice n, MultipartFile file,
			Principal principal,HttpServletRequest request, 
			SecurityContext context) throws IOException {
		// getParam을 ()이렇게 사용 <<-get요청일땐 사용안한다. post일때만사용
		
		if(request.isUserInRole("ROLE_ADMIN"))
		{
			
		}
		
		context.getAuthentication().getAuthorities();
		context.getAuthentication().isAuthenticated();
		
		
		n.setWriter(principal.getName());//로그인 유저명 
		noticeDao.addNotice(n);
		
		String lastCode = noticeDao.getLastCode();
		
		if(!file.isEmpty()){
		ServletContext application = request.getServletContext();

		String url = "/resource/Customer/upload";

		String path = application.getRealPath(url); // 이 위치에 파일명을 얻어서 fullpath에
													// 저장
		String temp = file.getOriginalFilename();// part.getSubmittedFileName();
		String fname = temp.substring(temp.lastIndexOf("\\") + 1);
		String fpath = path + "\\" + fname;

		InputStream ins = file.getInputStream();// part.getInputStream();
		OutputStream outs = new FileOutputStream(fpath); // fpath=full path

		byte[] 대야 = new byte[1024];
		int len = 0;

		while ((len = ins.read(대야, 0, 1024)) >= 0)
			outs.write(대야, 0, len);

		outs.flush();
		outs.close();
		ins.close();
		
		NoticeFile noticeFile= new NoticeFile();
		noticeFile.setNoticeCode(lastCode);
		noticeFile.setName(fname);
		noticeFileDao.addNoticeFile(noticeFile);
	}
		
		return "redirect:notice";
	}
}
