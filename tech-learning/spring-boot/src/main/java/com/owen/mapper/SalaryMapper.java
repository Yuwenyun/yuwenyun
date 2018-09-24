package com.owen.mapper;

import com.owen.model.Salary;
import com.owen.model.SalaryKey;

public interface SalaryMapper {
    int deleteByPrimaryKey(SalaryKey key);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(SalaryKey key);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);
}