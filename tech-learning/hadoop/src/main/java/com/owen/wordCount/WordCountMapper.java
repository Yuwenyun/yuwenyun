package com.owen.wordCount;

import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper
{
//    private final static IntWritable

    @Override
    protected void map(Object key, Object value, Context context) throws IOException, InterruptedException
    {
        super.map(key, value, context);
    }
}
