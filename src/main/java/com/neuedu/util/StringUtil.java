package com.neuedu.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// String utility
public class StringUtil {

    public static String convertDateTime (Date date) {

//        get current time
        Date now = new Date();
//        compute span
        long timeSpan = (now.getTime() - date.getTime()) / 1000;

        if (timeSpan < 60) {
            return "刚刚发布";
        }else if (timeSpan < 60 * 60) {
            return timeSpan / 60 + "分钟前发布";
        }else if (timeSpan < 60 * 60 * 3) {
            return timeSpan / 60 / 60 + "小时前发布";
        }else {
//            get current day
            Calendar calendar = Calendar.getInstance();

//            get current data
            Integer year = calendar.get(Calendar.YEAR);
            Integer month = calendar.get(Calendar.MONTH);
            Integer day = calendar.get(Calendar.DAY_OF_MONTH);

//            set current day's begin
            calendar.set(year, month, day, 0, 0, 0);

//            convert to Date type
            Date today = calendar.getTime();

//            compare parameter date whether later than today
            if (date.after(today)) {
                DateFormat df = new SimpleDateFormat("MM时dd分");
                return "今天" + df.format(date) + "发布";
            }else {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                return df.format(date);
            }
        }

    }

}
