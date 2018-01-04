package com.gewara.mdb.result;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.bson.Document;

import com.gewara.mdb.helper.RowDataProcess;
import com.gewara.mongo.MongoDataException;

public class ScanRes<T> {
	private Class<T> mapping=null;
	private String mappingIDName=null;
	private Iterator<Document> docs=null;
	private RowDataProcess<T> processApp=null;
	
	public ScanRes(Iterator<Document> docs,Class<T> mappingClass){
		this.docs=docs;
		this.mapping=mappingClass;
	}
	
	public ScanRes<T> setMappingIDName(String beanMappingIDName){
		this.mappingIDName=beanMappingIDName;
		return this;
	}
	
	public ScanRes<T> setDataProcessApp(RowDataProcess<T> rowdataProcess, Class<T> paramClass){
		this.mapping=paramClass;
		this.processApp=rowdataProcess;
		return this;
	}
	
	private  T toBean(Document doc){
		if(this.mapping==null) {
            throw new MongoDataException("please set the mapping bean type");
        }
		if(this.mapping.equals(Map.class)){
			return (T)doc;
		}else{
			try {
				T dest=mapping.newInstance();
				PropertyUtils.copyProperties(dest, doc);
				if(this.mappingIDName!=null){
					PropertyUtils.setProperty(dest,this.mappingIDName,doc.get("_id"));
				}
				return dest;
			} catch (IllegalAccessException | InvocationTargetException
					| NoSuchMethodException | InstantiationException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 同锟斤拷锟斤拷锟斤拷
	 */
	public void startSyncProcess(){
		while(docs.hasNext()){
			this.processApp.process(toBean(docs.next()));
		}
	}
	
	/**
	 * 锟斤拷一锟斤拷锟竭程ｏ拷锟斤拷锟斤拷锟届步锟斤拷锟斤拷
	 */
	public void startAsyncProcess(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				startSyncProcess();
			}
		}).start();
	}
	
}
