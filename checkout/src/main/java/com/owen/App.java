package com.owen;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class App
{
    // root dir
    private final String homeDir = "/Users/yuwenyun/Downloads";

    public static void main( String[] args )
    {
        // initial dir structure
        Map<String, String[]> files = new HashMap<>();
        files.put("", new String[]{"/f.mp3", "/g.docx"});
        files.put("/aaa", new String[]{"/a.docx", "/b.xlsx"});
        files.put("/aaa/bbb", new String[]{"/e.xlsx"});
        files.put("/aaa/bbb/ccc", new String[]{"/d.mp3"});

        // category detail
        Map<String, String> categories = new HashMap<>();
        categories.put("docx", "/word");
        categories.put("mp3", "/music");
        categories.put(".xlsx", "/excel");

        // operation
        // 1. create dir structure
        // 2. create files in those dirs
        // 3. categorize all the files in those dirs
        App app = new App();
        app.createDirs("/aaa/bbb/ccc");
        app.createFiles(files);
        app.categorizeFile(app.homeDir, categories);
    }

    private void createDirs(String dirPath)
    {
        assert dirPath != null && !dirPath.trim().equals("");

        File dir = new File(homeDir);
        if(dir.exists() && dir.isDirectory()){
            String path = homeDir + dirPath;
            File file = new File(path);
            if(!file.exists()){
                file.mkdirs();
            }
        }
    }

    private void createFiles(Map<String, String[]> files)
    {
        assert files != null && files.size() > 0;
        Set<Map.Entry<String, String[]>> entries = (Set<Map.Entry<String, String[]>>) files.entrySet();
        for(Map.Entry<String, String[]> entry : entries){
            String path = entry.getKey();
            String[] sameLevelFiles = entry.getValue();

            File dir = new File(homeDir + path);
            if(dir.exists() && dir.isDirectory()){
                Arrays.stream(sameLevelFiles).forEach(file -> {
                    File newFile = new File(dir.getPath() + file);
                    if(!newFile.exists()){
                        try {
                            newFile.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    private void categorizeFile(String rootPath, Map<String, String> categories)
    {
        assert rootPath != null && !rootPath.trim().equals("") && categories != null && categories.size() > 0;
        File homeDir = new File(rootPath);
        if(homeDir.exists() && homeDir.isDirectory()){
            File[] childFiles = homeDir.listFiles();
            Arrays.stream(childFiles).forEach(file -> {
                if(file.isDirectory()){
                    categorizeFile(file.getPath(), categories);
                }
                categories.keySet().stream().forEach(category -> {
                    if(file.getName().endsWith(category)){
                        File categoryDir = new File(this.homeDir + categories.get(category));
                        if(!categoryDir.exists()){
                            categoryDir.mkdir();
                        }
                        categoryDir = new File(categoryDir.getPath() + File.separator + file.getName());
                        try {
                            Files.copy(file.toPath(), categoryDir.toPath());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            });
        }
    }
}
