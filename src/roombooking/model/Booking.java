package roombooking.model;

import java.util.ArrayList;
import java.util.List;

public class Booking {

	private Customer customer;
	private List<Room> bookedRooms = new ArrayList<Room>();
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void addRoom(Room roomToAdd) {
		bookedRooms.add(roomToAdd);
	}
	
	public boolean removeRoom(Room roomToRemove) {
		return bookedRooms.remove(roomToRemove);
	}
	
	public List<Room> getBookedRooms(){
		return new ArrayList<Room>(bookedRooms);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Booking for customer ");
		if(getCustomer()!= null) {
			builder.append(getCustomer().getName() + ". ");
		}
		else {
			builder.append("[none]. ");
		}
			builder.append("Rooms: ");
		for(Room room : getBookedRooms()) {
			builder.append( room.getNumber() + ", ");
		}
		return builder.toString();
	}
}