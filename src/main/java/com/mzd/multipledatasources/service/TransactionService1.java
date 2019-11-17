package com.mzd.multipledatasources.service;

import com.mzd.multipledatasources.bean.TestBean;
import com.mzd.multipledatasources.mapper.test01.TransactionMapping1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService1 {

	@Autowired
	TransactionMapping1 ts1;

	public int savetestBean(TestBean tb){
		return ts1.save(tb);
	}

}
