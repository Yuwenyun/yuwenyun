package com.owen.mapper;

import com.owen.model.Registry;
import com.owen.model.RegistryKey;

public interface RegistryMapper {
    int deleteByPrimaryKey(RegistryKey key);

    int insert(Registry record);

    int insertSelective(Registry record);

    Registry selectByPrimaryKey(RegistryKey key);

    int updateByPrimaryKeySelective(Registry record);

    int updateByPrimaryKey(Registry record);
}