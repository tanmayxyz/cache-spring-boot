package com.tanmay.response;

import com.tanmay.entity.Car;

import lombok.Data;

@Data
public class CarResponse {
	private  Integer price;
	private String modelNumber;
	private String showRoomCode;
	private boolean avalible;
	private String assignedEmployee;
	
	public CarResponse(Car car) {
		this.price = car.getPrice();
		this.modelNumber = car.getModelNumber();
		this.showRoomCode = car.getShowRoomCode();
		this.avalible = car.isAvalible();
		this.assignedEmployee = car.getAssignedEmployee();
	}

}
