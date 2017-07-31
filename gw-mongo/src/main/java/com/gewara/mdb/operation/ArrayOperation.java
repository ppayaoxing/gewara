package com.gewara.mdb.operation;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.gewara.mdb.helper.MongoMapAble;
import com.gewara.util.BeanUtil;


/**
 * 这里主要封装了一些关于数组的操作方法。
 * 这里面的方法都可以重复调用。
 * @author 董明
 * @createDate 2015年8月21日
 */
public class ArrayOperation {
	
	private Document doc=new Document();
	private boolean base=true;
	
	public ArrayOperation valueType(boolean isBase){
		this.base=isBase;
		return this;
	}
	/**
	 * 将每个值放入数组的末尾,对于已经存在的值，将会忽略。
	 * 这里的set，表示的是数据结构Set
	 * @param field
	 * @param value
	 * @return
	 */
	public <V> ArrayOperation set2Tail(String field,V... values){
		assert(values!=null);
		Document hd=(Document)doc.get("$addToSet");
		if(values.length==1){
			if(null==hd)
				doc.append("$addToSet",new Document(field,toTrans(values[0])));
			else
				hd.append(field, values[0]);
		}else{
			if(null==hd)
				doc.append("$addToSet",new Document(field,new Document("$each",toList(values))));
			else
				hd.append(field, new Document("$each",toList(values)));
		}
		return this;
	}
	
	/**
	 * @param field
	 * @param position
	 * @param values
	 * @return
	 */
	public <V> ArrayOperation set2Position(String field,int position,V... values){
		assert(values!=null);
		Document f=new Document("$each",toList(values));
		f.append("$position", position);
		doc.append("$addToSet",new Document(field,f));		
		return this;
	}
	
	/**
	 * 将数据放入数组的末尾
	 * @param field 表示数组的字段名称
	 * @param values
	 * @return
	 */
	public <V> ArrayOperation push2Tail(String field,V... values){
		assert(values!=null);
		Document hd=(Document)doc.get("$push");
		if(values.length==1){
			if(null==hd)
				doc.append("$push",new Document(field,toTrans(values[0])));
			else
				hd.append(field, toTrans(values[0]));
		}else{
			if(null==hd){
				doc.append("$push",new Document(field,new Document("$each",toList(values))));
			}else{
				hd.append(field, new Document("$each",toList(values)));
			}
		}
		return this;
	}
	
	private List<Object> toList(Object... values){
		List<Object> list=new ArrayList<>(values.length);
		for(Object value:values){
			list.add(toTrans(value));
		}
		return  list;
	}
	
	private Object toTrans(Object value){
		return value instanceof MongoMapAble?((MongoMapAble)value).toMap():(base?value:BeanUtil.getBeanMap(value));
	}
	
	/**
	 * 更新符合查询条件的数组中的元素的值。
	 * 在查询条件。
	 * example
	 * <pre>
	 * 
	 * </pre>
	 * @param arrayField
	 * @param arrayItemField
	 * @param value
	 * @return
	 */
	public <V> ArrayOperation updateArrayItem(String arrayField,String arrayItemField,V value){
		Map setd=doc.get("$set", Map.class);
		if(setd==null){
			setd=new Document();
			doc.put("$set", setd);
		}
		
		Object obj=toTrans(value);
		if(arrayItemField!=null){
			setd.put(arrayField+".$."+arrayItemField, obj);
		}else{
			setd.put(arrayField+".$", obj);
		}
		return this;
	}
	
	/**
	 * 从指定位置插入指定的值
	 * @param field 数组字段名称
	 * @param position 位置
	 * @param values
	 * @return
	 */
	public <V> ArrayOperation push2Position(String field,int position,V... values){
		assert(values!=null);
		Document f=new Document("$each",toList(values));
		f.append("$position", position);
		
		Document hd=(Document)doc.get("$push");
		if(hd!=null){
			hd.append(field,f);;
		}else{
			doc.append("$push",new Document(field,f));
		}
		return this;
	}
	
	/**
	 * 从数组头部移除一个元素。
	 * @param fields
	 * @return
	 */
	public ArrayOperation remove4Head(String... fields){
		Document hd=(Document)doc.get("$pop");
		if(hd!=null){
			for(String f:fields){
				hd.append(f, -1);
			}
		}else{
			Document fc= new Document();
			for(String f:fields){
				fc.append(f, -1);
			}
			doc.append("$pop",fc);
		}
		return this;
	}
	
	
	/**
	 * 从数组尾部移除一个元素
	 * @param fields
	 * @return
	 */
	public ArrayOperation remove4Tail(String... fields){
		assert(fields!=null);
		Document hd=(Document)doc.get("$pop");
		if(hd!=null){
			for(String f:fields){
				hd.append(f, 1);
			}
		}else{
			Document fc= new Document();
			for(String f:fields){
				fc.append(f, 1);
			}
			doc.append("$pop",fc);
		}
		return this;
	}
	
	/**
	 * 从数组中移除指定值的元素。
	 * @param field
	 * @param values
	 * @return
	 */
	public <V> ArrayOperation remove4Value(String field,V... values){
		assert(values!=null);
		Document hd=(Document)doc.get("$pullAll");
		if(hd!=null){
			hd.append(field, toList(values));
		}else{
			doc.append("$pullAll", new Document(field,toList(values)));
		}
		return this;
	}
	
	/**
	 * 从数组中移除符合指定条件的元素
	 * @param field
	 * @param expression
	 * @return
	 */
	public  ArrayOperation remove4Condition(String field,Expression expression){
		assert(field!=null&&expression!=null);
		Document hd=(Document)doc.get("$pull");
		if(hd!=null){
			hd.append(field, expression.toBson());
		}else{
			doc.append("$pullAll", new Document(field,expression.toBson()));
		}
		return this;
	}
	
	public Document toDocument(){
		return this.doc;
	}
	
}
