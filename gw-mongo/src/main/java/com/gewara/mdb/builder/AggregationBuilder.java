package com.gewara.mdb.builder;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.gewara.mdb.operation.Expression;
import com.gewara.mdb.operation.Projection;
import com.gewara.util.Assert;

/**
 * �ۺϡ�
 * <br/>
 * @author ����
 * @createDate 2015��8��10��
 */
public class AggregationBuilder {
	private String collectionName=null;			//��������
	private Expression query;						//��ѯ����		
	private Document group = new Document();	//group
	private Projection projection;				//projection
	private List<Document> sortList = new ArrayList<Document>();
	private Document skip;
	private Document limit;
	private Expression having;
	
	public AggregationBuilder(String collectionName){
		this.collectionName=collectionName;
	}
	
	public AggregationBuilder setGroupFields(String... groupBy){
		Assert.isTrue(groupBy!=null && groupBy.length >0);
		
		if(groupBy.length==1) {
            group.append("_id", "$" + groupBy[0]);
        } else{
			Document gr=new Document();
			for(String gf:groupBy){
				gr.append(gf, "$"+gf);
			}
			group.append("_id", gr);
		}
		return this;
	}
	public AggregationBuilder setQuery(Expression qry){
		this.query = qry;
		return this;
	}
	public AggregationBuilder setHaving(Expression hv){
		this.having = hv;
		return this;
	}
	/**
	 * COUNT("$sum"),
		SUM("$sum"),
		AVG("$avg"),
		MAX("$max"),
		MIN("$min"),
	 * @param field
	 * @return
	 */
	public AggregationBuilder addSum(String field, String alias){
		group.append(alias, new Document("$sum", "$" + field));
		return this;
	}
	public AggregationBuilder addAvg(String field, String alias){
		group.append(alias, new Document("$avg", "$" + field));
		return this;
	}
	public AggregationBuilder addMax(String field, String alias){
		group.append(alias, new Document("$max", "$" + field));
		return this;
	}
	public AggregationBuilder addMin(String field, String alias){
		group.append(alias, new Document("$min", "$" + field));
		return this;
	}
	public AggregationBuilder addCount(String alias){
		group.append(alias, new Document("$sum", 1));
		return this;
	}
	
	public AggregationBuilder addSort(String field, boolean asc){
		sortList.add(new Document("$sort",new Document(field,asc?1:-1)));
		return this;
	}

	public AggregationBuilder setLimit(Integer from, Integer size){
		if(from!=null){
			skip = new Document("$skip",from);
		}
		if(size!=null){
			limit = new Document("$limit",size);
		}
		return this;
	}
	
	public AggregationBuilder setProjection(Projection projection){
		this.projection = projection;
		return this;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public List<Bson> build() {
		List<Bson> pipeLine=new ArrayList<>();
		if(query!=null){
			pipeLine.add(new Document("$match",query.toBson()));
		}
		pipeLine.add(new Document("$group", group));
		if(projection!=null){
			pipeLine.add(new Document("$project",projection.toBson()));
		}
		for(Document sort:sortList){
			pipeLine.add(sort);
		}
		if(having!=null){
			pipeLine.add(new Document("$match",having.toBson()));
		}
		if(skip != null){
			pipeLine.add(skip);
		}
		
		if(limit !=null){
			pipeLine.add(limit);
		}
/*		private Expression query;						//��ѯ����		
		private Document group = new Document();	//group
		private Projection projection;				//projection
		private List<Document> sortList = new ArrayList<Document>();
		private Document skip;
		private Document rows;
*/
		return pipeLine;
	}

}
