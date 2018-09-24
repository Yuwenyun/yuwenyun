package com.owen.mapper;

import com.owen.model.Manager;
import com.owen.model.ManagerKey;

public interface ManagerMapper {
    int deleteByPrimaryKey(ManagerKey key);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(ManagerKey key);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}