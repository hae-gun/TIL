package class11_Enumeration;

public class ClothingInfo {
	
	
	
	String code;
	String name;
	String material;
//	int season;
	Season season;

	public ClothingInfo(String code, String name, String material, Season season) {
		this.code = code;
		this.name = name;
		this.material = material;
		this.season = season;
	}

}
