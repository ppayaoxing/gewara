/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package eu.bitwalker.useragentutils;

public class Utils {
	static String[] toLowerCase(String[] strArr) {
		if (strArr == null) {
			return null;
		} else {
			String[] res = new String[strArr.length];

			for (int i = 0; i < strArr.length; ++i) {
				res[i] = strArr[i].toLowerCase();
			}

			return res;
		}
	}

	static boolean contains(String str, String[] strArr) {
		if (strArr == null) {
			return false;
		} else {
			String[] arg1 = strArr;
			int arg2 = strArr.length;

			for (int arg3 = 0; arg3 < arg2; ++arg3) {
				String arrStr = arg1[arg3];
				if (str.contains(arrStr)) {
					return true;
				}
			}

			return false;
		}
	}
}