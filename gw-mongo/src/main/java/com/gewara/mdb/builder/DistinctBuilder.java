package com.gewara.mdb.builder;

import org.bson.BsonDocument;
import org.bson.conversions.Bson;

import com.gewara.mdb.operation.Expression;
import com.mongodb.client.model.Filters;

/**
 * ��ȡĳһ���ֶβ��ظ���ֵ��
 * @author ����
 * @createDate 2015��8��10��
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
	 * ������������������Ḳ����֮ǰ�����õ�������
	 * @param condition
	 * @return
	 */
	public DistinctBuilder setCondition(Expression queryExpre){
		this.condition=queryExpre.toBson();
		return this;
	}
	
	/**
	 * ����ָ��ID���ĵ��ġ��ò��������û�ʹCondition���õ�����ʧЧ��
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
