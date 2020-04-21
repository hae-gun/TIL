package javanetwork.multiRoomChat.my;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class RoomRunnable implements Runnable {
	
	private Socket s;
	private ObjectInputStream ors;
	private ObjectOutputStream oos;
	private ArrayList<Room> roomList;
	private ChatSharedObj shared = new ChatSharedObj();
	
	
	
	RoomRunnable(Socket s,ChatSharedObj shared){
		this.s = s;
		this.shared = shared;
		try {
			ors = new ObjectInputStream(s.getInputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
		int i=0;
		roomList.add(new Room(i+"번방",i++));
		roomList.add(new Room(i+"번방",i++));
		roomList.add(new Room(i+"번방",i++));
		roomList.add(new Room(i+"번방",i++));
		roomList.add(new Room(i+"번방",i++));
		
	}
	
	
	
	@Override
	public void run() {
		
		
		
	}

}
