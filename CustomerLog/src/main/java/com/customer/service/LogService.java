package com.customer.service;

import java.util.List;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customer.model.LogModel;
import com.customer.repository.LogRepository;

@Service
public class LogService {
	@Autowired
	LogRepository logRepository;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	String currentDate = dateFormat.format(new Date());
	public String getTime() {
		while(true) {
			try {
				Thread.sleep(5*100); 
				LocalTime time = LocalTime.now(ZoneId.of("Asia/Kolkata"));
				String currentTime=time.format(DateTimeFormatter.ofPattern("HH:mm"));
				return currentTime;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Transactional
	public List<LogModel> getAllLogs() {
		return logRepository.findAll();
	}

	@Transactional
	public List<LogModel> logByDate(String date) {
		return logRepository.findByDate(date);
	}

	@Transactional
	public void checkIn(String name) {
		LogModel log = new LogModel();
		log.setLogType("IN");
		log.setDate(currentDate);
		log.setTime(getTime());
		log.setId(name+getTime());
		logRepository.save(log);
	}
	
	@Transactional
	public void checkOut(String name) {
		LogModel log = new LogModel();
		log.setLogType("OUT");
		log.setDate(currentDate);
		log.setTime(getTime());
		log.setId(name+getTime());
		logRepository.save(log);
	}
}
