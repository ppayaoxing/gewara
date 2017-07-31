package com.gewara.mdb.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.gewara.util.BeanUtil;
import com.mongodb.client.model.InsertManyOptions;

public class InsertBuilder<T> {
	private Class<T> sourceType = null;
	private List<Document> sources = new ArrayList<Document>();
	private Bson id = null;

	private InsertManyOptions insertManyOptions = new InsertManyOptions();
	private boolean autoCreateID = true;

	private String collectionName = null;

	public InsertBuilder(String collectionName) {
		this.collectionName = collectionName;
	}

	public InsertBuilder(Class<T> mapping) {
		this.collectionName = mapping.getCanonicalName();
		this.sourceType = mapping;
	}

	/**
	 * 选择插入模式.多条数据插入时有影响 默认的情况是，顺序插入，如果有一个失败，则停止。 独立插入是指，每个doc的插入是独立的，互不影响。
	 * 
	 * @param alone
	 * @return
	 */
	public InsertBuilder<T> setInsertModel(boolean alone) {
		if (alone) {
			insertManyOptions = new InsertManyOptions().ordered(false);
		}
		return this;
	}

	private void addDataSource(T data) {
		assert (data != null);
		Map map = null;
		if (data instanceof Map) {
			map = (Map) data;
		} else {
			map = BeanUtil.getBeanMap(data);
		}

		if (map != null && !map.isEmpty()) {
			Document doc = new Document();
			doc.putAll(map);
			sources.add(doc);
		}
	}

	/**
	 * 添加记录，一个bean对应一条记录 <br/>
	 * 如果有设置了主键名称，那么在自动从bean中获取对应的字段的值作为主键的值。 <br/>
	 * 如果未指定，则使用系统默认的主键生成机制。
	 * 
	 * @param data
	 *           需要添加的数据。如果有设置
	 * @return
	 */
	public InsertBuilder<T> addData4Bean(T... datas) {
		for (T data : datas) {
			addDataSource(data);
		}
		return this;
	}

	/**
	 * 
	 *
	 * @param datas
	 * @return
	 */
	public InsertBuilder<T> setData4Bean(Collection<T> datas) {
		this.sources = new ArrayList<Document>();
		for (T data : datas) {
			addDataSource(data);
		}
		return this;
	}

	public Class<T> getSourceType() {
		return sourceType;
	}

	/*public Bson getQueryCondition(){
		if(condition!=null) return condition;
		return new BsonDocument();
	}*/

	public List<Document> getSources() {
		return sources;
	}
	public Document getTop(){
		return sources.get(0);
	}
	public Bson getId() {
		return id;
	}

	public InsertManyOptions getInsertManyOptions() {
		return insertManyOptions;
	}

	public boolean isAutoCreateID() {
		return autoCreateID;
	}

	public String getCollectionName() {
		return collectionName;
	}
}
