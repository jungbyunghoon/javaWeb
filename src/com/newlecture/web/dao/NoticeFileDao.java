package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.vo.NoticeFile;


public interface NoticeFileDao {
	
	public List<NoticeFile> getNoticeFiles(String noticeCode);
	public int addNoticeFile(NoticeFile noticeFile);
}
