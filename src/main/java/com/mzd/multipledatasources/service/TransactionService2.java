package com.mzd.multipledatasources.service;

import com.mzd.multipledatasources.bean.TeachersBean;
import com.mzd.multipledatasources.mapper.test02.TransactionMapping2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService2 {

	@Autowired
	TransactionMapping2 ts2;

	public int saveTeacher(TeachersBean tb){
		return ts2.save(tb);
	}
}
