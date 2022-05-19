package roombooking.ui;

import java.io.*;
import roombooking.controller.BookingController;

public class NiceBookingUI {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	BookingController bookingController = new BookingController();

	private final static String EXIT_COMMAND = "QUIT";

	public void newBooking() throws IOException {

		printMenuNameAndExitGuide();

		bookingController.createNewBoking();

		if (addCustomer() && addRooms()) {
			saveAndDisplayBooking();
		} else {
			cleanupTemporaryBooking();
			System.out.println(EXIT_COMMAND + " selected. Temporary booking deleted. Goodbye :)");
			return;
		}
	}

	private void printMenuNameAndExitGuide() {
		System.out.println("CREATING NICE BOOKING ('QUIT' to exit at any time)");
		System.out.println();
	}

	private boolean addRooms() throws IOException {
		// keeps looping while user wants to add more rooms
		boolean addMoreRooms = true;
		do {
			// keeps looping until valid room found by room number
			boolean roomFound = false;
			do {
				System.out.println("Enter room number");
				String roomNumberString = reader.readLine();
				if (isExitCommand(roomNumberString)) {
					return false;
				}
				int roomNumber = 0;
				try {
					roomNumber = Integer.parseInt(roomNumberString);
					roomFound = bookingController.addRoom(roomNumber);
					if (!roomFound) {
						System.out.println("Room not found");
					}
				} catch (NumberFormatException nfe) {
					System.out.println("Unable to understand room number: '" + roomNumberString + "'.");
				}
			} while (!roomFound);

			addMoreRooms = askWhetherToAddMoreRooms();
		} while (addMoreRooms);
		return true;
	}

	private boolean askWhetherToAddMoreRooms() throws IOException {
		System.out.println("Add another room? (Y/N)");
		String addMoreRoomsString = reader.readLine();
		return addMoreRoomsString.toLowerCase().contains("y");
	}

	private boolean addCustomer() throws IOException {

		// keeps looping until valid customer is found by email
		boolean customerFound = false;
		while (!customerFound) {
			System.out.println("Enter customer email");
			String input = reader.readLine();
			if (isExitCommand(input)) {
				return false;
			}
			customerFound = bookingController.addCustomer(input);
			if (!customerFound) {
				System.out.println("Customer not found");
			}
		}
		return true;
	}

	private boolean isExitCommand(String input) {
		return input.toUpperCase().equals(EXIT_COMMAND);
	}

	private void saveAndDisplayBooking() {
		bookingController.saveBooking();
		System.out.println("Booking created:");
		System.out.println(bookingController.getBooking());
	}

	private void cleanupTemporaryBooking() {
		bookingController.setBooking(null);
	}
}