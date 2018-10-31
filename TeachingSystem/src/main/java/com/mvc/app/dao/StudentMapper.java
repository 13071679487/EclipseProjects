package com.mvc.app.dao;

import com.mvc.app.model.Student;
import com.mvc.app.model.StudentExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(String stuid);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExampleWithBLOBs(StudentExample example);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(String stuid);
    
    Student selectByPrimaryKeyWithCourseMajor(String stuid);
    List<Student> selectByExampleWithCourseMajor(StudentExample example);
    List<Student> selectByExampleWithBLOBsCourseMajor(StudentExample example);
    
    //==================统计查询========================
    //生源地人数
    List<Map<String,Object>> selectGroupByAddress();
    //性别统计课程平均成绩
    List<Map<String,Object>> selectAVGBySex();
    //各院系不及格课程名单
    List<Map<String,Object>> selectFail();
    //查询各院系各课程平均成绩
    List<Map<String,Object>> selectAVGByCol();
    //查询各院系性别人数
    List<Map<String,Object>> selectCountBySex();
    
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExampleWithBLOBs(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKeyWithBLOBs(Student record);

    int updateByPrimaryKey(Student record);
}