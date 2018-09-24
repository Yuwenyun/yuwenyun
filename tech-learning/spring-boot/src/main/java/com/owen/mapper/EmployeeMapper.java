package com.owen.mapper;

import com.owen.model.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer empNo);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer empNo);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}