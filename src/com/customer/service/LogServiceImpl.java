package com.customer.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.dao.LogDao;
import com.customer.model.Log;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao logDao;

	@Override
	public void log(String message, Date date) {
		Log log = new Log();
		log.setDate(date);
		log.setMessage(message);
		logDao.log(log);
	}

}
