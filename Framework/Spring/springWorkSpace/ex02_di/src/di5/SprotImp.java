package di5;

import java.util.Scanner;

public class SprotImp implements Sport {

	private PlayerImp player;
	
	
	
	public SprotImp() {
	}



	public SprotImp(PlayerImp player) {
		this.player = player;
	}



	


	
	public void setPlayer(PlayerImp player) {
		this.player = player;
	}



	@Override
	public void print() {
		System.out.println("name = " + player.getName());
		System.out.println("Position = " + player.getPosition());
		System.out.println("Sub = " + player.getSub());
		System.out.println();
	}
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Name:");
		player.setName(sc.next());
		System.out.print("Position:");
		player.setPosition(sc.next());
		System.out.print("Sub:");
		player.setSub(sc.next());
		
	}
}
