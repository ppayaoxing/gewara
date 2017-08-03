package com.gewara.movie.api.service.highlightentry;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.highlightentry.HighlightEntryVo;


/**
 * 亮点入口管理
 * @author weihua.wang
 *
 */
public interface HighlightEntryVoService {
	/**
	 * 获取亮点入口列表
	 * @return
	 */
	ResultCode<List<HighlightEntryVo>> getHighlightEntryVoList(int from ,int maxnum);
	
	/**
	 * 更新亮点入口
	 */
	ResultCode<HighlightEntryVo> updateHighlightEntryVo(HighlightEntryVo entry);
	
	/**
	 * 添加亮点入口
	 */
	ResultCode<HighlightEntryVo> saveHighlightEntryVo(HighlightEntryVo entry);
	
	/**
	 * 获取亮点入口
	 * @param entryId
	 * @return
	 */
	ResultCode<HighlightEntryVo> getHighlightEntryVoById(Long entryId);
	
	
	/**
	 * 删除亮点入口
	 * @param entryId
	 */
	ResultCode<HighlightEntryVo> removeHighlightEntryVoById(Long entryId);
}
