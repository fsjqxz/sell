package org.fsj.demo.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class DateUtil {
    public static final String STRING_FORMAT = "yyyy-mm-dd  hh:mm:ss";
    public  static Date strToDate(String dateTimesStr, String formatStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimesStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date,String formatStr){
        if (date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return  dateTime.toString(formatStr);

    }

    public static void main(String[] args) {
        System.out.println(DateUtil.dateToStr(new Date(),"yyyy-mm-dd  hh:mm:ss"));
        System.out.println(DateUtil.strToDate("2010-01-01  11:11:11","yyyy-mm-dd  hh:mm:ss"));
    }

    public  static Date strToDate(String dateTimesStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STRING_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimesStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date){
        if (date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return  dateTime.toString(STRING_FORMAT);

    }
}
