package com.test.vo;

// 이 클래스의 객체는 책으 세부정보를 담을 수 있는 객체이다.
// 갹채 1개마다 책 1권의 데이터를 저장할 수 있다.
// VO를 만드는 기본 원칙은 Database Table 기반으로 생성한다.
public class BookVO {

	private String bisbn;
	private String btitle;
	private String bdata;
	private int bpage;
	private int price;
	private String bauthor;
	private String btranslator;
	private String bsupplement;
	private String bpulisher;
	private String bimgurl;
	private String bimgbase64;

	// constructor
	public BookVO() {
	} // 인자도 없고 하는일도 없는 default 생성자.
	  // package에 상관없이 사용하도록 public을 붙여준다.
	
	
	
	// private field를 사용하기 위한 특수한 형태의 method 필요함. setter, getter

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBdata() {
		return bdata;
	}

	public void setBdata(String bdata) {
		this.bdata = bdata;
	}

	public int getBpage() {
		return bpage;
	}

	public void setBpage(int bpage) {
		this.bpage = bpage;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public String getBtranslator() {
		return btranslator;
	}

	public void setBtranslator(String btranslator) {
		this.btranslator = btranslator;
	}

	public String getBsupplement() {
		return bsupplement;
	}

	public void setBsupplement(String bsupplement) {
		this.bsupplement = bsupplement;
	}

	public String getBpulisher() {
		return bpulisher;
	}

	public void setBpulisher(String bpulisher) {
		this.bpulisher = bpulisher;
	}

	public String getBimgurl() {
		return bimgurl;
	}

	public void setBimgurl(String bimgurl) {
		this.bimgurl = bimgurl;
	}

	public String getBimgbase64() {
		return bimgbase64;
	}

	public void setBimgbase64(String bimgbase64) {
		this.bimgbase64 = bimgbase64;
	}

}
