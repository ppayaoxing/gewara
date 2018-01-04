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
 * 锟斤拷锟节伙拷取system.profile锟斤拷录
 * @author 锟斤拷锟斤拷
 * @createDate 2015锟斤拷11锟斤拷11锟斤拷
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
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷询锟斤拷
	 * @param date 锟斤拷锟斤拷锟斤拷锟斤拷询锟斤拷录锟斤拷锟斤拷小锟斤拷锟斤拷时锟戒。
	 */
	public SystemProfileBuilder setMinCreateTime(Date ts){
		Expression expre=new Expression().gt("ts",ts);
		if(this.condition!=null) {
            expre.bson(this.condition);
        }
		this.condition=expre.toBson();
		return this;
	}
	public SystemProfileBuilder setType(String op){
		Expression expre=new Expression().gt("op",op);
		if(this.condition!=null) {
            expre.bson(this.condition);
        }
		this.condition=expre.toBson();
		return this;
	}
	
	/**
	 * 锟节诧拷询锟斤拷锟斤拷校锟斤拷丫锟斤拷远锟斤拷锟絠p锟斤拷址锟斤拷息锟斤拷锟斤拷锟剿诧拷询锟斤拷锟斤拷小锟� 
	 * 锟斤拷锟斤拷通锟斤拷get("hostIP")锟斤拷取IP锟斤拷息锟斤拷 get("hostTag")锟斤拷取mong锟斤拷锟斤拷亩锟斤拷锟絫ag value锟斤拷
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
