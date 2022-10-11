package com.roombooking.model;

import java.time.LocalDate;

public class Room {
	private Integer roomNumber;
	private String category;
	private String type;
	private LocalDate arrivalDate;
	private LocalDate departDate;
	private int noOfGuests;
	private double price;
	private int availability;

	/**
	 * @param roomNumber
	 * @param category
	 * @param type
	 * @param arrivalDate
	 * @param departDate
	 * @param noOfGuests
	 * @param price
	 * @param availability
	 * 
	 * parameterized constructor
	 */
	public Room(Integer roomNumber, String category, String type, LocalDate arrivalDate, LocalDate departDate,
			int noOfGuests, double price, int availability) {
		super();
		this.roomNumber = roomNumber;
		this.category = category;
		this.type = type;
		this.arrivalDate = arrivalDate;
		this.departDate = departDate;
		this.noOfGuests = noOfGuests;
		this.price = price;
		this.availability = availability;
	}

	/**
	 * @param category
	 * @param type
	 * @param arrivalDate
	 * @param departDate
	 * @param noOfGuests
	 * @param price
	 * @param availability
	 * 
	 * parameterized constructor
	 */
	public Room(String category, String type, LocalDate arrivalDate, LocalDate departDate, int noOfGuests,
			double price, int availability) {
		super();
		this.category = category;
		this.type = type;
		this.arrivalDate = arrivalDate;
		this.departDate = departDate;
		this.noOfGuests = noOfGuests;
		this.price = price;
		this.availability = availability;
	}

	/**
	 * default constructor
	 */
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return roomNumber
	 * functionality returns roomNumber in the form of integer
	 */
	public Integer getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber
	 * functionality - sets/updates the roomNumber
	 */
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * @return category 
	 * functionality - returns category in the form of string
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 * functionality - sets/updates category 
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return type
	 * functionality - return type in the form of string
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 * functionality - sets/updates type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return returns arrivalDate
	 * functionality - returns arrivalDate in the form of LocalDate format
	 */
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @param arrivalDate
	 * functionality - sets/updates arrivalDate
	 */
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * @return departDate 
	 * functionality - returns departDate in the form of LocalDate format
	 */
	public LocalDate getDepartDate() {
		return departDate;
	}

	/**
	 * @param departDate
	 * functionality - sets/updates departDate
	 */
	public void setDepartDate(LocalDate departDate) {
		this.departDate = departDate;
	}

	/**
	 * @return noOfGuests
	 * functionality - returns noOfGuests in the form of int
	 */
	public int getNoOfGuests() {
		return noOfGuests;
	}

	/**
	 * @param noOfGuests
	 * functionality - sets/updates noOfGuests
	 */
	public void setNoOfGuests(int noOfGuests) {
		this.noOfGuests = noOfGuests;
	}

	/**
	 * @return price
	 * functionality - returns price in the form of double
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 * functionality - sets/updates price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * @return availability 
	 * functionality - returns availability in the form of int
	 */
	public int getAvailability() {
		return availability;
	}

	/**
	 * @param availability
	 * functionality - sets/updates availability
	 */
	public void setAvailability(int availability) {
		this.availability = availability;
	}

	/**
	 * @return String
	 * functionality - converts the object in the form of string and returns it
	 */
	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", category=" + category + ", type=" + type + ", arrivalDate="
				+ arrivalDate + ", departDate=" + departDate + ", noOfGuests=" + noOfGuests + ", price=" + price
				+ ", availability=" + availability + "]";
	}


}
