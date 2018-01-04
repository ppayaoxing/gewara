package com.gewara.msearch.external.entity;

import java.io.Serializable;

import com.gewara.msearch.external.constant.DataType;

/**
 * �ر�ע�⣬���ÿһ���������ͣ�ֻ����һ�����ơ�
 * ���ر�����equals������hasCode�����������ԡ�
 * @author ����
 * @createDate 2015��6��2��
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
	 * ��������
	 * @param dataType
	 */
	private void setDataType(DataType dataType) {
		assert(dataType!=null);
		this.dataType = dataType;
	}

	/**
	 * �����������ͷ��ص�������ݼ�¼��
	 * @param limit limit��ֵ��0��100֮�䣨������0��100��
	 */
	private void setLimit(int limit) {
		assert(limit>0 && limit<100);
		this.limit = limit;
	}
	
	public String getCityID() {
		return cityID;
	}

	/**
	 * ����ID����ȷƥ�䡣
	 * Ŀǰֻ��cinema��action��Ч
	 * @param cityID
	 */
	public void setCityID(String cityID) {
		this.cityID = cityID;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj==null) {
            return false;
        }
		if(obj==this) {
            return true;
        }
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
