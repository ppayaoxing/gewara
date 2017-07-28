/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.service;

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
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface GpticketApiService {
	ResultCode<List<FieldVo>> getFieldList(Long arg0);

	ResultCode<List<FieldAreaVo>> getFieldAreaList(Long arg0, String arg1);

	ResultCode<List<FieldAreaSeatVo>> getFieldAreaSeatList(Long arg0, String arg1, String arg2);

	ResultCode<List<ShowItemVo>> getShowItemList(Long arg0, Timestamp arg1);

	ResultCode<List<ShowItemVo>> getShowItemList(Long arg0, Date arg1);

	ResultCode<ShowItemVo> getShowItem(String arg0);

	ResultCode<List<ShowAreaVo>> getShowAreaList(String arg0);

	ResultCode<List<ShowItemPriceVo>> getShowItemPriceList(String arg0);

	ResultCode<List<ShowItemPackPriceVo>> getShowItemPackPriceList(String arg0);

	ResultCode<List<ShowPriceVo>> getShowPriceList(String arg0);

	ResultCode<List<ShowPackPriceVo>> getShowPackPriceList(String arg0);

	ResultCode<List<ShowSeatVo>> getShowSeatList(String arg0);
}