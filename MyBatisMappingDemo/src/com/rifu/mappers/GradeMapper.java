package com.rifu.mappers;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.rifu.model.Grade;

public interface GradeMapper {
	
	@Select("select * from grade where id=#{id}")
	@Results(
			{
				@Result(id=true,column="id",property="id"),
				@Result(column="gradeName",property="gradeName"),
				@Result(column="id",property="students",many=@Many(select="com.rifu.mappers.StudentMapper.getStudentByGradeId"))
			}
	)
	public Grade findGradeById(Integer gradeId);
}