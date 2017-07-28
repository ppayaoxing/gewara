/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.impl;

import com.gewara.untrans.CacheService;
import com.gewara.untrans.LockOpService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("lockOpService")
public class LockOpServiceImpl implements LockOpService {
	@Autowired(required = false)
	@Qualifier("cacheService")
	private CacheService cacheService;

	public Long updateOperation(String opkey, int allowIntervalSecond) {
		Long value = (Long) this.cacheService.get("oneHour", opkey);
		if (value != null && value.longValue() > System.currentTimeMillis()) {
			return null;
		} else {
			Long v = Long.valueOf(System.currentTimeMillis() + (long) (allowIntervalSecond * 1000));
			this.cacheService.set("oneHour", opkey, v);
			value = (Long) this.cacheService.get("oneHour", opkey);
			return v.equals(value) ? v : null;
		}
	}

	public Long updateFlagOperation(String opkey, int allowIntervalSecond, String flag) {
		String pair = (String) this.cacheService.get("oneHour", opkey);
		Long value1;
		if (pair == null) {
			Long values1 = Long.valueOf(System.currentTimeMillis() + (long) (allowIntervalSecond * 1000));
			value1 = Long.valueOf(System.currentTimeMillis() + (long) (allowIntervalSecond * 1000));
			pair = values1 + "," + value1 + "," + flag;
			this.cacheService.set("oneHour", opkey, pair);
			return value1;
		} else {
			String[] values = StringUtils.split(pair, ",");
			value1 = Long.valueOf(values[0]);
			Long value2 = Long.valueOf(values[1]);
			return value1 != null && value1.longValue() > System.currentTimeMillis()
					? (StringUtils.equals(values[2], flag)
							? (value2 != null && value2.longValue() > System.currentTimeMillis() ? null : value2)
							: null)
					: value2;
		}
	}

	public void resetFlagOperation(String opkey, String flag) {
		String pair = (String) this.cacheService.get("oneHour", opkey);
		if (pair != null) {
			String[] values = StringUtils.split(pair, ",");
			if (StringUtils.equals(values[2], flag)) {
				String pair2 = values[0] + ",0," + flag;
				this.cacheService.set("oneHour", opkey, pair2);
			}
		}

	}

	public void resetOperation(String opkey, Long locknum) {
		if (locknum != null) {
			Long value = (Long) this.cacheService.get("oneHour", opkey);
			if (value != null && value.equals(locknum)) {
				this.cacheService.remove("oneHour", opkey);
			}
		}

	}
}