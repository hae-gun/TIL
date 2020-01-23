package di5;

public class PlayerImp implements Player {

	String name, position, sub;

	
	
	public PlayerImp() {
	}

	public PlayerImp(String name, String position, String sub) {
		this.name = name;
		this.position = position;
		this.sub = sub;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}
	
	
	
}
