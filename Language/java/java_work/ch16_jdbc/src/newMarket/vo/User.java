package newMarket.vo;

public class User {
	private String id;
	private String pw;
	private String roll;
	private int point;

	public User() {
	}

	public User(String id, String pw, String roll, int point) {
		this.id = id;
		this.pw = pw;
		this.roll = roll;
		this.point = point;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", roll=" + roll + ", point=" + point + "]";
	}
	
	

}
