package com.tanmay.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tanmay.entity.Car;
import com.tanmay.exception.CarAlreadyExistException;
import com.tanmay.exception.CarDontExist;
import com.tanmay.repository.CarRepository;
import com.tanmay.response.CarResponse;
import com.tanmay.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;
	@Autowired
	private MessageSource messageSource;
	
	@Override
	@Transactional
	public List<CarResponse> getCars(int pageNo, int pageSize) {
		return carRepository.findAll(PageRequest.of(pageNo, pageSize)).getContent().stream()
					.map(CarResponse::new).collect(toList());
	}

	@Override
	@Transactional
	public Optional<Car> getOneCar(int id) {
		return carRepository.findById(id);
	}

	@Override
	@Transactional
	public void updateCar(Car car) {
		if(!carRepository.existsById(car.getId())) {
			throw new CarDontExist(messageSource.getMessage("response.car.dont-exist", null, null));
		}
		carRepository.save(car);

	}
	@Override
	@Transactional
	public void createCar(Car car) {
		
		if(carRepository.existsByModelName(car.getModelName())) {
			throw new CarAlreadyExistException(messageSource.getMessage("response.car.already-exists", null, null));
		}
		carRepository.save(car);

	}

	@Override
	@Transactional
	public void deleteCar(int id) {
		carRepository.deleteById(id);

	}

}
