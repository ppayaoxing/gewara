package com.gewara.mdb.builder;

import java.util.Map;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.gewara.mdb.operation.ArrayOperation;
import com.gewara.mdb.operation.Expression;
import com.gewara.mdb.result.UpdateRes;
import com.gewara.util.BeanUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;

/**
 * @author ����
 * @createDate 2015��7��30��
 * @param <T>
 */
public class UpdateBuilder<T> {
	
	private Class<T> sourceType=null;
	
	private Bson condition=null;
	private Document source=new Document();//�����Ԫ�ض�����Ҫ $set�������ġ�
	private Document otherSource=new Document();//������õĶ��Ǻ�$set������ͬһ���ġ�
	
	private UpdateOptions updateOptions=new UpdateOptions().upsert(false);
	private boolean updateMany=true;
	private String collectionName=null;
	
	public UpdateBuilder(String collectionName){
		this.collectionName=collectionName;
	}
	
	public UpdateBuilder(Class<T> mapping){
		this.collectionName=mapping.getCanonicalName();
		this.sourceType=mapping;
	}
	
	
	/**
	 * �����е���������ӽ�����condition���һ��And�Ĺ�ϵ��
	 * @param condition
	 * @return
	 */
	public UpdateBuilder<T> addAndCondition(Expression queryCondition){
		if(this.condition!=null){
			this.condition=Filters.and(this.condition,queryCondition.toBson());
		}else{
			this.condition=queryCondition.toBson();
		}
		return this;
	}
	
	/**
	 * �����е���������ӽ�����condition���һ��OR�Ĺ�ϵ��
	 * @param condition
	 * @return
	 */
	public UpdateBuilder<T> addOrCondition(Expression queryCondition){
		if(this.condition!=null){
			this.condition=Filters.or(this.condition,queryCondition.toBson());
		}else{
			this.condition=queryCondition.toBson();
		}
		return this;
	}
	
	
	
	/**
	 * ������������������Ḳ����֮ǰ�����õ�������
	 * @param condition
	 * @return
	 */
	public UpdateBuilder<T> setCondition(Expression queryCondition){
		this.condition = queryCondition.toBson();
		return this;
	}
	
	/**
	 * �����Ҫ���µ��ֶ��Լ���ֵ
	 * @param field
	 * @param value
	 * @return
	 */
	public <V> UpdateBuilder<T> addData(String field,V value ){
		this.source.put(field, value);
		return this;
	}
	
	public  UpdateBuilder<T> addData(Map<String,Object> map){
		this.source.putAll(map);
		return this;
	}
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	public UpdateBuilder<T> addData2Array(ArrayOperation arrayOp){
		this.otherSource.putAll(arrayOp.toDocument());;
		return this;
	}
	
	public UpdateBuilder<T> setData(T source){
		this.source=new Document();
		
		if(source instanceof Map){
			this.source.putAll((Map)source);
		}else{
			this.source.putAll(BeanUtil.getBeanMap(source));
		}
		return this;
	}
	
	
	
	/**
	 * 
	 * @param field
	 * @param number
	 * @return
	 */
	public UpdateBuilder<T> addData2Inc(String field,int number){
		this.otherSource.put("$inc",new Document(field,number));
		return this;
	}
	
	/**
	 * Ĭ���Ǹ��¶�����¼������Ϊtrue�󣬽�ֻ����һ����¼
	 * 
	 * @param updateMany
	 * @return
	 */
	public UpdateBuilder<T> setUpdateFirst(boolean updateFirst){
		this.updateMany=!updateFirst;
		return this;
	}
	
	/**
	 * ��û�з��������ļ�¼ʱ����Ӹü�¼��
	 * @param insert
	 * @return
	 */
	public UpdateBuilder<T> setInsert4NotFind(boolean insert){
		updateOptions.upsert(true);
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public UpdateRes replaceOne(MongoDatabase database){
		MongoCollection<Document> mc=database.getCollection(this.collectionName);
		UpdateResult ur = mc.replaceOne(this.condition, this.source,updateOptions);
		
		return new UpdateRes(ur);
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public Class<T> getSourceType() {
		return sourceType;
	}

	public Bson getQueryCondition(){
		if(condition!=null) {
            return condition;
        }
		return new BsonDocument();
	}

	public Document getSource() {
		return source;
	}

	public Document getOtherSource() {
		return otherSource;
	}

	public UpdateOptions getUpdateOptions() {
		return updateOptions;
	}

	public boolean isUpdateMany() {
		return updateMany;
	}

	public String getCollectionName() {
		return collectionName;
	}
}
