package com.owen.utils.io;

import org.junit.Test;

import java.io.File;
import java.util.Optional;

public class FileUtilTest
{
    @Test
    public void getFile_relative_path()
    {
        Optional<File> file = FileUtil.getFile("test.xml");
        file.ifPresent(System.out::print);
    }

    @Test
    public void getFile_absolute_path()
    {
        Optional<File> file = FileUtil.getFile("/Users/yuwenyun/Documents/InstalledTools.txt");
        file.ifPresent(System.out::print);
    }
}
