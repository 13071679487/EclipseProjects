package com.rifu.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.rifu.dao.BankDao;
import com.rifu.service.BankService;
@Transactional
public class BankServiceImpl implements BankService{
	private BankDao bankDao;
	


	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}


	@Override
	public void transferAccount(int count, int userIdFrom, int userIdTo) {
		bankDao.outMoney(count, userIdFrom);
		bankDao.inMoney(count, userIdTo);
	}

}