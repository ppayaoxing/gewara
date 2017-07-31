package com.gewara.untrans.monitor.impl;



public class CountMonitorEntry {
	private String key;
	private long amount;
	private long time;
	private long count;
	private boolean countMin;
	private boolean countHour;
	private boolean countDay;
	public CountMonitorEntry(String key, long amount, long count, boolean countMin, boolean countHour, boolean countDay){
		this.time = System.currentTimeMillis();
		this.countMin = countMin;
		this.countHour = countHour;
		this.countDay = countDay;
		this.amount = amount;
		this.count = count;
		this.key = key;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public boolean isCountMin() {
		return countMin;
	}
	public void setCountMin(boolean countMin) {
		this.countMin = countMin;
	}
	public boolean isCountHour() {
		return countHour;
	}
	public void setCountHour(boolean countHour) {
		this.countHour = countHour;
	}
	public boolean isCountDay() {
		return countDay;
	}
	public void setCountDay(boolean countDay) {
		this.countDay = countDay;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
}
