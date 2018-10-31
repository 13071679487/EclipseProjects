package com.rifu.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.rifu.dao.BankDao;
import com.rifu.service.BankService;

public class BankServiceImpl implements BankService{
	private BankDao bankDao;
	
	private TransactionTemplate transactionTemplate;
	
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}


	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}


	@Override
	public void transferAccount(int count, int userIdFrom, int userIdTo) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				bankDao.outMoney(count, userIdFrom);
				bankDao.inMoney(count, userIdTo);
			}
		});
	}

}
