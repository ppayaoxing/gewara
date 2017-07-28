/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.impl;

public class CountMonitorEntry {
	private String key;
	private long amount;
	private long time = System.currentTimeMillis();
	private long count;
	private boolean countMin;
	private boolean countHour;
	private boolean countDay;

	public CountMonitorEntry(String key, long amount, long count, boolean countMin, boolean countHour,
			boolean countDay) {
		this.countMin = countMin;
		this.countHour = countHour;
		this.countDay = countDay;
		this.amount = amount;
		this.count = count;
		this.key = key;
	}

	public long getAmount() {
		return this.amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getTime() {
		return this.time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public boolean isCountMin() {
		return this.countMin;
	}

	public void setCountMin(boolean countMin) {
		this.countMin = countMin;
	}

	public boolean isCountHour() {
		return this.countHour;
	}

	public void setCountHour(boolean countHour) {
		this.countHour = countHour;
	}

	public boolean isCountDay() {
		return this.countDay;
	}

	public void setCountDay(boolean countDay) {
		this.countDay = countDay;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public long getCount() {
		return this.count;
	}

	public void setCount(long count) {
		this.count = count;
	}
}