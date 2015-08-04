

package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
@WebFilter(
		urlPatterns ={"/*"},
		initParams = {@WebInitParam(name="encoding", value="UTF-8")}
		)
public class CharacterEncodingFilter implements Filter {
	
	private String encoding;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		//System.out.println("before 필터 실행");	//사전
		chain.doFilter(request,response);
		//System.out.println("after4");			//사후 사후에 할 게 없으면 안쓰면 되는거야.
												//	사후 작업에 해야할것이 인코딩
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
	
	}

}
