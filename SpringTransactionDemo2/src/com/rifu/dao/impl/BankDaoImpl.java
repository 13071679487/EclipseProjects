package com.rifu.dao.impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.rifu.dao.BankDao;

public class BankDaoImpl implements BankDao {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public int inMoney(int money, int userId) {
		String sql = "update t_count set count=count+:money where id=:id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("money", money);
		sps.addValue("id", userId);
		return namedParameterJdbcTemplate.update(sql, sps);
	}

	@Override
	public int outMoney(int money, int userId) {
		String sql = "update t_count set count=count-:money where id=:id";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("money", money);
		sps.addValue("id", userId);
		return namedParameterJdbcTemplate.update(sql, sps);
	}

}
