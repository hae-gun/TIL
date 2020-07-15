package edu.multi.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public class BoardDAO {

	// BoardTable 전체 게시물 조회 메소드.
	public ArrayList<BoardVO> getList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>(); // 사용자가 정의한 클래스에만 어노테이션 설정. ArrayList는 되도록 직접생성.
		try {
			// 1. jdbc driver로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. db 정보 부여하고 db 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
			// 3. sql 정의 - 전송
			PreparedStatement pt = con.prepareStatement("select * from board order by time desc");
			// 4. sql 실행 결과 이용. ResultSet <- select
			ResultSet rs = pt.executeQuery();
			while (rs.next()) {// select 레코드 있을 때까지 실행.
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setWriter(rs.getString("writer"));
				vo.setTime(rs.getString("time"));
				vo.setViewcount(rs.getInt("viewcount"));
				list.add(vo);

			}
			// 5. db 연결해제
			rs.close();
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 해당 글번호에 해당하는 매서드 호출
	public BoardVO getBoardDetail(int seq) {
		BoardVO vo = null;
		try {
			// 1. jdbc driver로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. db 정보 부여하고 db 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
			//2_1. 검색하면 조회수를 1증가.
			PreparedStatement pt0 = con.prepareStatement("update board set viewcount=(viewcount+1) where seq=?");
			// 3. sql 정의 - 전송
			pt0.setInt(1, seq);
			PreparedStatement pt = con.prepareStatement("select * from board where seq=?");
			
			// 4. sql 실행 결과 이용. ResultSet <- select
			pt.setInt(1, seq);
			
			 int update = pt0.executeUpdate();//카운트올리기.
			 ResultSet rs = pt.executeQuery();//1개 레코드(위치 이전 포인터 가리킴)
			
			rs.next();//첫번째 레코드 이동할때도 한번은 해야함.
			vo = new BoardVO();
			vo.setSeq(rs.getInt("seq"));
			vo.setTitle(rs.getString("title"));
			vo.setContents(rs.getString("contents"));
			vo.setWriter(rs.getString("writer"));
			vo.setTime(rs.getString("time"));
			vo.setViewcount(rs.getInt("viewcount"));
			// 5. db 연결해제
			rs.close();
			pt.close();
			pt0.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	// 작성한 1개 게시물 저장 .
	public int insertBoard(BoardVO vo) {
		int result = 0;
		try {
			// 1. jdbc driver로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. db 정보 부여하고 db 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
			// 3. sql 정의 - 전송
			String insertsql = "insert into board values((SELECT MAX(SEQ)+1 FROM BOARD),?,?,?, SYSDATE, ?, 0)";
			PreparedStatement pt = con.prepareStatement(insertsql);
			// 4. sql 실행 결과 이용.
			pt.setString(1, vo.getTitle());
			pt.setString(2, vo.getContents());
			pt.setString(3, vo.getWriter());
			pt.setInt(4, vo.getPassword());
			result = pt.executeUpdate();

			// 5. db 연결해제
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;// 결과가 1이면 정상적인 insert
	}

	// 1개 게시물 조회 게시물 번호 입력받아서 삭제. //제목에 "글" or 내용 "자바"
	public int deleteBoard(int seq) {
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. db 정보 부여하고 db 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "TIGER");
			// 3. sql 정의 - 전송
			String deletesql = "delete from board where seq = ?";
			PreparedStatement pt = con.prepareStatement(deletesql);
			// 4. sql 실행 결과 이용.

			pt.setInt(1, seq);
			result = pt.executeUpdate();

			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	// 1개 게시물 수정

	// 1개 게시물 삭제

}
