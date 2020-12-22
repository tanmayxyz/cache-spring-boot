package com.tanmay.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tanmay.entity.Car;
import com.tanmay.response.CarResponse;
import com.tanmay.response.ResponseMessage;
import com.tanmay.service.CarService;

@RestController
@Validated
public class CarController {
	@Autowired
	private CarService carService;
	@Autowired
	private MessageSource messageSource;
	

	@PostMapping("/car")
	public ResponseMessage saveCar(@Valid @RequestBody Car car) {
		carService.createCar(car);
		return new ResponseMessage(200, messageSource.getMessage("response.car.created", null, null));
	}

	@GetMapping("/car")
	public List<CarResponse> getAllCars(@Min(value = 0,message = "{request.car.page}")@RequestParam("page") int page,@Min(value = 0,message = "{request.page.size}") @RequestParam("size") int size) {
		return carService.getCars(page, size);
	}

	@PutMapping("/car")
	public ResponseMessage updateCar(@Valid @RequestBody Car car) {
		carService.updateCar(car);
		return new ResponseMessage(200, messageSource.getMessage("response.car.updated", null, null));
	}

	@DeleteMapping("/car")
	public ResponseMessage deleteCar(@Min(value = 0,message = "{request.id.size}") @RequestParam("id") int id) {
		carService.deleteCar(id);
		return new ResponseMessage(200, messageSource.getMessage("response.car.deleted", null, null));
	}
	
	@GetMapping("/car/{carId}")
	public Car getCar(@PathVariable("carId")Integer id) {
		return carService.getOneCar(id).get();
	}

}
