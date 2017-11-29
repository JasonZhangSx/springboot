package com.springboot.mapper;


import com.springboot.domain.QuestionType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QuestionTypeMapper {

    @Select("select * from question_types")
    public List<QuestionType> getAll();

    public QuestionType getById(int id);

    /**
     * 插入用户，并将主键设置到user中
     * 注意：返回的是数据库影响条数，即1
     */
    public int insertWithBackId(QuestionType questionType);

    public int update(QuestionType questionType);
}
