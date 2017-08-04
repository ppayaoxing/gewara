package com.gewara.api.service.drama;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.cmd.order.OrderParamsVo;
import com.gewara.api.vo.order.BuyItemVo;
import com.gewara.api.vo.order.GewaOrderVo;
import com.gewara.api.vo.pay.OrderOtherVo;
import com.gewara.constant.OdiConstant;
import com.gewara.constant.Status;
import com.gewara.drama.vo.DisQuantityVo;
import com.gewara.drama.vo.DramaPlayItemVo;
import com.gewara.drama.vo.DramaVo;
import com.gewara.drama.vo.OpenDramaItemVo;
import com.gewara.drama.vo.OpenTheatreSeatVo;
import com.gewara.drama.vo.SellDramaSeatVo;
import com.gewara.drama.vo.TheatreFieldVo;
import com.gewara.drama.vo.TheatreSeatAreaVo;
import com.gewara.drama.vo.TheatreSeatPriceVo;
import com.gewara.drama.vo.TheatreVo;
import com.gewara.drama.vo.cmd.AreaSeatParamsVo;
import com.gewara.drama.vo.cmd.ItemSeatMapVo;
import com.gewara.model.drama.DisQuantity;
import com.gewara.model.drama.Drama;
import com.gewara.model.drama.DramaPlayItem;
import com.gewara.model.drama.OpenDramaItem;
import com.gewara.model.drama.OpenTheatreSeat;
import com.gewara.model.drama.SellDramaSeat;
import com.gewara.model.drama.Theatre;
import com.gewara.model.drama.TheatreField;
import com.gewara.model.drama.TheatreSeatArea;
import com.gewara.model.drama.TheatreSeatPrice;
import com.gewara.service.DaoService;
import com.gewara.service.drama.DpiManageService;
import com.gewara.service.drama.DramaOrderService;
import com.gewara.service.drama.DramaPlayItemService;
import com.gewara.service.drama.OpenDramaService;
import com.gewara.support.ErrorCode;
import com.gewara.untrans.drama.TheatreOperationService;
import com.gewara.util.VoCopyUtil;

public class DramaOrderVoServiceImpl implements DramaOrderVoService {

	@Autowired
	@Qualifier("daoService")
	private DaoService daoService;

	@Autowired
	@Qualifier("dramaPlayItemService")
	private DramaPlayItemService dramaPlayItemService;

	@Autowired
	@Qualifier("dramaOrderService")
	private DramaOrderService dramaOrderService;

	@Autowired
	@Qualifier("theatreOperationService")
	private TheatreOperationService theatreOperationService;

	@Autowired
	@Qualifier("dpiManageService")
	private DpiManageService dpiManageService;

	@Autowired
	@Qualifier("openDramaService")
	private OpenDramaService openDramaService;

