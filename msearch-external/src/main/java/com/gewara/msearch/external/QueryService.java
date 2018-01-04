package com.gewara.msearch.external;

import java.util.Collection;

import com.gewara.api.vo.ResultCode;
import com.gewara.msearch.external.entity.GwSearchResult;
import com.gewara.msearch.external.entity.QueryCondition;
import com.gewara.msearch.external.entity.QueryResult;

public interface QueryService {
	/**
	 * 查询指定的数据类型
	 * @param <T>
	 * @param condition
	 * @return
	 */
	public <T> ResultCode<Collection<QueryResult<T>>> query(QueryCondition condition);
	
	/**
	 * 原主站查询
	 * @param citycode
	 * @param skey
	 * @param channel
	 * @param tag
	 * @param category
	 * @param from
	 * @param limit
	 * @return
	 */
	public ResultCode<QueryResult<GwSearchResult>> queryGwSearch(String citycode, String skey, String channel, String tag, String category, int from, int limit);
	/**
	 * 全文检索，忽略数据类型。
	 * 
	 * @param condition
	 * @return
	 */
	//public Collection<PageQueryResult<DataType,String>> fullQuery(String queryStr,Integer from,Integer pageSize);
}
