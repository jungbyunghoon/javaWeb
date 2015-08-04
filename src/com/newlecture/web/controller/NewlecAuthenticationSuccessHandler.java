package com.newlecture.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.vo.Member;

public class NewlecAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	

	private MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String uid= authentication.getName();
		
		Member m =memberDao.getMember(uid);
		String type =m.getDefaultRole();
		
		String targetUrl ="/Customer/notice";
		
		if(type.equals("ROLE_TEACHER"))
			targetUrl = "/Customer/noticeDetail?c=5";
		
		RedirectStrategy redirectStrategy= new DefaultRedirectStrategy();
		redirectStrategy.sendRedirect(request, response, targetUrl);
		
	
		
	}
	
		
	}
	
