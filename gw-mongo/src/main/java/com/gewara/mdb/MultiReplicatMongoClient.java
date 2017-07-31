package com.gewara.mdb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 董明
 * @createDate 2015年9月14日
 */
public class MultiReplicatMongoClient {
	private final List<NameGWMongoClient> replicates=new ArrayList<NameGWMongoClient>();
	
	/**
	 * @param replicatName  mongo集群的名称
	 * @param mongoClient   mongo集群的连接池
	 */
	public MultiReplicatMongoClient(List<NameGWMongoClient> multiMongo){
		replicates.addAll(multiMongo);
	}
	
	/**
	 * @param replicatName
	 * @return
	 */
	public NameGWMongoClient useReplicat(String replicatName){
		for(int i=0;i<replicates.size();i++){
			if(replicates.get(i).replicateName().equals(replicatName)){
				return replicates.get(i);
			}
		}
		return null;
	}
	
	public List<NameGWMongoClient> listReplicate(){
		return Collections.unmodifiableList(replicates);
	}
}
