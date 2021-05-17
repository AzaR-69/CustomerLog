package com.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.model.LogModel;

public interface LogRepository extends JpaRepository<LogModel,String>{
	List<LogModel> findByDate(String date);
}	
