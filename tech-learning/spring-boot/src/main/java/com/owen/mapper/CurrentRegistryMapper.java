package com.owen.mapper;

import com.owen.model.CurrentRegistry;

public interface CurrentRegistryMapper {
    int insert(CurrentRegistry record);

    int insertSelective(CurrentRegistry record);
}