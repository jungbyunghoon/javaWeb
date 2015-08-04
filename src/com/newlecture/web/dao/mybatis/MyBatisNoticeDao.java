package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.vo.Notice;

/*import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.vo.Notice;*/



@Configurable
public class MyBatisNoticeDao implements NoticeDao{
	
	
	
	/*SqlSessionFactory factory =
			new SqlNewlecSessionFactory().getSqlSessionFactory();*/
	@Autowired
	private SqlSession session;//속성이라는 이름을 노축 매핑 캡슐화가 깨짐 





	@Override
	public List<Notice> getNotices(int page, String field, String query) {
		
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		NoticeFileDao fileDao = session.getMapper(NoticeFileDao.class);
		
		List<Notice> list = dao.getNotices(page, field, query);
		
		for(Notice n : list)
			n.setFiles(fileDao.getNoticeFiles(n.getCode()));
		
		return list;
	}
	
	
	@Override
	public Notice getNotice(String code) {
		//SqlSession session = factory.openSession();

		Notice n = session.selectOne("com.newlecture.web.dao.NoticeDao.getNotice",code);

		//session.close();

		return n;
	}


	@Override
	public List<Notice> getNotices() {
		// TODO Auto-generated method stub
		return getNotices(1,"TITLE","");
	}


	@Override
	public List<Notice> getNotices(int page) {
		// TODO Auto-generated method stub
		return getNotices(page,"TITLE","");
	}


	@Override
	public int addNotice(Notice notice) {
		
		int result;
		
		NoticeDao dao = session.getMapper(NoticeDao.class);
		result = dao.addNotice(notice);
		
		
		
		return result;
	}


	@Override
	public String getLastCode() {
		
		//SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		
		return dao.getLastCode();
	}
}
