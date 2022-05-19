package roombooking;

import java.io.IOException;

import roombooking.container.CustomerContainer;
import roombooking.container.RoomContainer;
import roombooking.model.Customer;
import roombooking.model.Room;
import roombooking.ui.BookingUI;

public class Program {

	public static void main(String[] args) throws IOException {
		
		AddTestCustomers();
		AddTestRooms();
		
		BookingUI bookingUI = new BookingUI();
		bookingUI.newBooking();
	}

	private static void AddTestRooms() {
		RoomContainer.getInstance().addRoom(new Room(101, 0));
		RoomContainer.getInstance().addRoom(new Room(102, 0));
		RoomContainer.getInstance().addRoom(new Room(103, 0));
		RoomContainer.getInstance().addRoom(new Room(201, 1));
		RoomContainer.getInstance().addRoom(new Room(202, 1));
	}

	private static void AddTestCustomers() {
		CustomerContainer.getInstance().addCustomer(new Customer("John Johnson", "john@johnson.com"));
		CustomerContainer.getInstance().addCustomer(new Customer("Ann Arden", "ann@arden.com"));
		CustomerContainer.getInstance().addCustomer(new Customer("Lena Letz", "lena@letz.com"));
		
	}
}