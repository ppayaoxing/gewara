package com.gewara.drama.admin.dubbo.schedule;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.TheatreSeatPriceVo;
import com.gewara.drama.vo.cmd.TspExtCommandVo;
import com.gewara.drama.vo.schedule.TheatreSeatPriceExtVo;

public interface TheatreSeatPriceAdminVoService {
	
	ResultCode<TheatreSeatPriceVo> getTheatreSeatPriceById(Long id);
	
	ResultCode<List<TheatreSeatPriceVo>> getTheatreSeatPriceListByDpid(Long dpid);
	
	ResultCode<List<TheatreSeatPriceVo>> getTheatreSeatPriceListByAreaid(Long areaid);
	
	ResultCode<List<TheatreSeatPriceVo>> getTheatreSeatPriceByField(String fieldname, Serializable fieldvalue);
	
	ResultCode<List<TheatreSeatPriceVo>> getTheatreSeatPriceByIdList(List<Long> idList);
	
	/**
	 * 后台管理人员调整数存
	 * @param tsp
	 * @param command
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	ResultCode correctPrice(Long tspid, TspExtCommandVo command);
	
	/**
	 * 保存或修改价格
	 * @param id
	 * @param dpid
	 * @param areaid
	 * @param price
	 * @param request
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	ResultCode<TheatreSeatPriceVo> updateTheatreSeatPrice(RequestParamVo paramVo);

	ResultCode<TheatreSeatPriceVo> updateTheatreSeatPrice(Long tspid, String status, Timestamp updatetime);
	
	ResultCode updateTheatreSeatPriceList(Collection<Long> tspidList, String status, Timestamp updatetime);
	
	ResultCode<Integer> getTheatreSeatPriceExtCountByDramaid(Long dramaid, Long theatreid, String correcttype, Timestamp starttime, Timestamp endtime);
	
	ResultCode<List<TheatreSeatPriceExtVo>> getTheatreSeatPriceExtList(RequestParamVo paramVo);
	
	/**
	 * 查询包含实票在时间段内未结束的项目
	 * @param starttime
	 * @param endttime
	 * @return
	 */
	ResultCode<List<Long>> getOpenDramaidByPriceExt(Timestamp endttime);
	
	/**
	 * 根据价格ID查询库存数据
	 * @param tspid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<TheatreSeatPriceExtVo>> getTheatreSeatPriceExtListByTspid(Long tspid, String correcttype, int from, int maxnum);
	
	ResultCode<Integer> getTheatreSeatPriceExtCount(Long tspid, String correcttype);
	
	ResultCode<List<TheatreSeatPriceVo>> getTheatreSeatPriceList(Long dramaid, int from, int maxnum);
	
	ResultCode<TheatreSeatPriceVo> setShowPrice(Long id, String showprice);
	
	ResultCode<TheatreSeatPriceVo> setShowRemark(Long tspid, String showremark);
	
	/**
	 * 订单出库或订单退票入库
	 * @param tradeno
	 * @param correcttype
	 * FIXME:订单类型
	 */
	ResultCode asynchCreatePriceExt(String tradeno, String correcttype);
	
	ResultCode<Map<Long /*dpid*/, List<TheatreSeatPriceVo>>> getTheatreSeatPriceMap(List<Long> dpidList, String sortFieldname);
	
	ResultCode<Map<Long /*areaid*/, List<TheatreSeatPriceVo>>> getTheatreSeatPriceMapByAreaid(List<Long> areaidList, String sortFieldname);
	
}
