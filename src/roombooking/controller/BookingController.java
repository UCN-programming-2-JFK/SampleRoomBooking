package roombooking.controller;

import roombooking.container.BookingContainer;
import roombooking.container.CustomerContainer;
import roombooking.container.RoomContainer;
import roombooking.model.*;

public class BookingController {
	
	private Booking booking;
	
	public void createNewBoking() {
		booking = new Booking();
	}
	
	public boolean addCustomer(String email) {
		Customer foundCustomer = CustomerContainer.getInstance().findCustomerByEmail(email);
		if(foundCustomer != null) {
			getBooking().setCustomer(foundCustomer);
			return true;
		}
		return false;
	}
	
	public boolean addRoom(int roomNumber) {
		Room foundRoom = RoomContainer.getInstance().findRoomByNumber(roomNumber);
		if(foundRoom != null) {
			getBooking().addRoom(foundRoom);
			return true;
		}
		return false;
	}
	
	public Booking getBooking() {
		return booking;
	}
	
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	public void saveBooking() {
		BookingContainer.getInstance().addBooking(getBooking());
	}
}