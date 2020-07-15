package javanetwork.multiRoomChat.my;

import java.util.ArrayList;
import java.util.List;

public class ChatSharedObj {
	List<ChatRunnable> clients = new ArrayList<ChatRunnable>();
	List<Room> rooms = new ArrayList<Room>();
	Room inRoom;

	public void inRoom(Room inRoom) {
		this.inRoom = inRoom;
	}

	public void outRoom() {
		this.inRoom = null;
	}

	public void add(ChatRunnable runnable) {
		clients.add(runnable);
	}

	public void remove(ChatRunnable runnable) {
		clients.remove(runnable);
	}
	

	public void broadcast(String msg, Room thisRoom) {
		// TODO Auto-generated method stub
		if (inRoom.equals(thisRoom)) {
			for (ChatRunnable client : clients) {
				client.getPr().println(msg);
				client.getPr().flush();
			}
		}

	}
	
	public void roomcast() {
		for(ChatRunnable client : clients) {
			for(Room room : rooms) {
				client.getPr().println(room.getName());
				client.getPr().flush();
			}
		}
	}

}