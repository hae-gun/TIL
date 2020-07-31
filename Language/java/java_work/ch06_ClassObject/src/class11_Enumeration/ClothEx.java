package class11_Enumeration;

public class ClothEx {
	public static void main(String[] args) {

		ClothingInfo ci1 = new ClothingInfo("11", "xt", "jean", Season.SUMMER);

		ClothingInfo ci2 = new ClothingInfo("22", "rr", "cotton", Season.SUMMER);

		Clothes bj01 = new Clothes(30000, ci1);
		Clothes uw01 = new Clothes(30000, ci2);
		
		if(bj01.ci.season == Season.SUMMER) {
			System.out.println("cool");
		}
	}
}
