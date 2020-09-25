package sec03.brd01;

import java.util.List;

public class BoardServiceImpl implements BoardService {
	BoardDAO boardDAO;
	public BoardServiceImpl() {
		boardDAO = new BoardDAO();
	}

	public List<ArticleVO> listArticles() {
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}
}
