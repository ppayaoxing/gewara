package com.gewara.mdb.builder;

import org.bson.BsonDocument;
import org.bson.conversions.Bson;

import com.gewara.mdb.operation.Expression;

/**
 * 删除
 * @author 董明
 * @createDate 2015年8月25日
 */
public class DeleteBuilder {
	
	private Bson condition=null;
	private boolean deleteOne=false;
	private Bson ids=null;
	private String collectionName=null;
	
	
	
	public DeleteBuilder(String collectionName){
		this.collectionName=collectionName;
	}
	
	/**
	 * 设置条件，这个方法会覆盖这之前所设置的条件。
	 * @param condition
	 * @return
	 */
	public DeleteBuilder setCondition(Expression queryExpre){
		this.condition=queryExpre.toBson();
		return this;
	}
	
	/**
	 * 是否只删除一条。 
	 * 默认是删除所有符合条件的记录。
	 * @param removeFirst
	 * @return
	 */
	public DeleteBuilder setDeleteOne(boolean removeFirst){
		this.deleteOne=removeFirst;
		return this;
	}

	public Bson getQueryCondition(){
		if(ids!=null) return ids;
		if(condition!=null) return condition;
		return new BsonDocument();
	}
	
	public boolean isDeleteOne() {
		return deleteOne;
	}

	public Bson getIds() {
		return ids;
	}

	public String getCollectionName() {
		return collectionName;
	}
	
}
