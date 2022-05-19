package roombooking.model;

public class Room {

	private int number;
	private int floor;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public Room(int number, int floor) {
		this.number = number;
		this.floor = floor;
	}
}