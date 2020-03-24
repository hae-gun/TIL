package com.test.service;

import java.util.ArrayList;
import java.util.List;

import com.test.BookVO.BookVO;
import com.test.dao.BookDAO;

// 이 class는 Service class 이기 때문에 무조건 business logic 처리만 담당한다.
public class BookService {

	// keyword를 이용하여 책 제목의 ArrayList를 구해오는 method.
	// Transaction 작업.
	public ArrayList<String> getBookTitle(String keyword) {
		// DB처리를 제외한 따로 처리해야 하는 로직코드가 없다.
		
		// DB 처리코드가 나와야 한다. 하지만 Service는 DB처리를 직접 하지 않는다.
		// DB 처리를 하는 객체를 만들어서 그 객체에게 Database처리를 시키낟.
		BookDAO dao = new BookDAO();
		ArrayList<String> result = dao.select(keyword);
		// 그 결과를 받아온다.
		
		return result;
	}

	public List<BookVO> getBooks(String keyword) {
		BookDAO dao = new BookDAO();
		ArrayList<BookVO> result = dao.selectAll(keyword);
		
		return result;
	}
	
	

}
