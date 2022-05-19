package roombooking.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import roombooking.controller.BookingController;
import roombooking.controller.CustomerController;
import roombooking.controller.RoomController;
import roombooking.model.Customer;
import roombooking.model.Room;

public class BookingUI {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	BookingController bookingController = new BookingController();
	CustomerController customerController = new CustomerController();
	RoomController roomController = new RoomController();

	public void newBooking() throws IOException {

		System.out.println("CREATING NEW BOOKING");
		System.out.println();

		bookingController.createNewBoking();

		boolean customerFound = false;
		while (!customerFound) {
			System.out.println("Enter customer email");
			String customerEmail = reader.readLine();
			customerFound = bookingController.addCustomer(customerEmail);
			if (!customerFound) {
				System.out.println("Customer not found");
			}
		}

		boolean addMoreRooms = true;

		do {
			boolean roomFound = false;
			do{
				System.out.println("Enter room number");
				String roomNumberString = reader.readLine();
				int roomNumber = Integer.parseInt(roomNumberString);
				roomFound = bookingController.addRoom(roomNumber);
				if (!roomFound) {
					System.out.println("Room not found");
				}
			} while (!roomFound);
			System.out.println("Add another room? (Y/N)");
			String addMoreRoomsString = reader.readLine();
			addMoreRooms = addMoreRoomsString.toLowerCase().contains("y");
		} while (addMoreRooms);

		bookingController.saveBooking();

		System.out.println("Booking created:");
		System.out.println(bookingController.getBooking());
	}
}