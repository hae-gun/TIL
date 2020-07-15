package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.test.vo.BookVO;

// Database 처리 전문 class.
// JDBC의 처리 순서.
// 1. 내가 사용하는 DBMS에 Driver Loading.
// 2. Connection (Database 연결).
// 3. Statement 생성.
// 4. Query 실행(SQL문을 실행).
// 5. 결과처리.
// 6. 사용한 Resource 해제(Database close).

// Transaction (일의 최소단위)
// 이체 ( A로부터 B한테 5000원 이체)
// 1. A게좌에 5000원이 있는지 select.
// 2. B계좌가 존재하는지 확인 select.
// 3. A계좌의 잔액에서 5000원 차감 update
// 4. B계좌의 잔액에서 5000원 증가 update
// ===> 왜 코드상에서 Transaction을 설정해야 하는가?!

public class BookDAO {

	// 단위 Database 처리를 담당.
	public ArrayList<String> select(String keyword) {
		// JDBC에 대한 기본 처리를 하자.
		// Database 연결과 Driver Loading 은 JNDI를 이용.
		// 제공된 context.xml 파일을 WebContent/META-INF 폴더안에 저장.
		Connection con = null;

		// 결과가 저장될 ArrayList를 생성.
		ArrayList<String> result = new ArrayList<>();

		try {
			// Database 연결.
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/mySQLDB");
			// Database Connection 획득.
			con = ds.getConnection();

			// SQL 문장 작성.
			String sql = "select btitle from book where btitle like ?";

			// 작성한 SQL문장을 Database에서 실행시키기 위해서 PrepareStatement 생성.
			PreparedStatement pstmt = con.prepareStatement(sql);

			// ? 를 채워서 SQL 문장을 완성.
			pstmt.setString(1, "%" + keyword + "%");

			// SQL문장을 실행한 후 결과를 ResultSet으로 받아오기.

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				result.add(rs.getString("btitle"));
			}

			// 나중에 연결된 것부터 닫기.
			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public ArrayList<BookVO> selectAll(String keyword) {
		Connection con = null;

		ArrayList<BookVO> result = new ArrayList<BookVO>();

		try {

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public ArrayList<BookVO> selectInfo(String keyword) {
		// 전형적인 Database 처리코드가 나와야 한다.

		Connection con = null;

		// 결과가 저장될 ArrayList를 생성. (BookVO를 이용한 ArrayList)
		ArrayList<BookVO> result = new ArrayList<BookVO>();

		try {
			// Database 연결.
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/mySQLDB");
			// Database Connection 획득.
			con = ds.getConnection();

			// SQL 문장 작성.
			String sql = "select btitle,bisbn from book where btitle like ?";

			// 작성한 SQL문장을 Database에서 실행시키기 위해서 PrepareStatement 생성.
			PreparedStatement pstmt = con.prepareStatement(sql);

			// ? 를 채워서 SQL 문장을 완성.
			pstmt.setString(1, "%" + keyword + "%");

			// SQL문장을 실행한 후 결과를 ResultSet으로 받아오기.

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setBtitle(rs.getString("btitle"));
				vo.setBisbn(rs.getString("bisbn"));
				result.add(vo);
			}

			// 나중에 연결된 것부터 닫기.
			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public ArrayList<BookVO> selectAllInfo(String keyword) {
		Connection con = null;

		// 결과가 저장될 ArrayList를 생성. (BookVO를 이용한 ArrayList)
		ArrayList<BookVO> result = new ArrayList<BookVO>();

		try {
			// Database 연결.
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/mySQLDB");
			// Database Connection 획득.
			con = ds.getConnection();

			// SQL 문장 작성.
			String sql = "select btitle,bisbn,bimgurl,bauthor,bprice,bimgbase64 from book where bisbn like ?";

			// 작성한 SQL문장을 Database에서 실행시키기 위해서 PrepareStatement 생성.
			PreparedStatement pstmt = con.prepareStatement(sql);

			// ? 를 채워서 SQL 문장을 완성.
			pstmt.setString(1, "%" + keyword + "%");

			// SQL문장을 실행한 후 결과를 ResultSet으로 받아오기.

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setBtitle(rs.getString("btitle"));
				vo.setBisbn(rs.getString("bisbn"));
				vo.setBimgurl(rs.getString("bimgurl"));
				vo.setBauthor(rs.getString("bauthor"));
				vo.setPrice(Integer.valueOf(rs.getString("bprice")));
				vo.setBimgbase64(rs.getString("bimgbase64"));
				result.add(vo);
			}
			

			// 나중에 연결된 것부터 닫기.
			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}

}
