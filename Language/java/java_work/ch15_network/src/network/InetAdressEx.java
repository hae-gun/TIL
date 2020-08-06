package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdressEx {
	public static void main(String[] args) {
		try {
			
			InetAddress local = InetAddress.getLocalHost();
			System.out.println(local.getHostAddress());
			
			
			
			InetAddress[] naverIP = InetAddress.getAllByName("www.naver.com");
			for(InetAddress i : naverIP) {
				System.out.println(i);
			}
			
			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}	
