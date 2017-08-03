package com.gewara.movie.api.service.admin.filmfest;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.filmfest.SetTicketVo;
public interface SetTicketAdminVoService {
	/**
	 * 根据ID查询
	 * @param id
	 * @return
	 */
	ResultCode<SetTicketVo> getSetTicketVoById(String id);
	/**
	 * 根据电影节tag查询套票列表
	 * @param filmTag
	 * @return
	 */
	ResultCode<List<SetTicketVo>> getSetTicketListByTag(String filmTag);
	/**
	 * 查询或者修改套票
	 * @param id
	 * @param dataMap
	 * @return
	 */
	ResultCode<SetTicketVo> saveSetTicketVo(String id, Map<String, String> dataMap);
	/**
	 * 删除套票
	 * @param id
	 * @return
	 */
	ResultCode removeSetTicketVo(String id);
}
