package com.gewara.mdb.builder;

import org.bson.BsonDocument;
import org.bson.conversions.Bson;

import com.gewara.mdb.operation.Expression;
import com.mongodb.client.model.Filters;

/**
 * 锟斤拷取某一锟斤拷锟街段诧拷锟截革拷锟斤拷值锟斤拷
 * @author 锟斤拷锟斤拷
 * @createDate 2015锟斤拷8锟斤拷10锟斤拷
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
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷岣诧拷锟斤拷锟街帮拷锟斤拷锟斤拷玫锟斤拷锟斤拷锟斤拷锟�
	 * @param condition
	 * @return
	 */
	public DistinctBuilder setCondition(Expression queryExpre){
		this.condition=queryExpre.toBson();
		return this;
	}
	
	/**
	 * 锟斤拷锟斤拷指锟斤拷ID锟斤拷锟侥碉拷锟侥★拷锟矫诧拷锟斤拷锟斤拷锟斤拷锟矫伙拷使Condition锟斤拷锟矫碉拷锟斤拷锟斤拷失效锟斤拷
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
		if(ids!=null) {
            return ids;
        }
		if(condition!=null) {
            return condition;
        }
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
