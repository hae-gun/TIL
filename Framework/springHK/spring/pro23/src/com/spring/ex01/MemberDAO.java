package com.spring.ex01;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	// SqlSessionFactory 객체 필드로 받음
	public static SqlSessionFactory sqlMapper = null;

	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				// SqlMapConfig.xml(mybatis 설정파일) 을 읽어서 Reader 객체로 만든후 그것을 SqlSessionFactory 객체
				// 생성.
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 생성한 SqlSessionFactory 객체를 반환하여 필드 초기화.
		return sqlMapper;

	}
	// SqlSessionFactory 객체를 사용하여 db 트랜잭션 수행-
	// SqlSessioon을 열고 세션을 통해서 매퍼에 정의된 sql을 수행하여 결과를 받고 다시 자신을 호출한 쪽으로 반환.
//	public List<MemberVO> selectAllMemberList() {
//		sqlMapper = getInstance();
//		SqlSession session = sqlMapper.openSession();
//		List<MemberVO> memlist = null;
//		memlist = session.selectList("selectAllMemberList");//mapper.member.
//		System.out.println("SqlSession 사용");
//		return memlist;
//	}

	public List<HashMap<String, String>> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<HashMap<String, String>> memlist = null;
		memlist = session.selectList("mapper.member.selectAllMemberList");
		return memlist;
	}

}
