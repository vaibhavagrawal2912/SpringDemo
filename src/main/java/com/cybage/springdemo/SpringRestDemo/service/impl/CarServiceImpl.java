package com.cybage.springdemo.SpringRestDemo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.springdemo.SpringRestDemo.entity.Car;
import com.cybage.springdemo.SpringRestDemo.repository.CarRepository;
import com.cybage.springdemo.SpringRestDemo.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public List<Car> retrieveCars() {
		List<Car> cars = carRepository.findAll();
		return cars;
	}

	public Car getCar(Long carId) {
		Optional<Car> optEmp = carRepository.findById(carId);
		return optEmp.get();
	}

	public void saveCar(Car car) {
		carRepository.save(car);
	}

	public void deleteCar(Long carId) {
		carRepository.deleteById(carId);
	}

	public void updateCar(Car car) {
		carRepository.save(car);
	}
	
	public void updateCars(List<Car> cars) {
		carRepository.saveAll(cars);
	}
	
	public List<Car> getCarsById(List<Long> carIds) {
		return carRepository.findAllById(carIds);
	}
}