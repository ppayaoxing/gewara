package com.gewara.mdb.builder;

import org.bson.BsonDocument;
import org.bson.conversions.Bson;

import com.gewara.mdb.operation.Expression;

/**
 * 删锟斤拷
 * @author 锟斤拷锟斤拷
 * @createDate 2015锟斤拷8锟斤拷25锟斤拷
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
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷岣诧拷锟斤拷锟街帮拷锟斤拷锟斤拷玫锟斤拷锟斤拷锟斤拷锟�
	 * @param condition
	 * @return
	 */
	public DeleteBuilder setCondition(Expression queryExpre){
		this.condition=queryExpre.toBson();
		return this;
	}
	
	/**
	 * 锟角凤拷只删锟斤拷一锟斤拷锟斤拷 
	 * 默锟斤拷锟斤拷删锟斤拷锟斤拷锟叫凤拷锟斤拷锟斤拷锟斤拷锟侥硷拷录锟斤拷
	 * @param removeFirst
	 * @return
	 */
	public DeleteBuilder setDeleteOne(boolean removeFirst){
		this.deleteOne=removeFirst;
		return this;
	}

	public Bson getQueryCondition(){
		if(ids!=null) {
            return ids;
        }
		if(condition!=null) {
            return condition;
        }
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
