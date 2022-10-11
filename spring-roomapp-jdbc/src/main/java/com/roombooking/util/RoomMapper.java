package com.roombooking.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.roombooking.model.Room;

public class RoomMapper implements RowMapper<Room> {


	@Override
	public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Room room = new Room();

		int roomNumber = rs.getInt(1);
		String category = rs.getString(2);
		String roomType = rs.getString(3);
		LocalDate startDate = rs.getDate(4).toLocalDate();
		LocalDate endDate = rs.getDate(5).toLocalDate();
		int noOfGuests = rs.getInt(6);
		double price = rs.getDouble(7);
		int availability = rs.getInt(8);
		room.setRoomNumber(roomNumber);
		room.setCategory(category);
		room.setType(roomType);
		room.setArrivalDate(startDate);
		room.setDepartDate(endDate);
		room.setNoOfGuests(noOfGuests);
		room.setPrice(price);
		room.setAvailability(availability);

		return room;
	}

}
