package com.gewara.mdb.builder;

import org.bson.BsonDocument;
import org.bson.conversions.Bson;

import com.gewara.mdb.operation.Expression;
import com.mongodb.client.model.Filters;

/**
 * 获取某一个字段不重复的值。
 * @author 董明
 * @createDate 2015年8月10日
 * @see AggregationBuilder
 */
public class DistinctBuilder {
	private Bson condition=null;
	private String collectionName=null;
	private String distincField=null;
	private Bson ids=null;
	
	public DistinctBuilder(String collectionName){
		this.collectionName=collectionName;
	}
	
	/**
	 * 设置条件，这个方法会覆盖这之前所设置的条件。
	 * @param condition
	 * @return
	 */
	public DistinctBuilder setCondition(Expression queryExpre){
		this.condition=queryExpre.toBson();
		return this;
	}
	
	/**
	 * 查找指定ID的文档的。该参数的设置会使Condition设置的条件失效。
	 * @param ids
	 * @return
	 */
	public <TItem> DistinctBuilder setIDByFindOlny(TItem... ids){
		if(ids!=null){
			this.ids=ids.length==1
					 ?Filters.eq("_id",ids[0])
					 :Filters.in("_id", ids);
		}
		return this;
	}
	
	
	public  DistinctBuilder setDistinctField(String fieldName){
		this.distincField=fieldName;
		return this;
	}
	

	public Bson getQueryCondition(){
		if(ids!=null) return ids;
		if(condition!=null) return condition;
		return new BsonDocument();
	}

	public String getCollectionName() {
		return collectionName;
	}

	public String getDistincField() {
		return distincField;
	}

	public Bson getIds() {
		return ids;
	}
	
}
