/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.collections.map.UnmodifiableMap;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

public class IPUtil {
	public static final IPUtil.IpData ipData = new IPUtil.IpData();
	private static Map<String, String> provinceMap;
	private static Map<String, Map<String, String>> proCityMap;
	private static Map<String, String> cityMap = new HashMap();
	private static Map<String, String> city2Pro = new HashMap();
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(IPUtil.class);
	private static AtomicBoolean init = new AtomicBoolean(false);

	public static String[] findProAndCityByIp(String ip) {
		if (StringUtils.equals("::1", ip)) {
			ip = "127.0.0.1";
		}

		try {
			String e = getAddress(ip);
			if (StringUtils.isNotBlank(e)) {
				Iterator arg1 = provinceMap.entrySet().iterator();

				while (arg1.hasNext()) {
					Entry pro = (Entry) arg1.next();
					if (StringUtils.contains(e, (String) pro.getValue())) {
						Map city = (Map) proCityMap.get(pro.getKey());
						Iterator arg4 = city.entrySet().iterator();

						Entry gewaCity;
						do {
							if (!arg4.hasNext()) {
								return new String[] { (String) pro.getKey(), "", "" };
							}

							gewaCity = (Entry) arg4.next();
						} while (!StringUtils.contains(e, (String) gewaCity.getValue()));

						return new String[] { (String) pro.getKey(), (String) gewaCity.getKey(),
								(String) gewaCity.getValue() };
					}
				}
			}
		} catch (Exception arg6) {
			dbLogger.error("获取城市代码错误", arg6);
		}

		return new String[] { "", "", "" };
	}

	public static String getCitynameByCode(String citycode) {
		return (String) cityMap.get(citycode);
	}

	private static void init() {
		if (!init.get()) {
			boolean first = init.compareAndSet(false, true);
			if (first) {
				BufferedReader e;
				Throwable arg1;
				List cityList;
				try {
					e = new BufferedReader(new InputStreamReader(
							IPUtil.class.getClassLoader().getResourceAsStream("ipdata.txt"), "utf-8"));
					arg1 = null;

					try {
						cityList = IOUtils.readLines(e);
						init(cityList);
					} catch (Throwable arg56) {
						arg1 = arg56;
						throw arg56;
					} finally {
						if (e != null) {
							if (arg1 != null) {
								try {
									e.close();
								} catch (Throwable arg54) {
									arg1.addSuppressed(arg54);
								}
							} else {
								e.close();
							}
						}

					}
				} catch (Exception arg58) {
					throw new IllegalArgumentException("IPData ERROR!!!", arg58);
				}

				HashMap cmap;
				Iterator arg4;
				String city;
				String[] pair;
				try {
					e = new BufferedReader(new InputStreamReader(
							IPUtil.class.getClassLoader().getResourceAsStream("province.txt"), "utf-8"));
					arg1 = null;

					try {
						cityList = IOUtils.readLines(e);
						cmap = new HashMap();
						arg4 = cityList.iterator();

						while (true) {
							if (!arg4.hasNext()) {
								provinceMap = UnmodifiableMap.decorate(cmap);
								break;
							}

							city = (String) arg4.next();
							pair = StringUtils.split(city, "\t");
							if (pair.length == 2) {
								cmap.put(StringUtils.trim(pair[0]), StringUtils.trim(pair[1]));
							}
						}
					} catch (Throwable arg62) {
						arg1 = arg62;
						throw arg62;
					} finally {
						if (e != null) {
							if (arg1 != null) {
								try {
									e.close();
								} catch (Throwable arg53) {
									arg1.addSuppressed(arg53);
								}
							} else {
								e.close();
							}
						}

					}
				} catch (Exception arg64) {
					throw new IllegalArgumentException("Province data ERROR!!!", arg64);
				}

				try {
					e = new BufferedReader(new InputStreamReader(
							IPUtil.class.getClassLoader().getResourceAsStream("city.txt"), "utf-8"));
					arg1 = null;

					try {
						cityList = IOUtils.readLines(e);
						cmap = new HashMap();
						arg4 = cityList.iterator();

						while (arg4.hasNext()) {
							city = (String) arg4.next();
							pair = StringUtils.split(city, "\t");
							if (pair.length == 3) {
								Object row = (Map) cmap.get(pair[0]);
								if (row == null) {
									row = new HashMap();
									cmap.put(pair[0], row);
								}

								((Map) row).put(pair[1], pair[2]);
								cityMap.put(pair[1], pair[2]);
								city2Pro.put(pair[1], pair[0]);
							}
						}

						proCityMap = UnmodifiableMap.decorate(cmap);
					} catch (Throwable arg59) {
						arg1 = arg59;
						throw arg59;
					} finally {
						if (e != null) {
							if (arg1 != null) {
								try {
									e.close();
								} catch (Throwable arg55) {
									arg1.addSuppressed(arg55);
								}
							} else {
								e.close();
							}
						}

					}

				} catch (Exception arg61) {
					throw new IllegalArgumentException("Province data ERROR!!!", arg61);
				}
			}
		}
	}

