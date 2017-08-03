package com.gewara.movie.api.service.admin.system;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;

/**
 * mysql管理员数据库操作接口
 */
public interface MySqlAdminService {

	/**
	 * 根据SQL查询指定对象的一条记录，并返回为Map
	 * @param sql
	 * @return
	 */
	ResultCode<Map<String, Object>> queryOneRowForMap(String sql);
	
	/**
	 * 根据SQL查询，返回Map的集合List（包含多条记录）
	 * @param sql
	 * @return
	 */
	ResultCode<List<Map<String, Object>>> queryMapListBySQL(String sql);
	
	/**
	 * 根据类名获取表信息
	 * @param clazzName
	 * @return
	 */
	ResultCode<Map<String, Object>> getTableInfo(String clazzName);
	
}
