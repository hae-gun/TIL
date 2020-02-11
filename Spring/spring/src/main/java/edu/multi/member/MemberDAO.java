package edu.multi.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {//mybatis-spring.xml 설정에서 만들어져 있음.
	@Autowired
	//@Qualifier("")을 통해 어떤 xml이용할지 결정하능하다.
	SqlSession sqlSession;
	
	public MemberVO selectMember(String userid, String password) {
//		sql문장 : select * from member where userid=? and password=?
		MemberVO vo = new MemberVO();
		vo.setUserid(userid);
		vo.setPassword(password);
		vo = sqlSession.selectOne("getmember", vo);/* 배열 or VO로 전송. */
		return vo;
	}
	public MemberVO checkMember(MemberVO vo) {
		return sqlSession.selectOne("checkmember", vo);
		
	}
	public void insertMember(MemberVO vo) {
		
		sqlSession.insert("insertmember", vo);
		
	}
}