	private static void init(List<String> lines) {
		ipData.ipList = new long[lines.size() + 4];
		int i = 2;
		int success = 0;
		int error = 0;
		Iterator arg5 = lines.iterator();

		while (arg5.hasNext()) {
			String line = (String) arg5.next();

			try {
				String[] e = StringUtils.trim(line).split("[ ]+");
				Long ipn1 = getIpNum(e[0]);
				Long ipn2 = getIpNum(e[1]);
				ipData.ipList[i] = ipn1.longValue();
				++i;
				ipData.pairMap.put(ipn1, ipn2);
				ipData.addressMap.put(ipn1, e[2] + (e.length > 3 ? "  " + e[3] : ""));
				++success;
			} catch (Exception arg8) {
				++error;
				dbLogger.warn("RowError:" + line + ", LineNo:" + (success + error));
			}
		}

		ipData.ipList[0] = Long.MIN_VALUE;
		ipData.ipList[1] = -9223372036854775807L;
		ipData.ipList[i] = 9223372036854775806L;
		ipData.ipList[i + 1] = Long.MAX_VALUE;
		Arrays.sort(ipData.ipList);
		ipData.ipList[1] = ipData.ipList[2] - 1L;
		ipData.ipList[i] = ((Long) ipData.pairMap.get(Long.valueOf(ipData.ipList[i - 1]))).longValue() + 1L;
		dbLogger.warn("Init IP Data, total count:" + lines.size() + ",success:" + success + ",error:" + error);
	}

	public static String getAddress(String ip) {
		long ipNum = getIpNum(ip).longValue();
		int idx = findNear(ipNum);
		Long ip1 = Long.valueOf(ipData.ipList[idx]);
		Long ip2 = (Long) ipData.pairMap.get(ip1);
		String find = null;
		if (ip1 != null && ip2 != null) {
			if (ipNum >= ip1.longValue() && ipNum <= ip2.longValue()) {
				find = (String) ipData.addressMap.get(ip1);
			}

			return find;
		} else {
			dbLogger.warn("INVALIDIP:" + ip);
			return find;
		}
	}

	private static Long getIpNum(String ip) {
		String[] ip1 = StringUtils.split(StringUtils.trim(ip), ".");
		if (ip1 != null && ip1.length > 3) {
			return Long.valueOf(Long.parseLong(ip1[0]) * 256L * 256L * 256L + Long.parseLong(ip1[1]) * 256L * 256L
					+ Long.parseLong(ip1[2]) * 256L + Long.parseLong(ip1[3]));
		} else {
			dbLogger.warn("INVALIDIP:" + ip);
			return Long.valueOf(0L);
		}
	}

	private static int findNear(long ipNum) {
		int start = 0;
		int end = ipData.ipList.length;
		boolean mid = true;

		while (start != end && start + 1 != end) {
			int mid1 = (start + end) / 2;
			if (ipData.ipList[mid1] == ipNum) {
				return mid1;
			}

			if (ipData.ipList[mid1 + 1] == ipNum) {
				return mid1 + 1;
			}

			if (ipNum > ipData.ipList[mid1] && ipNum < ipData.ipList[mid1 + 1]) {
				return mid1;
			}

			if (ipNum > ipData.ipList[mid1]) {
				start = mid1;
			} else {
				end = mid1;
			}
		}

		return start;
	}

	static {
		init();
	}

	public static class IpData implements Serializable {
		private static final long serialVersionUID = 1L;
		private long[] ipList = new long[0];
		private Map<Long, Long> pairMap = new HashMap();
		private Map<Long, String> addressMap = new HashMap();
	}
}