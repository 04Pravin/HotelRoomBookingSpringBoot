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
	

	/**
	 * @param room
	 * @return room object
	 * functionality - addition of room
	 */

	@Override
	public void addRoom(Room room) {
		Object[] doctorArray = {
				room.getCategory(),room.getType(),room.getArrivalDate(),room.getDepartDate(),
				room.getNoOfGuests(),room.getPrice(),room.getAvailability()
		};
		jdbcTemplate.update(Queries.INSERTQUERY,doctorArray);
		
	}


	/**
	 * @param roomNumber
	 * @param fare
	 * @return 
	 * functionality - based on roomNumber the room fare will be updated and returned to the roomServiceImpl class
	 */
	@Override
	public int updateRoom(int roomNumber, double fare) {
		return jdbcTemplate.update(Queries.UPDATEQUERY,fare,roomNumber);
		
	}

	/**
	 * @param roomNumber
	 * @return
	 * functionality - based on roomNumber the room will be deleted and an int value will be return to the roomServiceImpl class
	 */
	@Override
	public int deleteRoom(int roomNumber) {
		
		return jdbcTemplate.update(Queries.DELETEQUERY,roomNumber);
	}

	/**
	 * @return list of rooms
	 * functionality - list of all rooms will be return to the roomServiceImpl class
	 */
	@Override
	public List<Room> findAllRooms() {
		RowMapper<Room> mapper = new RoomMapper();
		List<Room>rooms = jdbcTemplate.query(Queries.RETRIVEQUERY, mapper);
		return rooms;
	}

	/**
	 * @return list of rooms
	 * functionality - list of all rooms will be returned to the roomServiceImpl class
	 */
	@Override
	public List<Room> findByLessPrice() {
		RowMapper<Room> mapper = new RoomMapper();
		List<Room>rooms = jdbcTemplate.query(Queries.QUERYBYPRICE,mapper);
		return rooms;
	}

	/**
	 * @param category
	 * @param price
	 * @return list of rooms based on category and price
	 * functionality - based on category and price list will be returned to the roomServiceImpl class 
	 */
	@Override
	public List<Room> findByCategoryAndPrice(String category, double price) {
		RowMapper<Room> mapper = new RoomMapper();
		List<Room>rooms = jdbcTemplate.query(Queries.QUERYBYCATEGORYANDPRICEFEES,mapper,category,price);
		return rooms;
	}

	/**
	 * @param category
	 * @return list of rooms based on category 
	 * functionality - list of rooms based on category will be returned to the roomServiceImpl class
	 */
	@Override
	public List<Room> findByCategory(String category) {
		RowMapper<Room> mapper = new RoomMapper();
		List<Room>rooms = jdbcTemplate.query(Queries.QUERYBYCATEGORY, mapper, category);
		return rooms;
	}

	/**
	 * @param roomType
	 * @param price
	 * @return list of rooms based on type and price
	 * functionality - list of rooms based on type and price will be returned to the roomServiceImpl class
	 */
	@Override
	public List<Room> findByRoomType(String roomType, double price) {
		RowMapper<Room> mapper = new RoomMapper();
		List<Room>rooms = jdbcTemplate.query(Queries.QUERYBYTYPEANDPRICE, mapper,roomType,price);
		return rooms;
	}

	/**
	 * @param startDate
	 * @param category
	 * @param roomType
	 * @return list of rooms based on startDate, category and type
	 * functionality - list of rooms based on the startDate, category and type will be returned to the roomServiceImpl class
	 */
	@Override
	public List<Room> findByAvailabilityAndType(LocalDate startDate, String category, String roomType) {
		RowMapper<Room> mapper = new RoomMapper();
		Object[] roomArray = {startDate,category,roomType};
		List<Room>rooms = jdbcTemplate.query(Queries.QUERYBYAVAILABILITYANDTYPE, mapper,roomArray);
		return rooms;
	}
	
	/**
	 * @param startDate
	 * @return list of rooms based on startDate
	 * functionality - list of rooms based on startDate will be returned to the roomServiceImpl class
	 */
	@Override
	public List<Room> findByAvailability(LocalDate startDate) {
		RowMapper<Room> mapper = new RoomMapper();
		List<Room>rooms = jdbcTemplate.query(Queries.QUERYBYAVAILABILITY,mapper,startDate);
		return rooms;
	}
	

}
