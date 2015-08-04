package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.vo.NoticeFile;

@Configurable
public class MyBatisNoticeFileDao implements NoticeFileDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int addNoticeFile(NoticeFile noticeFile) {
	NoticeFileDao dao = session.getMapper(NoticeFileDao.class);
	return dao.addNoticeFile(noticeFile);
	}
	
	@Override
	public List<NoticeFile> getNoticeFiles(String noticeCode) {
//		SqlSession session = factory.openSession();
		
		return session.selectList("getNoticeFiles", noticeCode);
		 
	}
	

}