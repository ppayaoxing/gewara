package com.gewara.msearch.external.entity.index;

/**
 * 会员索引信息
 * @author 董明
 * @createDate 2015年6月3日
 */
public class MemberIndexInfo extends IndexData{
	
	private static final long serialVersionUID = -3071643178306274317L;
	private String nick=null;
	private String field1 = "";//预留扩展字段
	private String field2 = "";//预留扩展字段
	
	/**
	 * 会员昵称
	 * @return
	 */
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}
	
}
