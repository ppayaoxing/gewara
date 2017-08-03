package com.gewara.api.gpticket.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.gewara.api.gpticket.vo.ticket.FieldAreaSeatVo;
import com.gewara.api.gpticket.vo.ticket.FieldAreaVo;
import com.gewara.api.gpticket.vo.ticket.FieldVo;
import com.gewara.api.gpticket.vo.ticket.ShowAreaVo;
import com.gewara.api.gpticket.vo.ticket.ShowItemPackPriceVo;
import com.gewara.api.gpticket.vo.ticket.ShowItemPriceVo;
import com.gewara.api.gpticket.vo.ticket.ShowItemVo;
import com.gewara.api.gpticket.vo.ticket.ShowPackPriceVo;
import com.gewara.api.gpticket.vo.ticket.ShowPriceVo;
import com.gewara.api.gpticket.vo.ticket.ShowSeatVo;
import com.gewara.api.vo.ResultCode;

/**
 * ÑÝ³ö²âÊÔ
 * @author zhaorq
 *
 */
public interface GpticketApiService {

	ResultCode<List<FieldVo>> getFieldList(Long theatreid);
	
	ResultCode<List<FieldAreaVo>> getFieldAreaList(Long theatreid, String fieldnum);
	
	ResultCode<List<FieldAreaSeatVo>> getFieldAreaSeatList(Long theatreid, String fieldnum, String areanum);
	
	ResultCode<List<ShowItemVo>> getShowItemList(Long theatreid, Timestamp updatetime);
	
	ResultCode<List<ShowItemVo>> getShowItemList(Long theatreid, Date playdate);
	
	ResultCode<ShowItemVo> getShowItem(String siseq);
	
	ResultCode<List<ShowAreaVo>> getShowAreaList(String siseqno);
	
	ResultCode<List<ShowItemPriceVo>> getShowItemPriceList(String siseqno);
	
	ResultCode<List<ShowItemPackPriceVo>> getShowItemPackPriceList(String siseqno);
	
	ResultCode<List<ShowPriceVo>> getShowPriceList(String arseqno);
	
	ResultCode<List<ShowPackPriceVo>> getShowPackPriceList(String arseqno);
	
	ResultCode<List<ShowSeatVo>> getShowSeatList(String arseqno);
}
