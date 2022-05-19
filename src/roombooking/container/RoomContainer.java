package roombooking.container;

import java.util.ArrayList;
import java.util.List;

import roombooking.model.Room;

public class RoomContainer {
	private static RoomContainer instance;
	private RoomContainer() {}
	public static RoomContainer getInstance() {
		if(instance==null) {
			instance = new RoomContainer();
		}
		return instance;
	}
	
	private List<Room> rooms = new ArrayList<Room>();
	
	public Room findRoomByNumber (int roomNumber) {
	
		Room foundRoom = null;
		
		for(Room room: rooms) {
			if(room.getNumber() == roomNumber) {
				foundRoom = room;
			}
		}
		
		return foundRoom;
	}
	
	public void addRoom(Room room) {
		rooms.add(room);
	}
}
