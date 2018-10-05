package com.cybage.springdemo.SpringRestDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.springdemo.SpringRestDemo.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}