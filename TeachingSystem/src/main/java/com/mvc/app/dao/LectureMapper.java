package com.mvc.app.dao;

import com.mvc.app.model.Lecture;
import com.mvc.app.model.LectureExample;
import com.mvc.app.model.LectureKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LectureMapper {
    long countByExample(LectureExample example);

    int deleteByExample(LectureExample example);

    int deleteByPrimaryKey(LectureKey key);

    int insert(Lecture record);

    int insertSelective(Lecture record);

    List<Lecture> selectByExample(LectureExample example);

    Lecture selectByPrimaryKey(LectureKey key);

    int updateByExampleSelective(@Param("record") Lecture record, @Param("example") LectureExample example);

    int updateByExample(@Param("record") Lecture record, @Param("example") LectureExample example);

    int updateByPrimaryKeySelective(Lecture record);

    int updateByPrimaryKey(Lecture record);
}