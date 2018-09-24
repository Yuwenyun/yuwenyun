package com.owen.mapper;

import com.owen.model.Title;
import com.owen.model.TitleKey;

public interface TitleMapper {
    int deleteByPrimaryKey(TitleKey key);

    int insert(Title record);

    int insertSelective(Title record);

    Title selectByPrimaryKey(TitleKey key);

    int updateByPrimaryKeySelective(Title record);

    int updateByPrimaryKey(Title record);
}