package com.gewara.mdb.result;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.bson.Document;

import com.gewara.mdb.helper.DocumentConverter;
import com.gewara.mdb.helper.ResultUtil;


public class FindRes<T> {
	private Class<T> mapping=null;
	private List<Document> result=null;
	public FindRes(Iterator<Document> docs,Class<T> mappingClass){
		this(docs);
		this.mapping=mappingClass;
	}
	
	public FindRes(Iterator<Document> docs){
		if(docs!=null && docs.hasNext()){
			this.result=new ArrayList<Document>();
			while(docs.hasNext()){
				this.result.add(docs.next());
			}
		}else{
			result=new ArrayList<>(0);
		}
	}

	/**
	 * 锟斤拷锟矫该凤拷锟斤拷锟斤拷直锟接斤拷锟斤拷锟斤拷锟斤拷注锟斤拷锟� BeanUtilsBean锟叫ｏ拷
	 * 锟斤拷锟斤拷锟斤拷锟绞癸拷锟絘pache锟叫碉拷BeanUtils锟斤拷锟斤拷beanCopy锟斤拷锟斤拷锟杰达拷影锟届。
	 * @param propertyClass
	 * @return
	 */
	public FindRes<T> addPropertyClassType(Class propertyClass){
		BeanUtilsBean pub=BeanUtilsBean.getInstance();
		pub.getConvertUtils().register(new DocumentConverter(propertyClass), propertyClass);
		return this;
	}
	
	public int size(){
		return result!=null?this.result.size():0;
	}
	
	/**
	 * 锟斤拷锟斤拷锟斤拷氐锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟叫凤拷java锟侥伙拷锟斤拷锟斤拷锟酵伙拷锟斤拷锟侥伙拷锟斤拷锟斤拷锟矫该凤拷锟斤拷锟斤拷锟斤拷失锟杰★拷
	 * @return
	 */
	public String toJsonStr(){
		if(result.size()==1) {
            return this.result.get(0).toJson();
        }
		StringBuilder sb=new StringBuilder("[");
		for(Document doc:result){
			sb.append(doc.toJson()).append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~output~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public Map<String,Object> toMap(){
		if(this.result.isEmpty()){
			return null;
		}
		return ResultUtil.toMap(this.result.get(0));
	}
	
	public List<Map> toMapList(){
		List<Map> resultList = new ArrayList<Map>();
		for(Document doc:this.result){
			Map b=ResultUtil.toMap(doc);
			if(b!=null) {
                resultList.add(b);
            }
		}
		return resultList;
	}
	
	public T toBean(){
		if(result==null || result.isEmpty()) {
            return null;
        }
		return ResultUtil.toBean(mapping, result.get(0));
	}
	
	public List<T> toBeans(){
		return ResultUtil.toBeans(mapping, result);
	}
}
