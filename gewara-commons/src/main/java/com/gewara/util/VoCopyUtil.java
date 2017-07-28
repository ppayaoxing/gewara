/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.api.vo.BaseVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import com.gewara.dubbo.bytecode.Wrapper;
import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.FastHashMap;
import org.apache.commons.collections.list.UnmodifiableList;
import org.apache.commons.lang.ArrayUtils;

public class VoCopyUtil {
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(VoCopyUtil.class);
	public static Map<String, List<String>> copyPropsMap = new FastHashMap();

	public static <K, V> VoMap<K, V> toVoMap(Map<K, V> map) {
		VoMap result = new VoMap(map.size());
		result.putAll(map);
		return result;
	}

	public static <K, V> List<VoMap<K, V>> toVoMapList(List<Map<K, V>> mapList) {
		ArrayList result = new ArrayList(mapList.size());
		Iterator arg1 = mapList.iterator();

		while (arg1.hasNext()) {
			Map map = (Map) arg1.next();
			result.add(toVoMap(map));
		}

		return result;
	}

	public static <S extends BaseVo, T> ResultCode<List<S>> copyListProperties(Class<S> clazz, List<T> itemList) {
		ArrayList voItemList = new ArrayList();
		if (CollectionUtils.isEmpty(itemList)) {
			return ResultCode.getSuccessReturn(voItemList);
		} else {
			try {
				Iterator e = itemList.iterator();

				while (e.hasNext()) {
					Object item = e.next();
					if (item != null) {
						Class src = item.getClass();
						Wrapper srcWrapper = Wrapper.getWrapper(src);
						Wrapper destWrapper = Wrapper.getWrapper(clazz);
						BaseVo itemVo = (BaseVo) destWrapper.gainNewInstance();
						List props = getJoinProperties(srcWrapper.getReadPropertyNames(), src, clazz);
						copyInternal(itemVo, item, srcWrapper, destWrapper, props);
						voItemList.add(itemVo);
					}
				}
			} catch (Exception arg9) {
				dbLogger.warn(arg9, 10);
			}

			return ResultCode.getSuccessReturn(voItemList);
		}
	}

	public static <S extends BaseVo, T> ResultCode<S> copyProperties(Class<S> clazz, T item) {
		if (item == null) {
			return ResultCode.getFailure("4005", "数据不存在！");
		} else {
			try {
				Wrapper e = Wrapper.getWrapper(item.getClass());
				Wrapper destWrapper = Wrapper.getWrapper(clazz);
				BaseVo itemVo = (BaseVo) destWrapper.gainNewInstance();
				List props = getJoinProperties(e.getReadPropertyNames(), item.getClass(), clazz);
				copyInternal(itemVo, item, e, destWrapper, props);
				return ResultCode.getSuccessReturn(itemVo);
			} catch (Exception arg5) {
				dbLogger.warn(arg5, 10);
				return ResultCode.getFailure("9999", "未知错误！");
			}
		}
	}

	private static List<String> getJoinProperties(String[] srcProps, Class src, Class dest) {
		String key = src.getCanonicalName() + "2" + dest.getCanonicalName();
		Object propList = (List) copyPropsMap.get(key);
		if (propList == null) {
			propList = new ArrayList();
			synchronized (src) {
				String[] arg5 = srcProps;
				int arg6 = srcProps.length;

				for (int arg7 = 0; arg7 < arg6; ++arg7) {
					String name = arg5[arg7];

					try {
						PropertyDescriptor descriptor = new PropertyDescriptor(name, dest);
						if (PropertyUtils.getWriteMethod(descriptor) != null) {
							((List) propList).add(name);
						}
					} catch (Exception arg11) {
						;
					}
				}

				copyPropsMap.put(key, UnmodifiableList.decorate((List) propList));
			}
		}

		return (List) propList;
	}

	public static void copy(Object dst, Object src) {
		Wrapper srcWrapper = Wrapper.getWrapper(src.getClass());
		Wrapper destWrapper = Wrapper.getWrapper(dst.getClass());
		List props = getJoinProperties(srcWrapper.getReadPropertyNames(), src.getClass(), dst.getClass());
		copyInternal(dst, src, srcWrapper, destWrapper, props);
	}

	public static void copy(Object dst, Object src, boolean allow, String... fields) {
		if (ArrayUtils.isEmpty(fields)) {
			copy(dst, src);
		} else {
			Wrapper srcWrapper = Wrapper.getWrapper(src.getClass());
			Wrapper destWrapper = Wrapper.getWrapper(dst.getClass());
			Object copyProps = Arrays.asList(fields);
			if (!allow) {
				List props = getJoinProperties(srcWrapper.getReadPropertyNames(), src.getClass(), dst.getClass());
				Object remove = copyProps;
				copyProps = new ArrayList(props);
				((List) copyProps).removeAll((Collection) remove);
			}

			copyInternal(dst, src, srcWrapper, destWrapper, (List) copyProps);
		}

	}

	private static void copyInternal(Object dst, Object src, Wrapper srcWrapper, Wrapper destWrapper,
			List<String> props) {
		Iterator arg4 = props.iterator();

		while (arg4.hasNext()) {
			String name = (String) arg4.next();

			try {
				destWrapper.setPropertyValue(dst, name, srcWrapper.getPropertyValue(src, name));
			} catch (Throwable arg7) {
				dbLogger.warn(name, arg7, 10);
			}
		}

	}

	public static void copy(Object dst, Map<String, Object> beanmap) {
		Wrapper destWrapper = Wrapper.getWrapper(dst.getClass());
		copyInternal(dst, destWrapper, beanmap);
	}

	private static void copyInternal(Object dst, Wrapper destWrapper, Map<String, Object> beanmap) {
		Iterator arg2 = beanmap.entrySet().iterator();

		while (arg2.hasNext()) {
			Entry entry = (Entry) arg2.next();

			try {
				destWrapper.setPropertyValue(dst, (String) entry.getKey(), entry.getValue());
			} catch (Throwable arg5) {
				dbLogger.warn((String) entry.getKey(), arg5, 10);
			}
		}

	}
}