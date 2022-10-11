package com.roombooking.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.roombooking.model.Room;
import com.roombooking.util.Queries;
import com.roombooking.util.RoomMapper;

@Repository
public class RoomDaoImpl implements IRoomDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addRoom(Room room) {
		Object[] doctorArray = {
				room.getCategory(),room.getType(),room.getArrivalDate(),room.getDepartDate(),
				room.getNoOfGuests(),room.getPrice(),room.getAvailability()
		};
		jdbcTemplate.update(Queries.INSERTQUERY,doctorArray);
		
	}

	@Override
	public int updateRoom(int roomNumber, double fare) {
		return jdbcTemplate.update(Queries.UPDATEQUERY,fare,roomNumber);
		
	}

	@Override
	public int deleteRoom(int roomNumber) {
		
		return jdbcTemplate.update(Queries.DELETEQUERY,roomNumber);
	}

	@Override
	public List<Room> findAllRooms() {
		RowMapper<Room> mapper = new RoomMapper();
		List<Room>rooms = jdbcTemplate.query(Queries.RETRIVEQUERY, mapper);
		return rooms;
	}

	@Override
	public List<Room> findByLessPrice() {
		RowMapper<Room> mapper = new RoomMapper();
		List<Room>rooms = jdbcTemplate.query(Queries.QUERYBYPRICE,mapper);
		return rooms;
	}

	@Override
	public List<Room> findByCategoryAndPrice(String category, double price) {
		RowMapper<Room> mapper = new RoomMapper();
		List<Room>rooms = jdbcTemplate.query(Queries.QUERYBYCATEGORYANDPRICEFEES,mapper,category,price);
		return rooms;
	}

	@Override
	public List<Room> findByCategory(String category) {
		RowMapper<Room> mapper = new RoomMapper();
		List<Room>rooms = jdbcTemplate.query(Queries.QUERYBYCATEGORY, mapper, category);
		return rooms;
	}

	@Override
	public List<Room> findByRoomType(String roomType, double price) {
		RowMapper<Room> mapper = new RoomMapper();
		List<Room>rooms = jdbcTemplate.query(Queries.QUERYBYTYPEANDPRICE, mapper,roomType,price);
		return rooms;
	}

	@Override
	public List<Room> findByAvailabilityAndType(LocalDate startDate, String category, String roomType) {
		RowMapper<Room> mapper = new RoomMapper();
		Object[] roomArray = {startDate,category,roomType};
		List<Room>rooms = jdbcTemplate.query(Queries.QUERYBYAVAILABILITYANDTYPE, mapper,roomArray);
		return rooms;
	}

	@Override
	public List<Room> findByAvailability(LocalDate startDate) {
		RowMapper<Room> mapper = new RoomMapper();
		List<Room>rooms = jdbcTemplate.query(Queries.QUERYBYAVAILABILITY,mapper,startDate);
		return rooms;
	}
	

}
