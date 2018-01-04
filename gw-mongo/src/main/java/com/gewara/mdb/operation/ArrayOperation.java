package com.gewara.mdb.operation;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.gewara.mdb.helper.MongoMapAble;
import com.gewara.util.BeanUtil;


/**
 * 锟斤拷锟斤拷锟斤拷要锟斤拷装锟斤拷一些锟斤拷锟斤拷锟斤拷锟斤拷牟锟斤拷锟斤拷锟斤拷锟斤拷锟�
 * 锟斤拷锟斤拷锟斤拷姆锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷馗锟斤拷锟斤拷谩锟�
 * @author 锟斤拷锟斤拷
 * @createDate 2015锟斤拷8锟斤拷21锟斤拷
 */
public class ArrayOperation {
	
	private Document doc=new Document();
	private boolean base=true;
	
	public ArrayOperation valueType(boolean isBase){
		this.base=isBase;
		return this;
	}
	/**
	 * 锟斤拷每锟斤拷值锟斤拷锟斤拷锟斤拷锟斤拷锟侥┪�,锟斤拷锟斤拷锟窖撅拷锟斤拷锟节碉拷值锟斤拷锟斤拷锟斤拷锟斤拷浴锟�
	 * 锟斤拷锟斤拷锟絪et锟斤拷锟斤拷示锟斤拷锟斤拷锟斤拷锟捷结构Set
	 * @param field
	 * @param value
	 * @return
	 */
	public <V> ArrayOperation set2Tail(String field,V... values){
		assert(values!=null);
		Document hd=(Document)doc.get("$addToSet");
		if(values.length==1){
			if(null==hd) {
                doc.append("$addToSet", new Document(field, toTrans(values[0])));
            } else {
                hd.append(field, values[0]);
            }
		}else{
			if(null==hd) {
                doc.append("$addToSet", new Document(field, new Document("$each", toList(values))));
            } else {
                hd.append(field, new Document("$each", toList(values)));
            }
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
	 * 锟斤拷锟斤拷锟捷凤拷锟斤拷锟斤拷锟斤拷锟侥┪�
	 * @param field 锟斤拷示锟斤拷锟斤拷锟斤拷侄锟斤拷锟斤拷锟�
	 * @param values
	 * @return
	 */
	public <V> ArrayOperation push2Tail(String field,V... values){
		assert(values!=null);
		Document hd=(Document)doc.get("$push");
		if(values.length==1){
			if(null==hd) {
                doc.append("$push", new Document(field, toTrans(values[0])));
            } else {
                hd.append(field, toTrans(values[0]));
            }
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
	 * 锟斤拷锟铰凤拷锟较诧拷询锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟叫碉拷元锟截碉拷值锟斤拷
	 * 锟节诧拷询锟斤拷锟斤拷锟斤拷
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
	 * 锟斤拷指锟斤拷位锟矫诧拷锟斤拷指锟斤拷锟斤拷值
	 * @param field 锟斤拷锟斤拷锟街讹拷锟斤拷锟斤拷
	 * @param position 位锟斤拷
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
	 * 锟斤拷锟斤拷锟斤拷头锟斤拷锟狡筹拷一锟斤拷元锟截★拷
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
	 * 锟斤拷锟斤拷锟斤拷尾锟斤拷锟狡筹拷一锟斤拷元锟斤拷
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
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟狡筹拷指锟斤拷值锟斤拷元锟截★拷
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
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟狡筹拷锟斤拷锟斤拷指锟斤拷锟斤拷锟斤拷锟斤拷元锟斤拷
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
