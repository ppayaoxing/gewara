package com.gewara.msearch.external.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.gewara.msearch.external.constant.DataType;

/**
 * 查询条件
 * @author 董明
 * @createDate 2015年6月3日
 */
	
public class QueryCondition implements Serializable{
	private static final long serialVersionUID = 592656313621653118L;


	private int from=0;
	

	private String queryStr = null;
	private Set<QueryLimit> queryLimits = null;

	/**
	 * 查询的文本
	 * @return
	 */
	public String getQueryStr() {
		return queryStr;
	}

	/**
	 * 查询的数据类型，以及每种数据类型返回的条数。
	 * 
	 * @return
	 */
	public Set<QueryLimit> getQueryLimits() {
		return queryLimits;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getFrom() {
		return from;
	}

	/**
	 * 设置从第几条记录开始获取,包含
	 * @param from
	 */
	public void setFrom(int from) {
		this.from = from;
	}
	

	public void setQueryStr(String queryStr) {
		assert(queryStr!=null&&queryStr.trim().length()>0);
		this.queryStr = queryStr;
	}

	/**
	 * queryLimit同时也用来控制每次查询的数据种类。未指定的，不查询。
	 * 请注意QueryLimit 的equals和hashCode的特殊性（每种数据类型，只能有一个QueryLimit）。
	 * @param queryLimit
	 */
	public void setQueryLimit(Set<QueryLimit> queryLimit) {
		assert(queryLimit!=null&&!queryLimit.isEmpty());
		this.queryLimits = queryLimit;
	}
	
	/**
	 *
	 */
	public void addQueryLimit(QueryLimit queryLimit) {
		assert(queryLimit!=null);
		if(this.queryLimits==null){
			this.queryLimits=new HashSet<>();
		}
		this.queryLimits.add(queryLimit);
	}
	
	public void addQueryLimit(DataType type,int limit) {
		addQueryLimit(new QueryLimit(type,limit));
	}
	
	/**
	 * 用于校验查询参数是否合法。
	 * @return
	 */
	public boolean validate(){
		return !(this.queryLimits==null||this.queryLimits.isEmpty()
				|| this.queryStr==null||this.queryStr.trim().length()==0);
		
	}
	
	@Override
	public String toString(){
		String rv = "queryStr[" + this.queryStr + "], queryLimts[";
		for(QueryLimit ql : this.queryLimits){
			rv += ql.getDataType() + ":" + ql.getLimit() + ","; 
		}
		return rv + "]";
	}
}
