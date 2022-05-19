package roombooking.container;

import java.util.ArrayList;
import java.util.List;

import roombooking.model.Booking;

public class BookingContainer {
	private static BookingContainer instance;
	private BookingContainer() {}
	public static BookingContainer getInstance() {
		if(instance==null) {
			instance = new BookingContainer();
		}
		return instance;
	}
	
	private List<Booking> bookings = new ArrayList<Booking>();
	
	public void addBooking(Booking booking) {
		bookings.add(booking);
	}
	
	public List<Booking> getBookings() {
		return new ArrayList<Booking>(bookings);
	}
}