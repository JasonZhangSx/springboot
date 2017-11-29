package com.springboot.dao;

import com.springboot.common.DatabaseContextHolder;
import com.springboot.common.DatabaseType;
import com.springboot.domain.QuestionType;
import com.springboot.mapper.QuestionTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionTypeDao {

    @Autowired
    private QuestionTypeMapper questionTypeMapper;

    public List<QuestionType> getAll() {
        DatabaseContextHolder.setDatabaseType(DatabaseType.MYTESTDB_1);
        return questionTypeMapper.getAll();
    }

    public QuestionType getById(int id) {
        return questionTypeMapper.getById(id);
    }

    public int save(QuestionType type) {
        return questionTypeMapper.insertWithBackId(type);
    }

    public int update(QuestionType type) {
        return questionTypeMapper.update(type);
    }
}
