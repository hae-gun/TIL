package sec03.brd01;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;

public class ArticleVO {
	private int level; //글 레벨(게시글, 댓글, 대댓글 ....) 
	private int articleNO; //글번호 - pk
	private int parentNO; //부모글 번호
	private String title; //제목
	private String content; //내용
	private String imageFileName; //글에 붙이는 사진 경로
	private String id;//fk - 글쓴이와 게시글 연결
	private Date writeDate; //게시일
	
	public ArticleVO() {
		
	}

	public ArticleVO(int level, int articleNO, int parentNO, String title, String content, String imageFileName,
			String id) {
		super();
		this.level = level;
		this.articleNO = articleNO;
		this.parentNO = parentNO;
		this.title = title;
		this.content = content;
		this.imageFileName = imageFileName;
		this.id = id;
	}

	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getArticleNO() {
		return articleNO;
	}


	public void setArticleNO(int articleNO) {
		this.articleNO = articleNO;
	}


	public int getParentNO() {
		return parentNO;
	}


	public void setParentNO(int parentNO) {
		this.parentNO = parentNO;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		try {
			this.imageFileName = URLEncoder.encode(imageFileName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getWriteDate() {
		return writeDate;
	}


	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	
	
	
	

}
