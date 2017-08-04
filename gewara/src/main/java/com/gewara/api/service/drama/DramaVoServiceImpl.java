package com.gewara.api.service.drama;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.dubbo.DramaVoService;
import com.gewara.drama.vo.DramaProfileVo;
import com.gewara.drama.vo.DramaRaidersVo;
import com.gewara.drama.vo.DramaVo;
import com.gewara.drama.vo.OpenDramaItemVo;
import com.gewara.drama.vo.TheatreVo;
//import com.gewara.api.vo.drama.DramaVo;
//import com.gewara.api.vo.drama.OpenDramaItemVo;
//import com.gewara.api.vo.drama.TheatreVo;
import com.gewara.model.drama.Drama;
import com.gewara.model.drama.OpenDramaItem;
import com.gewara.model.drama.Theatre;
import com.gewara.service.impl.BaseServiceImpl;
import com.gewara.util.VoCopyUtil;

public class DramaVoServiceImpl extends BaseServiceImpl implements DramaVoService {

	@Override

	// @Override
	public ResultCode<DramaVo> getDramaById(Long dramaid) {
		Drama drama = baseDao.getObject(Drama.class, dramaid);
		return VoCopyUtil.copyProperties(DramaVo.class, drama);
	}

	// @Override
	public ResultCode<TheatreVo> getTheatreVoById(Long theatreid) {
		Theatre theatre = baseDao.getObject(Theatre.class, theatreid);
		return VoCopyUtil.copyProperties(TheatreVo.class, theatre);
	}

	// @Override
	public ResultCode<OpenDramaItemVo> getOpenDramaItemVoById(Long dpid) {
		OpenDramaItem op = baseDao.getObject(OpenDramaItem.class, dpid);
		return VoCopyUtil.copyProperties(OpenDramaItemVo.class, op);
	}

	@Override
	public ResultCode<List<DramaVo>> getDramaList(Long placeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<DramaVo>> getDramaListByIdList(Long... id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<Boolean> getDramaBooking(Long dramaid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<Integer>> getDramaPriceListByDramaid(Long dramaid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<DramaVo>> getDramaListByUpdatetime(Timestamp updatetime, int from, int maxnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<DramaRaidersVo>> getDramaRaidersListByDramaid(Long dramaid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<DramaProfileVo> getDramaProfileByDramaid(Long dramaid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<DramaProfileVo>> getDramaProfileByDramaidList(Long... dramaids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<DramaVo>> getHotDrama(String citycode, String order, int from, int maxnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<DramaVo>> getDramaListByStarid(Long starid, boolean isCurrent, int from, int maxnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<Integer> getDramaCountByStarid(Long starid, boolean isCurrent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<DramaVo>> getFutureDramaList(String citycode, Date fromDate, int from, int maxnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<DramaVo> getDramaByName(String dramaName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<DramaVo>> getDramaListByName(String dramaName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<Long>> getDramaIdListByReserve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<DramaVo>> getDramaSomeDayCalendar(String citycode, Date someDay, int from, int maxnum) {
		// TODO Auto-generated method stub
		return null;
	}

}
