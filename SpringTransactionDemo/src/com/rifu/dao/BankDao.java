package com.rifu.dao;

public interface BankDao {
	public int inMoney(int money,int userId);
	public int outMoney(int money,int userId);
}
