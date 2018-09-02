package com.owen.utils.string;

import org.apache.commons.lang.StringUtils;

import java.util.Enumeration;
import java.util.Properties;

public class StringUtil
{
    public static final String STRING_NORMALIZER = "${NORMALIZER}";

    public static String normalize(String string, Properties props)
    {
        assert StringUtils.isNotBlank(string) && props != null;


        return null;
    }

    private static String getToken(String string)
    {
        assert StringUtils.isNotBlank(string);

//        String replacedStr = string.replace(STRING_NORMALIZER, )
//        string.indexOf("$")
        return null;
    }
}
