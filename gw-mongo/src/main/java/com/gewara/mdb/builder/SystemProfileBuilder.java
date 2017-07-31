package com.gewara.mdb.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.gewara.mdb.HostInfo;
import com.gewara.mdb.helper.RowDataProcess;
import com.gewara.mdb.operation.Expression;
import com.gewara.mdb.result.ScanRes;
import com.mongodb.ReadPreference;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * 用于获取system.profile记录
 * @author 董明
 * @createDate 2015年11月11日
 */
public class SystemProfileBuilder {
	private Collection<MongoCollection<Document>> profileCollections=null;
	private Collection<HostInfo> hosts=null;
	private Bson condition=null;
	
	public SystemProfileBuilder(Collection<MongoDatabase> databases,Collection<HostInfo> hosts){
		this.profileCollections=new ArrayList<>(databases.size());
		for(MongoDatabase db:databases){
			this.profileCollections.add(db.getCollection("system.profile"));
		}
		this.hosts=hosts;
	}
	
	/**
	 * 用于增量查询，
	 * @param date 设置慢查询记录的最小生成时间。
	 */
	public SystemProfileBuilder setMinCreateTime(Date ts){
		Expression expre=new Expression().gt("ts",ts);
		if(this.condition!=null)
			expre.bson(this.condition);
		this.condition=expre.toBson();
		return this;
	}
	public SystemProfileBuilder setType(String op){
		Expression expre=new Expression().gt("op",op);
		if(this.condition!=null)
			expre.bson(this.condition);
		this.condition=expre.toBson();
		return this;
	}
	
	/**
	 * 在查询结果中，已经自动将ip地址信息加入了查询结果中。 
	 * 可以通过get("hostIP")获取IP信息， get("hostTag")获取mong服务的对于tag value。
	 * 
	 * @param rowdataProcess
	 */
	@SuppressWarnings("rawtypes")
	public  void find(final RowDataProcess<Map> rowdataProcess){
		for(MongoCollection profileCollection:profileCollections){
			for(final HostInfo host:hosts){
				MongoCollection<Document> collection=profileCollection.withReadPreference(ReadPreference.nearest(host.getTagSet()));
						FindIterable<Document> fi=(condition==null?collection.find():collection.find(condition));
				
				ScanRes<Map> sr=new ScanRes<>(fi.iterator(),Map.class);
				sr.setDataProcessApp(new RowDataProcess<Map>() {
					@Override
					public void process(Map rowData) {
						rowData.put("hostIP", host.getIp());
						rowData.put("hostTag",host.getTagValue());
						rowdataProcess.process(rowData);
					}
				}, Map.class);
				sr.startSyncProcess();
			}
		}
	}

}
