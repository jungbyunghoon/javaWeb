package com.newlecture.web.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.MyBatisNoticeDao;
import com.newlecture.web.dao.mybatis.SqlNewlecSessionFactory;
import com.newlecture.web.vo.Notice;

public class Program {

	static {
		SqlNewlecSessionFactory factory = new SqlNewlecSessionFactory();
		try {
			factory.init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
/*	NoticeDao noticeDao = new MyBatisNoticeDao(); //왕자님을 만든거야 진짜왕자님이야(ㅈ..진..진짜가 나타났다!)

		NoticeDao proxy = (NoticeDao)Proxy.newProxyInstance
				(noticeDao.getClass().getClassLoader(), noticeDao.getClass().getInterfaces(), 
						new InvocationHandler() {
							
							@Override
							public Object invoke(Object proxy, Method method, Object[] args)
									throws Throwable {	//Method가 실제왕자님을 호출하기 위해 사용된다.
								System.out.println("사전");			//사전
								List<Notice> list = (List<Notice>)(method.invoke(noticeDao, args));	//진짜왕자님호출
								System.out.println("사후");
											//사후
								return list;
							}
						});*/
	
		ApplicationContext context =
				new ClassPathXmlApplicationContext("com/newlecture/web/aop/spring-context.xml");
		
		NoticeDao noticeDao = (NoticeDao)context.getBean("noticeDao");
		List<Notice> list = noticeDao.getNotices();
		//원한다면 noticeDao.해서 진짜왕자님을 출력할 수있어 (잘했어!)
		Notice notice= noticeDao.getNotice("5");

		for(Notice n:list)
			System.out.printf("제목:%s\n", n.getTitle());
	}
}
