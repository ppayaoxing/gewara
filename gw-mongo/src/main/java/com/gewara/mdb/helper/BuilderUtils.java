/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.helper;

import com.gewara.mdb.builder.AggregationBuilder;
import com.gewara.mdb.builder.DeleteBuilder;
import com.gewara.mdb.builder.DistinctBuilder;
import com.gewara.mdb.builder.FindBuilder;
import com.gewara.mdb.builder.IndexBuilder;
import com.gewara.mdb.builder.InsertBuilder;
import com.gewara.mdb.builder.UpdateBuilder;

public class BuilderUtils {
	public static DistinctBuilder prepareDistinct(String collectionName) {
		return new DistinctBuilder(collectionName);
	}

	public static AggregationBuilder prepareAggregation(String collectionName) {
		return new AggregationBuilder(collectionName);
	}

	public static FindBuilder prepareFind(String collectionName) {
		return new FindBuilder(collectionName);
	}

	public static <T> FindBuilder<T> prepareFind(Class<T> pojoClass) {
		return new FindBuilder(pojoClass);
	}

	public static <T> FindBuilder<T> prepareFind(String collectionName, Class<T> pojoClass) {
		return new FindBuilder(collectionName, pojoClass);
	}

	public static UpdateBuilder prepareUpdate(String collectionName) {
		return new UpdateBuilder(collectionName);
	}

	public static <T> UpdateBuilder<T> prepareUpdate(Class<T> pojoClass) {
		return new UpdateBuilder(pojoClass);
	}

	public static InsertBuilder prepareInsert(String collectionName) {
		return new InsertBuilder(collectionName);
	}

	public static <T> InsertBuilder<T> prepareInsert(T pojo) {
		return (new InsertBuilder(pojo.getClass())).addData4Bean(new Object[] { pojo });
	}

	public static <T> InsertBuilder<T> prepareInsert(Class<T> pojoClass) {
		return new InsertBuilder(pojoClass);
	}

	public static DeleteBuilder prepareDelete(String collectionName) {
		return new DeleteBuilder(collectionName);
	}

	public static <T> DeleteBuilder prepareDelete(Class<T> pojoClass) {
		return new DeleteBuilder(pojoClass.getCanonicalName());
	}

	public static IndexBuilder prepareIndex(String collectionName) {
		return new IndexBuilder(collectionName);
	}
}