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
 * ���ڻ�ȡsystem.profile��¼
 * @author ����
 * @createDate 2015��11��11��
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
	 * ����������ѯ��
	 * @param date ��������ѯ��¼����С����ʱ�䡣
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
	 * �ڲ�ѯ����У��Ѿ��Զ���ip��ַ��Ϣ�����˲�ѯ����С� 
	 * ����ͨ��get("hostIP")��ȡIP��Ϣ�� get("hostTag")��ȡmong����Ķ���tag value��
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
