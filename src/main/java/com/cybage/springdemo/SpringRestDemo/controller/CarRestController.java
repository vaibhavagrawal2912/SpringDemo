package com.cybage.springdemo.SpringRestDemo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.springdemo.SpringRestDemo.entity.Car;
import com.cybage.springdemo.SpringRestDemo.service.CarService;

@RestController
//@RequestMapping("/car")
public class CarRestController {

	@Autowired
	private CarService carService;
	
	@GetMapping("/cars")
	public List<Car> getCars() {
		List<Car> cars = carService.retrieveCars();
		return cars;
	}

	@GetMapping("/cars/{carId}")
	public Car getCar(@PathVariable(name = "carId") Long carId) {
		return carService.getCar(carId);
	}

	@PostMapping("/car")
	public Car saveCar(@RequestBody Car car) {
		carService.saveCar(car);
		System.out.println("Car Saved Successfully");
		return carService.getCar(car.getId());
	}

	@PostMapping("/cars")
	public List<Car> saveCar(@RequestBody List<Car> cars) {
		if (CollectionUtils.isNotEmpty(cars)) {
			carService.updateCars(cars);
			System.out.println("Cars Saved Successfully");
		}
		return carService.retrieveCars();
	}

	@DeleteMapping("/cars/{carId}")
	public void deleteCar(@PathVariable(name = "carId") Long carId) {
		carService.deleteCar(carId);
		System.out.println("Car Deleted Successfully");
	}

	@PutMapping("/cars/{carId}")
	public void updateCar(@RequestBody Car car, @PathVariable(name = "carId") Long carId) {
		Car carObject = carService.getCar(carId);
		if (carObject != null) {
			carService.updateCar(car);
			System.out.println("Car Saved Successfully");
		}
	}
	
	@PutMapping("/updateCars")
	public List<Car> updateCars(@RequestBody ArrayList<Car> listOfCars) {
		if (CollectionUtils.isNotEmpty(listOfCars)) {
			carService.updateCars(listOfCars);
			System.out.println("Cars Updated Successfully");
		}
		return carService.getCarsById(listOfCars.stream().map(Car::getId).collect(Collectors.toList()));
	}
	
//	private Boolean checkIfCarExist(List<Car> listToCheck) {
//		if (CollectionUtils.isNotEmpty(listToCheck)) {
//			
//		}
//		return false;
//	}
}