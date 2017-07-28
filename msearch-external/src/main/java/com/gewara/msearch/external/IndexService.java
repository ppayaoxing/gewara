/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external;

import com.gewara.api.vo.ResultCode;
import com.gewara.msearch.external.constant.DataType;
import com.gewara.msearch.external.entity.index.IndexData;
import java.util.List;

public interface IndexService {
	<T extends IndexData> ResultCode<String> addIndex(DataType arg0, T... arg1);

	<T extends IndexData> ResultCode<String> addGwSearchIndex(DataType arg0, List<T> arg1);

	<T extends IndexData> ResultCode<String> updateIndex(DataType arg0, List<String> arg1, T... arg2);

	<T extends IndexData> boolean deleteIndex(DataType arg0, T arg1);

	boolean deletePcIndex(String arg0);

	boolean deleteIndex(String arg0, String arg1, String arg2);
}