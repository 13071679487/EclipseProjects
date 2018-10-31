package com.rifu.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rifu.model.Student;

public interface StudentMapper {

	@Insert("insert into t_student2 values(null,#{name},#{age})")
	public int insertStudent(Student stu);

	@Update("update t_student2 set name=#{name},age=#{age} where id=#{id}")
	public int updateStudent(Student stu);
	
	@Delete("delete from t_student2 where id=#{id}")
	public int deleteStudentById(Integer id);

	@Select("select * from t_student2 where id=#{id}")
	public Student findStudentById(Integer id);
	
	@Select("select * from t_student2")
	@Results(
			{
				@Result(id=true,column="id",property="id"),
				@Result(column="name",property="name"),
				@Result(column="age",property="age"),
				@Result(column="addressId",property="address",one=@One(select="com.rifu.mappers.AddressMapper.findAddressById")),
				@Result(column="gradeId",property="grade",one=@One(select="com.rifu.mappers.GradeMapper.findGradeById"))
			}
	)
	public List<Student> getStudents();
	
	
	@Select("select * from t_student2 where id=#{id}")
	@Results(
			{
				@Result(id=true,column="id",property="id"),
				@Result(column="name",property="name"),
				@Result(column="age",property="age"),
				@Result(column="addressId",property="address",one=@One(select="com.rifu.mappers.AddressMapper.findAddressById")),
				@Result(column="gradeId",property="grade",one=@One(select="com.rifu.mappers.GradeMapper.findGradeById"))
			}
	)
	public Student getStudentWithAddressById(Integer id);
	
	@Select("select * from t_student2 where gradeId=#{gradeId}")
	@Results(
			{
				@Result(id=true,column="id",property="id"),
				@Result(column="name",property="name"),
				@Result(column="age",property="age"),
				@Result(column="addressId",property="address",one=@One(select="com.rifu.mappers.AddressMapper.findAddressById")),
				@Result(column="gradeId",property="grade",one=@One(select="com.rifu.mappers.GradeMapper.findGradeById"))
			}
	)
	public Student getStudentByGradeId(Integer gradeId);
	
	
}
