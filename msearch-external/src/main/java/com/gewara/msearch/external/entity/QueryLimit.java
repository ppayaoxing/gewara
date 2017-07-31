package com.gewara.msearch.external.entity;

import java.io.Serializable;

import com.gewara.msearch.external.constant.DataType;

/**
 * 特别注意，针对每一种数据类型，只能有一个限制。
 * 请特别该类的equals方法和hasCode方法的特殊性。
 * @author 董明
 * @createDate 2015年6月2日
 */
public class QueryLimit implements Serializable {

	private static final long serialVersionUID = 8742192944925589174L;
	private DataType dataType = null;
	private int limit = 3;
	private String cityID=null;
	
	

	public QueryLimit(DataType dataType){
		this.setDataType(dataType);
	}
	
	public QueryLimit(DataType type,int limit){
		this.setDataType(type);
		this.setLimit(limit);
	}
	
	public DataType getDataType() {
		return dataType;
	}

	public int getLimit() {
		return limit;
	}

	/**
	 * 数据类型
	 * @param dataType
	 */
	private void setDataType(DataType dataType) {
		assert(dataType!=null);
		this.dataType = dataType;
	}

	/**
	 * 设置数据类型返回的最大数据记录数
	 * @param limit limit的值在0到100之间（不包含0和100）
	 */
	private void setLimit(int limit) {
		assert(limit>0 && limit<100);
		this.limit = limit;
	}
	
	public String getCityID() {
		return cityID;
	}

	/**
	 * 城市ID，精确匹配。
	 * 目前只有cinema，action有效
	 * @param cityID
	 */
	public void setCityID(String cityID) {
		this.cityID = cityID;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj==null) return false;
		if(obj==this) return true;
		if(obj instanceof QueryLimit && ((QueryLimit) obj).getDataType()==this.dataType){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return this.dataType.hashCode();
	}
	
}
