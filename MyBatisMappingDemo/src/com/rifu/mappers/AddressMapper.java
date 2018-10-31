package com.rifu.mappers;

import org.apache.ibatis.annotations.Select;

import com.rifu.model.Address;

public interface AddressMapper {
	
	@Select("select * from t_address where id=#{id}")
	public Address findAddressById(Integer addressId);
	
}