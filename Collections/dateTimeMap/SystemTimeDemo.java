package dateTimeMap;
import java.util.*;
public class SystemTimeDemo {
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		
		System.out.println("----以下顯示未來時間----");
		long future = now + 2*365*24*60*60*1000L;
		Date d = new Date(future);
		// 呼叫displayTime(Date)版本
		displayTime(d); 
		
		System.out.println("----以下顯示現在時間----");
		// 呼叫displayTime(long)版本
		displayTime(now); 
		System.out.println("----以下顯示紐約現在時間----");
		TimeZone tz = TimeZone.getTimeZone("America/New_York");
		
		System.out.println("----以下顯示格林威治現在時間----");
		tz = TimeZone.getTimeZone("GMT");
//		 呼叫displayTime(long,TimeZone)版本
		displayTime(now, tz); 
		
	}

	public static void displayTime(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		System.out.print(" 年=" + cal.get(Calendar.YEAR));
		System.out.print(" 月(0-based)=" + cal.get(Calendar.MONTH));
		System.out.print(" 日=" + cal.get(Calendar.DAY_OF_MONTH));
		System.out.print(" 時=" + cal.get(Calendar.HOUR_OF_DAY));
		System.out.print(" 分=" + cal.get(Calendar.MINUTE));
		System.out.print(" 秒=" + cal.get(Calendar.SECOND));
		System.out.print(" 豪秒=" + cal.get(Calendar.MILLISECOND));
		System.out.println();
	}
	public static void displayTime(long t) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(t);
		System.out.print(" 年=" + cal.get(Calendar.YEAR));
		System.out.print(" 月(0-based)=" + cal.get(Calendar.MONTH));
		System.out.print(" 日=" + cal.get(Calendar.DAY_OF_MONTH));
		System.out.print(" 時=" + cal.get(Calendar.HOUR_OF_DAY));
		System.out.print(" 分=" + cal.get(Calendar.MINUTE));
		System.out.print(" 秒=" + cal.get(Calendar.SECOND));
		System.out.print(" 豪秒=" + cal.get(Calendar.MILLISECOND));
		System.out.println();
	}
	public static void displayTime(long t, TimeZone tz) {
		Calendar cal = Calendar.getInstance(tz);
		cal.setTimeInMillis(t);
		System.out.print(" 年=" + cal.get(Calendar.YEAR));
		System.out.print(" 月(0-based)=" + cal.get(Calendar.MONTH));
		System.out.print(" 日=" + cal.get(Calendar.DAY_OF_MONTH));
		System.out.print(" 時=" + cal.get(Calendar.HOUR_OF_DAY));
		System.out.print(" 分=" + cal.get(Calendar.MINUTE));
		System.out.print(" 秒=" + cal.get(Calendar.SECOND));
		System.out.print(" 豪秒=" + cal.get(Calendar.MILLISECOND));
		System.out.println();
	}
}
