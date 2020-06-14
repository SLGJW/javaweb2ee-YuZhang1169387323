package com.danger.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具类
 */
public class DateUtil {

    /**
     * 将时间格式转换为字符串格式
     * @param date
     * @param pattern
     * @return
     */
    public static String DateToString(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String format = sdf.format(date);
        return format;
    }

    /**
     * 将字符串格式转换为时间格式
     * @param str
     * @param pattern
     * @return
     * @throws Exception
     */
    public static Date StringToDate(String str, String pattern) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date parse = sdf.parse(str);
        return parse;
    }
}
