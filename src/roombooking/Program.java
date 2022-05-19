package roombooking;

import java.io.IOException;
import java.util.Scanner;

import roombooking.container.CustomerContainer;
import roombooking.container.RoomContainer;
import roombooking.model.Customer;
import roombooking.model.Room;
import roombooking.ui.BookingUI;

public class Program {

	public static void main(String[] args) throws IOException {
		AddAndShowTestCustomers();
		AddAndShowTestRooms();
		
		BookingUI bookingUI = new BookingUI();
		bookingUI.newBooking();
	}

	private static void AddAndShowTestRooms() {
		RoomContainer.getInstance().addRoom(new Room(101, 0));
		RoomContainer.getInstance().addRoom(new Room(102, 0));
		RoomContainer.getInstance().addRoom(new Room(103, 0));
		RoomContainer.getInstance().addRoom(new Room(201, 1));
		RoomContainer.getInstance().addRoom(new Room(202, 1));
		RoomContainer.getInstance().addRoom(new Room(203, 1));
		System.out.println("Available rooms:");
		for(Room room: RoomContainer.getInstance().getRooms()) {
			System.out.println("\t" + room.getNumber());
		}
		System.out.println();
	}

	private static void AddAndShowTestCustomers() {
		CustomerContainer.getInstance().addCustomer(new Customer("John Johnson", "john@johnson.com"));
		CustomerContainer.getInstance().addCustomer(new Customer("Ann Arden", "ann@arden.com"));
		CustomerContainer.getInstance().addCustomer(new Customer("Lena Letz", "lena@letz.com"));
	
		System.out.println("Available customers:");
		for(Customer customer: CustomerContainer.getInstance().getCustomers()) {
			System.out.println("\t" + customer.getEmail());
		}
		System.out.println();
	}
}