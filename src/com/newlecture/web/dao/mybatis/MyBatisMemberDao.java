package com.newlecture.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.vo.Member;

public class MyBatisMemberDao implements MemberDao {

	/*SqlSessionFactory factory = new SqlNewlecSessionFactory()
			.getSqlSessionFactory();*/
	
	@Autowired
	private SqlSession session;//속성이라는 이름을 노축 매핑 캡슐화가 깨짐 

	@Override
	public Member getMember(String uid) {
		
		/*SqlSession session = factory.openSession();*/

/*		return session.selectOne(
				"com.newlecture.web.dao.MemberDao.getMember", uid);*/
		MemberDao dao=session.getMapper(MemberDao.class);
		return dao.getMember(uid);

	}
}

	/*@Override
	public List<Member> getMembers(int page, String field, String query) {
		
		//SqlSession session = factory.openSession();

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("page", page);
		params.put("field", field);
		params.put("query", query);

		List<Member> list = session.selectList("getMembers", params);
	
		for(Member p : list){
			List<JoinRequest> list2 = session.selectList("getJoinRequests", 
					p.getCode());
			
			p.setRequest(list2);
	}
		return list;
	}
	@Override
	public int addMember(Member member) {
		
		//SqlSession session = factory.openSession();
		
		
		
		
		return session.insert("com.newlecture.web.dao.MemberDao.addMember", member);
	}

}
*/