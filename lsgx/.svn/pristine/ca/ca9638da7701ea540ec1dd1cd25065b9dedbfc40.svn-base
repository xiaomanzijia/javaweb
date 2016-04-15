package test;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTimeTest
{
    private final static String birthday = "2012-3-10 08:20:55";

    public static void main(String[] args)
    {
        Date d = new Date();
        System.out.println(d.getTime());
        
        DateTime dateTime = DateTime.now();
        System.out.println(dateTime.getDayOfMonth());
        System.out.println(dateTime.getHourOfDay());
        System.out.println(dateTime.dayOfWeek().getAsText());
        System.out.println();
        
        LocalDate f = new LocalDate();
        
        System.out.println(daysToNewYear(f));
        
        DateTimeFormatter format1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter format2 = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime startDateTime = DateTime.parse(birthday, format1);
        System.out.println("宝宝来到这个世界已经");
        calDateToDay(startDateTime, new DateTime());
    }
    
    public static Days daysToNewYear(LocalDate fromDate)
    {
        LocalDate newYear = fromDate.plusYears(1).withDayOfYear(1);
        return Days.daysBetween(fromDate, newYear);
    }
    
    public static void calDateToDay(DateTime startDateTime, DateTime endDateTime)
    {
        
        LocalDate start = new LocalDate(startDateTime);
        LocalDate end = new LocalDate(endDateTime);
        Days days = Days.daysBetween(start, end);
        int intervalDays = days.getDays();
        int intervalHours = endDateTime.getHourOfDay() - startDateTime.getHourOfDay();
        int intervalMinutes = endDateTime.getMinuteOfHour() - startDateTime.getMinuteOfHour();
        int intervalSeconds = endDateTime.getSecondOfMinute() - startDateTime.getSecondOfMinute();
        
        if (intervalSeconds < 0)
        {
            intervalMinutes = intervalMinutes - 1;
            intervalSeconds = 60 + intervalSeconds;
        }
        
        if (intervalMinutes < 0)
        {
            intervalHours = intervalHours - 1;
            intervalMinutes = 60 + intervalMinutes;
        }
        
        if (intervalHours < 0)
        {
            intervalDays = intervalDays - 1;
            intervalHours = 24 + intervalHours;
        }
        
        System.out.println(intervalDays + "天" + intervalHours + "小时" + intervalMinutes + "分钟" + intervalSeconds + "秒");
        System.out.println("############################");
    }

}

