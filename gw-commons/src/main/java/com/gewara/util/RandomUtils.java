/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import java.util.List;
import java.util.Random;

public class RandomUtils {
	public static int randomInt(int n) {
		return n <= 1 ? 0 : (new Random()).nextInt(n);
	}

	public static int randomIntApache(int n) {
		return n <= 1 ? 0 : org.apache.commons.lang.math.RandomUtils.nextInt(n);
	}

	public static <T> T getRandomFromList(List<T> list) {
		return list != null && !list.isEmpty() ? list.get(randomInt(list.size())) : null;
	}

	public static <T> T getRandomFromListApache(List<T> list) {
		return list != null && !list.isEmpty() ? list.get(randomInt(list.size())) : null;
	}
}