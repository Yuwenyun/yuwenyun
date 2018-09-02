package com.owen.utils.io;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.Optional;

public class FileUtil
{
    public static Optional<File> getFile(String path)
    {
        assert StringUtils.isNotBlank(path);
        File file = new File(path);
        if(file.exists()){
            return Optional.of(file);
        }
        else{
            URL url = FileUtil.class.getClassLoader().getResource(path);
            String filePath = url.getPath();
            file = new File(filePath);

            if(file.exists()){
                return Optional.of(file);
            }
            else{
                return Optional.empty();
            }
        }
    }
}
