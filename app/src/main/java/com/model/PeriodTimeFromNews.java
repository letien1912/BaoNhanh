package com.model;

import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Le on 19-Jan-16.
 */
public class PeriodTimeFromNews {



    public static String createDay(String dayInput) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);    // TODO Auto-generated constructor stub
        String currentTime = null;
        Date date;
        try {
            date = sdf.parse(dayInput);
            new SimpleDateFormat("HH:mm").format(date);
            java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
            java.sql.Timestamp timeStampNow = new Timestamp((new java.util.Date()).getTime());

            long secondDiff = timeStampNow.getTime() / 1000 - timeStampDate.getTime() / 1000;
            int minuteDiff = (int) (secondDiff / 60);
            int hourDiff = minuteDiff / 60;
            int dayDiff =  hourDiff / 24;
            int monthDiff =  dayDiff / 30;
            int yearDiff =  monthDiff / 12;

            if(yearDiff > 0) currentTime = yearDiff + "Năm  trước";
            else if(monthDiff > 0) currentTime = monthDiff + " Tháng trước";
            else if(dayDiff > 0) currentTime = dayDiff + " Ngày trước";
            else if(hourDiff > 0) currentTime = hourDiff + " Giờ trước";
            else if(minuteDiff > 0) currentTime = minuteDiff + " Phút trước";
            else if(secondDiff > 0) currentTime = secondDiff + " Giây trước";

            return currentTime;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return " ";
    }
}
