package com.gewara.mdb.helper;

import java.util.Map;

/**
 * 配合ArrayOperation使用。
 * 对于arrayOperation中的操作的值，如果实现了该接口，这调用该接口处理，
 * 否则按照基础数据类型进行处理
 * @author 董明
 * @createDate 2015年10月20日
 */
public interface MongoMapAble {
	Map<String,Object> toMap();
}
