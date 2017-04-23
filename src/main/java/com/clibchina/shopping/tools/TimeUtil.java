package com.clibchina.shopping.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtil {
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String getyyyyMMdd(long second){
        long millionTime = second * 1000;
        Date date = new Date(millionTime);

        return dateFormat.format(date);
    }

    public static int getNow() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static int getNextDayZero() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.add(Calendar.DATE, 1);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    public static int getFirstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return (int) (calendar.getTimeInMillis() / 1000);
    }

    public static int getWeekRangeBegin() {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        return (int) (c.getTimeInMillis() / 1000);
    }

    public static int getWeekRangeEnd() {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 7);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return (int) (c.getTimeInMillis() / 1000);
    }

    // 获得昨天0点时间
    public static long getYesterday0() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(getToday0().getTime() - 3600 * 24 * 1000);
        return cal.getTimeInMillis()/1000;
    }

    // 获得昨天0点时间
    public static long getYesterday24() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(getToday0().getTime() - 1 * 1000);
        return cal.getTimeInMillis()/1000;
    }

    // 获得当天24点时间
    public static Date getToday24() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getToday0() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }


    public static String getToday() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String result = simpleDateFormat.format(date);
        return result;
    }

    public static long getLastMonthCurrentTime(){
        Calendar calendar = new GregorianCalendar();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        calendar.add(Calendar.MONTH, -1);

        return calendar.getTimeInMillis()/1000;
    }

    public static long getIntervalDayCurrentTime(int intervalDays){
        Calendar calendar = new GregorianCalendar();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        calendar.add(Calendar.DAY_OF_MONTH, intervalDays);

        return calendar.getTimeInMillis()/1000;
    }

    public static int getCurrentHour(){
        Calendar calendar = new GregorianCalendar();
        Date trialTime = new Date();
        calendar.setTime(trialTime);

        return calendar.get(Calendar.HOUR_OF_DAY);
    }
}
