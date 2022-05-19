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

		//keeps looping until valid customer is found by email
		boolean customerFound = false;
		while (!customerFound) {
			System.out.println("Enter customer email");
			String customerEmail = reader.readLine();
			customerFound = bookingController.addCustomer(customerEmail);
			if (!customerFound) {
				System.out.println("Customer not found");
			}
		}


		//keeps looping while user wants to add more rooms
		boolean addMoreRooms = true;
		do {
			//keeps looping until valid room found by room number
			boolean roomFound = false;
			do{
				System.out.println("Enter room number");
				String roomNumberString = reader.readLine();
				
				//this could be improved by adding try-catch 
				//in case non-numeric values are entered by user
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