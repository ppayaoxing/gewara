package com.gewara.mdb.operation;

import org.bson.Document;

/**
 * 暂未实现
 * @author 董明
 * @createDate 2015年8月21日
 */
public class UpdateOperation {
	
	protected Document doc=new Document();
	
	public <Num extends Number> UpdateOperation inc(String field,Num value){
		return this;
	}
	
	public <Num extends Number> UpdateOperation mul(String field,Num value){
		return this;
	}
	
	/**
	 * 修改字段名称
	 * @param field
	 * @param newFieldName
	 * @return
	 */
	public UpdateOperation renameFiled(String field,String newFieldName){
		return this;
	}
	
	/**
	 * 删除某个字段
	 * @param field
	 * @return
	 */
	public UpdateOperation delField(String... field){
		return this;
	}
	
	/**
	 * 设置在更新时，只有插入，才设置改字段的值。
	 * @param field
	 * @param value
	 * @return
	 */
	public <TItem> UpdateOperation setOnInsert(String field,TItem value){
		return this;
	}
	
	public <TItem> UpdateOperation data(String field,TItem value){
		return this;
	}
	
	
	/**
	 * 如果指定的value小于field的当前值，则更新field的值为value。
	 * field不存在或为null，也会更新field的值
	 * @param field
	 * @param value
	 * @return
	 */
	public <TItem> UpdateOperation min(String field,TItem value){
		return this;
	}
	
	/**
	 * 如果指定的值大于field的当前值,则更新field的值为value
	 * field不存在或为null，也会更新field的值
	 * @param field
	 * @param value
	 * @return
	 */
	public <TItem> UpdateOperation max(String field,TItem value){
		return this;
	}
	
	/**
	 * 设置当前日期
	 * @return
	 */
	public UpdateOperation currentDate(String Field){
		return this;
	}
	
	
}
