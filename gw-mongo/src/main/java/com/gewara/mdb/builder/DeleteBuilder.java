package com.gewara.mdb.builder;

import org.bson.BsonDocument;
import org.bson.conversions.Bson;

import com.gewara.mdb.operation.Expression;

/**
 * ɾ��
 * @author ����
 * @createDate 2015��8��25��
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
	 * ������������������Ḳ����֮ǰ�����õ�������
	 * @param condition
	 * @return
	 */
	public DeleteBuilder setCondition(Expression queryExpre){
		this.condition=queryExpre.toBson();
		return this;
	}
	
	/**
	 * �Ƿ�ֻɾ��һ���� 
	 * Ĭ����ɾ�����з��������ļ�¼��
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
