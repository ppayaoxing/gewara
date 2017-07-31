package com.gewara.msearch.external;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.msearch.external.constant.DataType;
import com.gewara.msearch.external.entity.index.IndexData;

public interface IndexService {
	/**添加索引
	 * @param type
	 * @param data 索引数据
	 */
	public <T extends IndexData> ResultCode<String> addIndex(DataType type,T... datas);
	
	/**
	 * 添加原来主站上的索引数据
	 * @param type
	 * @param datas
	 * @return
	 */
	public <T extends IndexData> ResultCode<String> addGwSearchIndex(DataType type, List<T> datas);
	
	/**
	 * 修改索引数据
	 * @param type 目前只支持member类的修改
	 * @param modifyPropsName 待修改的属性名称
	 * @param datas 修改后的对象，对象id不能为空
	 * @return
	 */
	public <T extends IndexData> ResultCode<String> updateIndex(DataType type,List<String> modifyPropsName, T...datas);
	
	/**
	 * 删除mobile下的index
	 * @param type
	 * @param data
	 * @return
	 */
	public <T extends IndexData> boolean  deleteIndex(DataType type, T data);
	
	/**
	 * 删除pc上的index
	 * @param id 请使用category+id组合，如：activity20134894
	 * @return
	 */
	public boolean deletePcIndex(String id);
	
	/**
	 * 删除ES中的index
	 * @param indexName
	 * @param indexType
	 * @param documentID
	 * @return
	 */
	public boolean deleteIndex(String indexName,String indexType,String documentID);
	
}
