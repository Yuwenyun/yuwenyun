package com.owen.mapper;

import com.owen.model.LatestDate;

public interface LatestDateMapper {
    int insert(LatestDate record);

    int insertSelective(LatestDate record);
}