package com.owen.utils.format;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        TreeGenerator.getDuplicateEleTree();
    }
    private static final String EXAMPLE_TXT_PATH =
            "C:UsersLilykosworkspaceApacheCommonsExampleExampleFolderexampleTxt.txt";

    private static final String PARENT_DIR =
            "C:UsersLilykosworkspaceApacheCommonsExample";

    public static void runExample() throws IOException
    {
        System.out.println("Utility Classes example...");

        // FilenameUtils

        System.out.println("Full path of exampleTxt: " +
                FilenameUtils.getFullPath(EXAMPLE_TXT_PATH));
    }
}
