package com.cybage.springdemo.SpringRestDemo.service;

import java.util.List;

import com.cybage.springdemo.SpringRestDemo.entity.Car;

public interface CarService {

	public List<Car> retrieveCars();

	public Car getCar(Long carId);

	public void saveCar(Car car);

	public void deleteCar(Long carId);

	public void updateCar(Car car);
	
	public void updateCars(List<Car> cars);
	
	public List<Car> getCarsById(List<Long> carIds);
}