package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.customer.model.LogModel;
import com.customer.service.LogService;

@RestController
public class LogController {
	@Autowired
	LogService logService;
	@RequestMapping("/")
	public String home() {
		return "Working";
	}
	
	@GetMapping("/checkIn")
	public String checkInStatus(@RequestParam("name") String name) {
		logService.checkIn(name);
		return "Updated";
	}
	

	@GetMapping("/checkOut")
	public String checkOutStatus(@RequestParam("name") String name) {
		logService.checkOut(name);
		return "Updated";
	}
	
	
	@GetMapping("/getLog")
	public List<LogModel> getLog(@RequestParam("date") String date){
		return logService.logByDate(date);
	}
	
	@GetMapping("/getAllLog")
	public List<LogModel> getAllLog(){
		return logService.getAllLogs();
	}
}
