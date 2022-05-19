package roombooking.controller;

import roombooking.container.RoomContainer;
import roombooking.model.Room;

public class RoomController {

	public Room findRoomByNumber(int roomNumber) {
		return RoomContainer.getInstance().findRoomByNumber(roomNumber);
	}
}
