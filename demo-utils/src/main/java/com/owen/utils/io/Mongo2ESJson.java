package com.owen.utils.io;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.UUID;

public class Mongo2ESJson
{
    public static void main(String[] args) throws IOException
    {
        toESJson(new File("/Users/yuwenyun/Downloads/retaurants.json"),
                "/Users/yuwenyun/Downloads/restaurants_es.json");
    }

    public static void toESJson(File mongoJson, String destination) throws IOException
    {
        assert mongoJson != null && mongoJson.exists() && StringUtils.isNotBlank(destination);

        // basic io operation
        basic_io(mongoJson, destination);
    }

    private static void basic_io(File json, String destination) throws IOException
    {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(new FileInputStream(json)));
        final String prefix = "{\"index\":{\"_index\":\"restaurants\", \"_type\":\"doc\", \"_id\":";
        String input = stdIn.readLine();

        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destination)));

        while(input != null)
        {
            StringBuffer newString = new StringBuffer(prefix);
            newString.append("\"").append(UUID.randomUUID()).append("\"").append("}}\r\n");
            newString.append(input).append("\r\n");

            System.out.print(newString);
            stdOut.write(newString.toString());

            input = stdIn.readLine();
        }
    }
}
