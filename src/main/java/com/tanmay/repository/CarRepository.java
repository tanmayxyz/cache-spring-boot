package com.tanmay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanmay.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
	boolean existsByModelName(String modelName);
}
