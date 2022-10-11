package com.roombooking;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roombooking.model.Room;
import com.roombooking.model.RoomCategory;
import com.roombooking.model.RoomType;
import com.roombooking.service.IRoomService;

@SpringBootApplication
public class SpringRoomappJdbcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringRoomappJdbcApplication.class, args);
	}

	@Autowired
	IRoomService iRoomService;
	
	public SpringRoomappJdbcApplication(IRoomService iRoomService) {
		super();
		this.iRoomService = iRoomService;
	}

	@Override
	public void run(String... args) throws Exception {
		Room room = new Room("AC",RoomType.STANDARD.type,LocalDate.of(2022, 10, 10),LocalDate.of(2022, 10, 20),2,8900,1);
		iRoomService.addRoom(room);
		
		//iRoomService.updateRoom(6, 7000);
		
		//iRoomService.deleteRoom(7);
		System.out.println("All rooms");
		iRoomService.getAllRooms().forEach(System.out::println);
		System.out.println();
		
		System.out.println("Sorted by price");
		iRoomService.getByLessPrice().forEach(System.out::println);
		System.out.println();
		
		System.out.println("Based on category and price");
		iRoomService.getByCategoryAndPrice("AC", 5000).forEach(System.out::println);
		System.out.println();
		
		System.out.println("Based on room type and price");
		iRoomService.getByRoomType("King size", 7500).forEach(System.out::println);
		System.out.println();
		
		System.out.println("Based on category");
		iRoomService.getByCategory("AC").forEach(System.out::println);
		System.out.println();
		
		System.out.println("Based on start date");
		iRoomService.getByAvailability(LocalDate.of(2022, 10, 10)).forEach(System.out::println);
		System.out.println();
		
		System.out.println("Based on start date, category and type");
		iRoomService.getByAvailabilityAndType(LocalDate.of(2022, 9, 24), "AC", "Standard").forEach(System.out::println);
		System.out.println();
		
	}

}
