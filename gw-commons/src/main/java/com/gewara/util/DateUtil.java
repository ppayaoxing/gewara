/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.Util4Script;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;

public class DateUtil implements Util4Script {
	public static final DateUtil instance = new DateUtil();
	public static final long m_second = 1000L;
	public static final long m_minute = 60000L;
	public static final long m_hour = 3600000L;
	public static final long m_day = 86400000L;
	private static int[] chweek = new int[] { 0, 7, 1, 2, 3, 4, 5, 6 };
	private static String[] cnweek = new String[] { "", "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
	private static String[] cnSimpleweek = new String[] { "", "日", "一", "二", "三", "四", "五", "六" };

	public static final long timeMillis() {
		return System.currentTimeMillis();
	}

	public static final String currentDateStr() {
		return formatDate(currentTime());
	}

	public static final Date currentTime() {
		return new Date();
	}

	public static final String getCurFullTimestampStr() {
		return formatTimestamp((Date) getCurFullTimestamp());
	}

	public static final Timestamp getCurFullTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static final int nextMonth() {
		String next = format(new Date(), "M");
		int nextMonth = Integer.parseInt(next) + 1;
		return nextMonth == 13 ? 1 : nextMonth;
	}

	public static final Date parseDate(String strDate) {
		Date date = null;

		try {
			SimpleDateFormat pe = new SimpleDateFormat("yyyy-MM-dd");
			date = pe.parse(strDate);
			return date;
		} catch (Exception arg2) {
			return null;
		}
	}

	public static int getWeekOfYear(Timestamp time) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getDateFromTimestamp(time));
		int week = cal.get(3);
		return week;
	}

	public static int getCnWeekOfYear(Timestamp time) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getDateFromTimestamp(time));
		cal.setFirstDayOfWeek(2);
		int week = cal.get(3);
		return week;
	}

	public static final Timestamp parseTimestamp(String strDate) {
		try {
			Timestamp pe = Timestamp.valueOf(strDate);
			return pe;
		} catch (Exception arg1) {
			return null;
		}
	}

	public static final Timestamp parseTimestamp(String strDate, String pattern) {
		Date date = null;

		try {
			SimpleDateFormat pe = new SimpleDateFormat(pattern);
			date = pe.parse(strDate);
			return new Timestamp(date.getTime());
		} catch (Exception arg3) {
			return null;
		}
	}

	public static final Date parseDate(String strDate, String pattern) {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(pattern);

		try {
			date = df.parse(strDate);
			return date;
		} catch (Exception arg4) {
			return null;
		}
	}

	public static final <T extends Date> String formatDate(T date) {
		if (date == null) {
			return null;
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormat.format(date);
		}
	}

	public static final <T extends Date> String formatTime(T date) {
		if (date == null) {
			return null;
		} else {
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			return timeFormat.format(date);
		}
	}

	public static final <T extends Date> String formatTimestamp(T date) {
		if (date == null) {
			return null;
		} else {
			SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return timestampFormat.format(date);
		}
	}

	public static final String formatTimestamp(Long mills) {
		return formatTimestamp(new Date(mills.longValue()));
	}

	public static final <T extends Date> String format(T date, String pattern) {
		if (date == null) {
			return null;
		} else {
			try {
				SimpleDateFormat e = new SimpleDateFormat(pattern);
				String result = e.format(date);
				return result;
			} catch (Exception arg3) {
				return null;
			}
		}
	}

	public static final <T extends Date> T addTime(T original, int days, int hours, int minutes, int seconds) {
		if (original == null) {
			return null;
		} else {
			long newTime = original.getTime() + 86400000L * (long) days + 3600000L * (long) hours
					+ 60000L * (long) minutes + 1000L * (long) seconds;
			Date another = (Date) original.clone();
			another.setTime(newTime);
			return another;
		}
	}

	public static final <T extends Date> T addDay(T original, int days) {
		if (original == null) {
			return null;
		} else {
			long newTime = original.getTime() + 86400000L * (long) days;
			Date another = (Date) original.clone();
			another.setTime(newTime);
			return another;
		}
	}

	public static final <T extends Date> T addHour(T original, int hours) {
		if (original == null) {
			return null;
		} else {
			long newTime = original.getTime() + 3600000L * (long) hours;
			Date another = (Date) original.clone();
			another.setTime(newTime);
			return another;
		}
	}

	public static final <T extends Date> T addMinute(T original, int minutes) {
		if (original == null) {
			return null;
		} else {
			long newTime = original.getTime() + 60000L * (long) minutes;
			Date another = (Date) original.clone();
			another.setTime(newTime);
			return another;
		}
	}

	public static final <T extends Date> T addSecond(T original, int second) {
		if (original == null) {
			return null;
		} else {
			long newTime = original.getTime() + 1000L * (long) second;
			Date another = (Date) original.clone();
			another.setTime(newTime);
			return another;
		}
	}

	public static final <T extends Date> T getBeginningTimeOfDay(T day) {
		if (day == null) {
			return null;
		} else {
			String strDate = formatDate(day);
			Long mill = Long.valueOf(parseDate(strDate).getTime());
			Date another = (Date) day.clone();
			another.setTime(mill.longValue());
			return another;
		}
	}

	public static final <T extends Date> T getLastTimeOfDay(T day) {
		if (day == null) {
			return null;
		} else {
			Long mill = Long.valueOf(getBeginningTimeOfDay(day).getTime() + 86400000L - 1L);
			Date another = (Date) day.clone();
			another.setTime(mill.longValue());
			return another;
		}
	}

	public static final String formatTime(String time) {
		if (time == null) {
			return null;
		} else {
			time = StringUtils.trim(time);
			if (StringUtils.isBlank(time)) {
				throw new IllegalArgumentException("时间格式有错误！");
			} else {
				time = time.replace('：', ':');
				String[] times = time.split(":");
				String result = "";
				if (times[0].length() < 2) {
					result = result + "0" + times[0] + ":";
				} else {
					result = result + times[0] + ":";
				}

				if (times.length > 1) {
					if (times[1].length() < 2) {
						result = result + "0" + times[1];
					} else {
						result = result + times[1];
					}
				} else {
					result = result + "00";
				}

				Timestamp.valueOf("2001-01-01 " + result + ":00");
				return result;
			}
		}
	}

	public static boolean isTomorrow(Date date) {
		return date == null ? false : formatDate(addTime(new Date(), 1, 0, 0, 0)).equals(formatDate(date));
	}

	public static Integer getWeek(Date date) {
		if (date == null) {
			return null;
		} else {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			return Integer.valueOf(chweek[c.get(7)]);
		}
	}

	public static Date getCurDateByWeek(Integer week) {
		if (week != null && week.intValue() >= 0 && week.intValue() <= 7) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(7, week.intValue());
			return calendar.getTime();
		} else {
			return currentTime();
		}
	}

	public static String getCnWeek(Date date) {
		if (date == null) {
			return null;
		} else {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			return cnweek[c.get(7)];
		}
	}

	public static String getCnSimpleWeek(Date date) {
		if (date == null) {
			return null;
		} else {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			return cnSimpleweek[c.get(7)];
		}
	}

	public static Integer getCurrentDay() {
		return getDay(new Date());
	}

	public static Integer getCurrentMonth() {
		return getMonth(new Date());
	}

	public static Integer getCurrentYear() {
		return getYear(new Date());
	}

	public static Integer getYear(Date date) {
		if (date == null) {
			return null;
		} else {
			String year = format(date, "yyyy");
			return Integer.valueOf(Integer.parseInt(year));
		}
	}

	public static Integer getDay(Date date) {
		if (date == null) {
			return null;
		} else {
			String year = format(date, "d");
			return Integer.valueOf(Integer.parseInt(year));
		}
	}

	public static Integer getMonth(Date date) {
		if (date == null) {
			return null;
		} else {
			String month = format(date, "M");
			return Integer.valueOf(Integer.parseInt(month));
		}
	}

	public static Integer getCurrentHour(Date date) {
		if (date == null) {
			return null;
		} else {
			String hour = format(date, "H");
			return Integer.valueOf(Integer.parseInt(hour));
		}
	}

	public static Integer getCurrentMin(Date date) {
		if (date == null) {
			return null;
		} else {
			String hour = format(date, "m");
			return Integer.valueOf(Integer.parseInt(hour));
		}
	}

	public static String getCurDateStr() {
		return formatDate(new Date());
	}

	public static String getCurTimeStr() {
		return formatTimestamp(new Date());
	}

	public static boolean isAfter(Date date) {
		return date == null ? false : date.after(new Date());
	}

	public static List<Date> getWeekDateList(Date date, String weektype) {
		int curMonth = getMonth(date).intValue();
		int week = Integer.parseInt(weektype);
		int curWeek = getWeek(date).intValue();
		int sub = (7 + week - curWeek) % 7;
		Date next = addDay(date, sub);

		ArrayList result;
		for (result = new ArrayList(); getMonth(next).intValue() == curMonth; next = addDay(next, 7)) {
			result.add(next);
		}

		return result;
	}

	public static List<Date> getWeekDateList(Date date, String weektype, int num) {
		int week = Integer.parseInt(weektype);
		int curWeek = getWeek(date).intValue();
		ArrayList result = new ArrayList();
		int sub = (7 + week - curWeek) % 7;
		Date next = addDay(date, sub);

		for (int i = 0; i < num; ++i) {
			result.add(next);
			next = addDay(next, 7);
		}

		return result;
	}

	public static List<Date> getCurWeekDateList(Date date) {
		int curWeek = getWeek(date).intValue();
		ArrayList dateList = new ArrayList();

		for (int i = 1; i <= 7; ++i) {
			dateList.add(addDay(date, -curWeek + i));
		}

		return dateList;
	}

	public static Date getWeekLastDay(Date date) {
		int curWeek = getWeek(date).intValue();
		return addDay(date, 7 - curWeek);
	}

	public static Date getCurDate() {
		return getBeginningTimeOfDay(new Date());
	}

	public static <T extends Date> T getMonthFirstDay(T date) {
		if (date == null) {
			return null;
		} else {
			String dateStr = format(date, "yyyy-MM") + "-01";
			Long mill = Long.valueOf(parseDate(dateStr).getTime());
			Date another = (Date) date.clone();
			another.setTime(mill.longValue());
			return another;
		}
	}

	public static <T extends Date> T getNextMonthFirstDay(T day) {
		if (day == null) {
			return null;
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(day);
			int month = calendar.get(2);
			calendar.set(2, month + 1);
			calendar.set(5, 1);
			String datefor = format(calendar.getTime(), "yyyy-MM-dd");
			Long mill = Long.valueOf(parseDate(datefor).getTime());
			Date another = (Date) day.clone();
			another.setTime(mill.longValue());
			return another;
		}
	}

	public static <T extends Date> T getMonthLastDay(T date) {
		if (date == null) {
			return null;
		} else {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			String dateStr = format(date, "yyyy-MM") + "-" + c.getActualMaximum(5);
			Long mill = Long.valueOf(parseDate(dateStr).getTime());
			Date another = (Date) date.clone();
			another.setTime(mill.longValue());
			return another;
		}
	}

	public static String formatDate(int days) {
		return formatDate(addDay(new Date(), days));
	}

	public static Timestamp getCurTruncTimestamp() {
		return (Timestamp) getBeginningTimeOfDay(new Timestamp(System.currentTimeMillis()));
	}

	public static Integer getHour(Date date) {
		if (date == null) {
			return null;
		} else {
			String hour = format(date, "H");
			return Integer.valueOf(Integer.parseInt(hour));
		}
	}

	public static Integer getMinute(Date date) {
		if (date == null) {
			return null;
		} else {
			String m = format(date, "m");
			return Integer.valueOf(Integer.parseInt(m));
		}
	}

	public static String getTimeDesc(Timestamp time) {
		if (time == null) {
			return "";
		} else {
			Long ss = Long.valueOf(System.currentTimeMillis() - time.getTime());
			Long minute = Long.valueOf(ss.longValue() / 60000L);
			String timeContent;
			Long hour;
			if (minute.longValue() < 1L) {
				hour = Long.valueOf(ss.longValue() / 1000L);
				timeContent = hour + "秒前";
			} else if (minute.longValue() >= 60L) {
				hour = Long.valueOf(minute.longValue() / 60L);
				if (hour.longValue() >= 24L) {
					if (hour.longValue() > 720L) {
						timeContent = "1月前";
					} else if (hour.longValue() > 168L && hour.longValue() <= 720L) {
						timeContent = hour.longValue() / 168L + "周前";
					} else {
						timeContent = hour.longValue() / 24L + "天前";
					}
				} else {
					timeContent = hour + "小时前";
				}
			} else {
				timeContent = minute + "分钟前";
			}

			return timeContent;
		}
	}

	public static String getDateDesc(Date time) {
		if (time == null) {
			return "";
		} else {
			Long ss = Long.valueOf(System.currentTimeMillis() - time.getTime());
			Long minute = Long.valueOf(ss.longValue() / 60000L);
			String timeContent;
			Long hour;
			if (minute.longValue() < 1L) {
				hour = Long.valueOf(ss.longValue() / 1000L);
				timeContent = hour + "秒前";
			} else if (minute.longValue() >= 60L) {
				hour = Long.valueOf(minute.longValue() / 60L);
				if (hour.longValue() >= 24L) {
					if (hour.longValue() > 720L) {
						timeContent = "1月前";
					} else if (hour.longValue() > 168L && hour.longValue() <= 720L) {
						timeContent = hour.longValue() / 168L + "周前";
					} else {
						timeContent = hour.longValue() / 24L + "天前";
					}
				} else {
					timeContent = hour + "小时前";
				}
			} else {
				timeContent = minute + "分钟前";
			}

			return timeContent;
		}
	}

	public static String getMonthAndDay(Date date) {
		return formatDate(date).substring(5);
	}

	public static Date getMillDate() {
		return new Date();
	}

	public static Timestamp getMillTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static final <T extends Date> String getDiffDayStr(T day1, T day2) {
		if (day1 != null && day2 != null) {
			long diff = day1.getTime() - day2.getTime();
			long sign = diff / Math.abs(diff);
			if (sign < 0L) {
				return "已经过期";
			} else {
				diff = Math.abs(diff) / 1000L;
				long day = diff / 3600L / 24L;
				long hour = (diff - day * 3600L * 24L) / 3600L;
				long minu = diff % 3600L / 60L;
				return (day == 0L ? "" : day + "天") + (hour == 0L ? "" : hour + "小时") + (minu == 0L ? "" : minu + "分");
			}
		} else {
			return "---";
		}
	}

	public static final <T extends Date> String getDiffStr(T day1, T day2) {
		if (day1 != null && day2 != null) {
			long diff = day1.getTime() - day2.getTime();
			long sign = diff / Math.abs(diff);
			diff = Math.abs(diff) / 1000L;
			long hour = diff / 3600L;
			long minu = diff % 3600L / 60L;
			long second = diff % 60L;
			return (sign < 0L ? "-" : "+") + (hour == 0L ? "" : hour + "小时") + (minu == 0L ? "" : minu + "分")
					+ (second == 0L ? "" : second + "秒");
		} else {
			return "---";
		}
	}

	public static final <T extends Date> long getDiffSecond(T day1, T day2) {
		if (day1 != null && day2 != null) {
			long diff = day1.getTime() - day2.getTime();
			if (diff == 0L) {
				return 0L;
			} else {
				long sign = diff / Math.abs(diff);
				diff = Math.abs(diff) / 1000L;
				return sign * diff;
			}
		} else {
			return 0L;
		}
	}

	public static final <T extends Date> double getDiffMinu(T day1, T day2) {
		if (day1 != null && day2 != null) {
			long diff = day1.getTime() - day2.getTime();
			if (diff == 0L) {
				return 0.0D;
			} else {
				long sign = diff / Math.abs(diff);
				diff = Math.abs(diff) / 1000L;
				return (double) Math.round((double) diff * 1.0D * 10.0D / 6.0D) / 100.0D * (double) sign;
			}
		} else {
			return 0.0D;
		}
	}

	public static final double getMillDiffMinu(long time1, long time2) {
		long diff = time1 - time2;
		if (diff == 0L) {
			return 0.0D;
		} else {
			long sign = diff / Math.abs(diff);
			diff = Math.abs(diff) / 1000L;
			return (double) Math.round((double) diff * 1.0D * 10.0D / 6.0D) / 100.0D * (double) sign;
		}
	}

	public static final <T extends Date> double getDiffHour(T day1, T day2) {
		if (day1 != null && day2 != null) {
			long diff = day1.getTime() - day2.getTime();
			long sign = diff / Math.abs(diff);
			diff = Math.abs(diff) / 1000L;
			return (double) Math.round((double) diff * 1.0D / 3.6D) / 1000.0D * (double) sign;
		} else {
			return 0.0D;
		}
	}

	public static final <T extends Date> int getDiffDay(T day1, T day2) {
		if (day1 != null && day2 != null) {
			long diff = day1.getTime() - day2.getTime();
			diff = Math.abs(diff) / 1000L;
			return Math.round((float) (diff / 86400L));
		} else {
			return 0;
		}
	}

	public static boolean isAfterOneHour(Date date, String time) {
		String datetime = formatDate(date) + " " + time + ":00";
		return ((Timestamp) addHour(parseTimestamp(datetime), -1)).after(getMillTimestamp());
	}

	public static boolean isValidDate(String fyrq) {
		return parseDate(fyrq) != null;
	}

	public static <T extends Date> long getCurDateMills(T date) {
		return date == null ? 0L : date.getTime();
	}

	public static Timestamp getBeginTimestamp(Date date) {
		return new Timestamp(getBeginningTimeOfDay(date).getTime());
	}

	public static Timestamp getEndTimestamp(Date date) {
		return new Timestamp(getLastTimeOfDay(date).getTime());
	}

	public static Date getDateFromTimestamp(Timestamp timestamp) {
		return timestamp == null ? null : new Date(timestamp.getTime());
	}

	public static int after(Date date1, Date date2) {
		date1 = getBeginningTimeOfDay(date1);
		date2 = getBeginningTimeOfDay(date2);
		return date1.compareTo(date2);
	}

	public static Timestamp mill2Timestamp(Long mill) {
		return mill == null ? null : new Timestamp(mill.longValue());
	}

	public static int subCurTimeSend() {
		Timestamp curtime = getCurFullTimestamp();
		Timestamp endtime = (Timestamp) getLastTimeOfDay(curtime);
		Long scopeSecond = Long.valueOf(getDiffSecond(endtime, curtime));
		return scopeSecond.intValue();
	}

	public static final <T extends Date> String formatEn(T date, String pattern) {
		if (date == null) {
			return null;
		} else {
			try {
				SimpleDateFormat e = new SimpleDateFormat(pattern, Locale.ENGLISH);
				String result = e.format(date);
				return result;
			} catch (Exception arg3) {
				return null;
			}
		}
	}

	public static String getCurrAddHour(int hour) {
		return formatTimestamp(Long.valueOf(System.currentTimeMillis() + 3600000L * (long) hour));
	}

	public static String getCurrAddDay(int day) {
		return formatTimestamp(Long.valueOf(System.currentTimeMillis() + 86400000L * (long) day));
	}
}