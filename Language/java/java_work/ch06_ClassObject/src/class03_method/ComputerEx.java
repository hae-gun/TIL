package class03_method;

public class ComputerEx {
	public static void main(String[] args) {
		
		Computer com1 = new Computer();
		com1.owner = "tom";
		com1.whoseCom();
		System.out.println(com1.power);
		
		Computer com2 = new Computer("jane");
		com2.whoseCom();
		
		System.out.println(com2.power);
		com1.powerOn();
		System.out.println(com1.power);
		
		com1.useCase(com1.owner);
		com2.useCase(com2.owner);
		
	}
}
