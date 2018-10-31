package com.mvc.app.dao;

import com.mvc.app.model.Major;
import com.mvc.app.model.MajorExample;
import com.mvc.app.model.MajorKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MajorMapper {
    long countByExample(MajorExample example);

    int deleteByExample(MajorExample example);

    int deleteByPrimaryKey(MajorKey key);
    int deleteByMstuid(String key);

    int insert(Major record);

    int insertSelective(Major record);

    List<Major> selectByExample(MajorExample example);
    //根据stuid查询major
    List<Major> selectByStuid(String stuid);
    
    Major selectByPrimaryKey(MajorKey key);
    Major selectByMcourseid(String key);

    int updateByExampleSelective(@Param("record") Major record, @Param("example") MajorExample example);

    int updateByExample(@Param("record") Major record, @Param("example") MajorExample example);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}