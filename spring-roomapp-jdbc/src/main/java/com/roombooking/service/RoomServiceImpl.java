package com.roombooking.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.roombooking.dao.IRoomDao;
import com.roombooking.exception.CategoryNotFoundException;
import com.roombooking.exception.RoomNotAvailableException;
import com.roombooking.exception.TypeNotFoundException;
import com.roombooking.model.Room;
@Service
public class RoomServiceImpl implements IRoomService {
	IRoomDao roomDao;
	
	public RoomServiceImpl(IRoomDao roomDao) {
		super();
		this.roomDao = roomDao;
	}

	/**
	 * @param room
	 * @return a room object
	 * functionality - room object from the roomDaoImpl will be returned to the main class
	 */
	@Override
	public void addRoom(Room room) {
		 roomDao.addRoom(room);

	}

	/**
	 * @param roomNumber
	 * @param fare
	 * @return fare and roomNumber
	 * functionality - based on roomNumber and the fare from the roomDaoImpl class will be returned to the main class
	 */
	@Override
	public int updateRoom(int roomNumber, double fare) {
		return roomDao.updateRoom(roomNumber, fare);

	}

	/**
	 * @param roomNumber
	 * @return roomNumber
	 * functionality - roomNumber from the roomDaoImpl will be returned to the main class
	 */
	@Override
	public int deleteRoom(int roomNumber) {
		return roomDao.deleteRoom(roomNumber);

	}

	/**
	 * @return list of rooms
	 * functionality - list of rooms from the roomDaoImpl are sorted based on roomNumber and returned to main class
	 */
	@Override
	public List<Room> getAllRooms() {
		List<Room> rooms = new ArrayList<>();
		rooms = roomDao.findAllRooms().stream()
				.sorted((roomOne, roomTwo) -> roomOne.getRoomNumber().compareTo(roomTwo.getRoomNumber()))
				.collect(Collectors.toList());
		return rooms;
	}

	/**
	 * @param category
	 * @param price
	 * @return list of rooms based on category and price
	 * @throws CategoryNotFoundException
	 * functionality -  list of rooms from the roomDaoImpl will be returned to the main class. If any one of the parameter mismatches or if the list is empty exception will be thrown
	 */
	@Override
	public List<Room> getByCategoryAndPrice(String category, double price) throws CategoryNotFoundException {
		List<Room> rooms = roomDao.findByCategoryAndPrice(category, price);
		rooms = rooms.stream().sorted((roomOne, roomTwo) -> roomOne.getRoomNumber().compareTo(roomTwo.getRoomNumber()))
				.collect(Collectors.toList());
		if (rooms.isEmpty()) {
			throw new CategoryNotFoundException("Ivalid category");
		}

		return rooms;
	}

	/**
	 * @param category
	 * @return list of rooms based on category only
	 * @throws CategoryNotFoundException
	 * functionality -  list from the roomDaoImpl will be sorted based on the roomNumber and returned to main class based on the category if the category is not found or if the list is empty exception will be thrown
	 */
	@Override
	public List<Room> getByCategory(String category) throws CategoryNotFoundException {
		List<Room> rooms = roomDao.findByCategory(category);
		rooms = rooms.stream()
				.sorted((roomThree, roomFour) -> roomThree.getRoomNumber().compareTo(roomFour.getRoomNumber()))
				.collect(Collectors.toList());
		if (rooms.isEmpty()) {
			throw new CategoryNotFoundException("Sorry searching category is not available");
		}
		return rooms;
	}

	/**
	 * @param roomType
	 * @param price
	 * @return list of rooms based on type and price
	 * @throws TypeNotFoundException
	 * functionality - list from the roomDaoImpl class will be sorted and returned to main class based on the type and price. If any one of the parameter mismatches or if the list returns empty exception will be thrown
	 */
	@Override
	public List<Room> getByRoomType(String roomType, double price) throws TypeNotFoundException {
		List<Room> rooms = roomDao.findByRoomType(roomType, price);
		rooms = rooms.stream()
				.sorted((roomThree, roomFour) -> roomThree.getRoomNumber().compareTo(roomFour.getRoomNumber()))
				.collect(Collectors.toList());

		if (rooms.isEmpty()) {
			throw new TypeNotFoundException("Sorry your search is not available");
		}

		return rooms;
	}

	/**
	 * @return list of rooms sorted by less price
	 * functionality -  list from the roomDaoImpl will be sorted based on minimum price and returned to main class 
	 */
	@Override
	public List<Room> getByLessPrice() {
		List<Room> rooms = roomDao.findByLessPrice();
		rooms = rooms.stream()
				.sorted((roomOne, roomTwo) -> ((Double) roomOne.getPrice()).compareTo(((Double) roomTwo.getPrice())))
				.collect(Collectors.toList());

		return rooms;
	}

	/**
	 * @param startDate
	 * @param category
	 * @param roomType
	 * @return list of rooms based on startDate, category and roomType
	 * @throws RoomNotAvailableException
	 * functionality - list from the roomDaoImpl will be sorted based on arrivalDate list will be returned to the main class. If the list is empty exception will be thrown
	 */
	@Override
	public List<Room> getByAvailabilityAndType(LocalDate startDate, String category, String roomType)
			throws RoomNotAvailableException {

		List<Room> rooms = new ArrayList<>();
		rooms = roomDao.findByAvailabilityAndType(startDate, category, roomType).stream()
				.sorted((roomOne, roomTwo) -> roomOne.getArrivalDate().compareTo(roomTwo.getArrivalDate()))
				.collect(Collectors.toList());

		if (rooms.isEmpty()) {
			throw new RoomNotAvailableException("Sorry rooms are not available for your search");
		} else {

			return rooms;
		}
	}

	/**
	 * @param startDate
	 * @return list of rooms based on startDate
	 * @throws RoomNotAvailableException
	 * functionality - list from the roomDaoImpl will be stored in another list and it will be sorted based on the ArrivalDate and the list will be returned to the main class. If the list is empty exception will be thrown
	 */
	@Override
	public List<Room> getByAvailability(LocalDate startDate) throws RoomNotAvailableException {
		List<Room> rooms = new ArrayList<>();
		rooms = roomDao.findByAvailability(startDate).stream()
				.sorted((roomOne, roomTwo) -> roomOne.getArrivalDate().compareTo(roomTwo.getArrivalDate()))
				.collect(Collectors.toList());

		if (rooms.isEmpty()) {
			throw new RoomNotAvailableException("Sorry rooms are not available for your search");
		} else {

			return rooms;
		}
	}
}