	@Override
	public ResultCode<ItemSeatMapVo> getChooseSeat(AreaSeatParamsVo paramsVo) {
		ItemSeatMapVo seatMapVo = new ItemSeatMapVo();
		OpenDramaItem odi = daoService.getObjectByUkey(OpenDramaItem.class, "dpid", paramsVo.getItemid());
		if (odi == null)
			return ResultCode.getFailure("该场次不存在！");
		ResultCode<OpenDramaItemVo> odiCode = VoCopyUtil.copyProperties(OpenDramaItemVo.class, odi);
		seatMapVo.setOdi(odiCode.getRetval());
		DramaPlayItem item = daoService.getObject(DramaPlayItem.class, odi.getDpid());
		if (item == null)
			return ResultCode.getFailure("该场次不存在！");
		seatMapVo.setItem(VoCopyUtil.copyProperties(DramaPlayItemVo.class, item).getRetval());
		if (!odi.isOpenseat())
			return ResultCode.getFailure("非选座场次！");
		Theatre theatre = daoService.getObject(Theatre.class, odi.getTheatreid());
		seatMapVo.setTheatre(VoCopyUtil.copyProperties(TheatreVo.class, theatre).getRetval());
		Drama drama = daoService.getObject(Drama.class, odi.getDramaid());
		seatMapVo.setDrama(VoCopyUtil.copyProperties(DramaVo.class, drama).getRetval());
		TheatreField field = daoService.getObject(TheatreField.class, odi.getRoomid());
		if (field == null)
			return ResultCode.getFailure("该场区不存在！");
		seatMapVo.setField(VoCopyUtil.copyProperties(TheatreFieldVo.class, field).getRetval());
		if (!odi.isOpenseat())
			return ResultCode.getFailure("非选座场次！");
		List<TheatreSeatArea> seatAreaList = daoService.getObjectListByField(TheatreSeatArea.class, "dpid",
				item.getId());
		seatMapVo.setAreaList(VoCopyUtil.copyListProperties(TheatreSeatAreaVo.class, seatAreaList).getRetval());
		TheatreSeatArea seatArea = null;
		if (paramsVo.getAreaid() != null) {
			seatArea = daoService.getObject(TheatreSeatArea.class, paramsVo.getAreaid());
		} else {
			for (TheatreSeatArea theatreSeatArea : seatAreaList) {
				if (theatreSeatArea.hasStatus(Status.Y)) {
					seatArea = theatreSeatArea;
					break;
				}
			}
		}
		if (seatArea == null)
			return ResultCode.getFailure("场区不存在或被删除！");
		seatMapVo.setCurrentArea(VoCopyUtil.copyProperties(TheatreSeatAreaVo.class, seatArea).getRetval());

		ErrorCode<List<String>> remoteLockList = theatreOperationService.updateRemoteLockSeat(seatArea,
				OdiConstant.SECONDS_UPDATE_SEAT, true);
		if (!remoteLockList.isSuccess()) {
			// 先展览座位图
			String[] seatMap = dpiManageService.getAreaSeatMap(seatArea.getId());
			if (seatMap == null) {
				seatMapVo.setSeatMap(seatArea.getSeatmap());
			} else {
				seatMapVo.setSeatMap(seatMap[0]);
			}
		} else {
			seatMapVo.setConnect(true);
			seatMapVo.setRemoteLockList(remoteLockList.getRetval());
			List<OpenTheatreSeat> openSeatList = openDramaService.getOpenTheatreSeatListByDpid(odi.getDpid(),
					seatArea.getId());
			seatMapVo.setSeatList(VoCopyUtil.copyListProperties(OpenTheatreSeatVo.class, openSeatList).getRetval());
			List<SellDramaSeat> sellseatList = dramaOrderService.getSellDramaSeatList(odi.getDpid(), seatArea.getId());
			seatMapVo.setSellSeatList(VoCopyUtil.copyListProperties(SellDramaSeatVo.class, sellseatList).getRetval());
		}
		List<DisQuantity> disquanList = daoService.getObjectListByField(DisQuantity.class, "areaid", seatArea.getId());
		seatMapVo.setDisList(VoCopyUtil.copyListProperties(DisQuantityVo.class, disquanList).getRetval());
		List<TheatreSeatPrice> tspList2 = dramaPlayItemService.getTspList(item.getId(), seatArea.getId());
		seatMapVo.setPriceList(VoCopyUtil.copyListProperties(TheatreSeatPriceVo.class, tspList2).getRetval());
		return ResultCode.getSuccessReturn(seatMapVo);
	}

	@Override
	public ResultCode<List<GewaOrderVo>> getDramaOrderVoList(OrderParamsVo command, int from, int maxnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<BuyItemVo>> getItemList(Long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<GewaOrderVo> getDramaOrderVo(Long orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<GewaOrderVo> getLastUnpaidDramaOrder(Long memberid, String ukey, Long areaid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<String>> getDramaOrderSeatLabelList(Long orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<OrderOtherVo> getDramaOrderOtherData(Long orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode checkPriorizite(Long dramaid, Long memberid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode saveOrderPrintInfo(Long orderid, String remotePrintInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<Integer> saveOrderAddress(Long orderid, Long addressid) {
		// TODO Auto-generated method stub
		return null;
	}

}
