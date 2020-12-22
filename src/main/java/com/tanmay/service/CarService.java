package com.tanmay.service;

import java.util.List;
import java.util.Optional;

import com.tanmay.entity.Car;
import com.tanmay.response.CarResponse;

public interface CarService {
	public List<CarResponse> getCars(int pageNo,int pageSize);
	public Optional<Car> getOneCar(int id);
	public void updateCar(Car car);
	public void deleteCar(int id);
	public void createCar(Car car);

}
