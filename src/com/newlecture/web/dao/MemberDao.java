package com.newlecture.web.dao;

import com.newlecture.web.vo.Member;

public interface MemberDao {
	
	public Member getMember(String uid);
	
/*	public List<Member> getMembers(int page, String field, String query);
	
	public int addMember(Member member);*/
	
}
