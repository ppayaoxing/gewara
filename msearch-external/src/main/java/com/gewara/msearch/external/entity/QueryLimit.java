package com.gewara.msearch.external.entity;

import java.io.Serializable;

import com.gewara.msearch.external.constant.DataType;

/**
 * 锟截憋拷注锟解，锟斤拷锟矫恳伙拷锟斤拷锟斤拷锟斤拷锟斤拷停锟街伙拷锟斤拷锟揭伙拷锟斤拷锟斤拷啤锟�
 * 锟斤拷锟截憋拷锟斤拷锟斤拷equals锟斤拷锟斤拷锟斤拷hasCode锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟皆★拷
 * @author 锟斤拷锟斤拷
 * @createDate 2015锟斤拷6锟斤拷2锟斤拷
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
	 * 锟斤拷锟斤拷锟斤拷锟斤拷
	 * @param dataType
	 */
	private void setDataType(DataType dataType) {
		assert(dataType!=null);
		this.dataType = dataType;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟酵凤拷锟截碉拷锟斤拷锟斤拷锟斤拷菁锟铰硷拷锟�
	 * @param limit limit锟斤拷值锟斤拷0锟斤拷100之锟戒（锟斤拷锟斤拷锟斤拷0锟斤拷100锟斤拷
	 */
	private void setLimit(int limit) {
		assert(limit>0 && limit<100);
		this.limit = limit;
	}
	
	public String getCityID() {
		return cityID;
	}

	/**
	 * 锟斤拷锟斤拷ID锟斤拷锟斤拷确匹锟戒。
	 * 目前只锟斤拷cinema锟斤拷action锟斤拷效
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
