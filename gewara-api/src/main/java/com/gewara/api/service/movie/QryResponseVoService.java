package com.gewara.api.service.movie;

import java.util.List;

import com.gewara.api.vo.ResultCode;

public interface QryResponseVoService {
	ResultCode removeLockSeatFromQryResponse(Long mpid, String secid, List<String> lockedSeatStrList);
	ResultCode addLockSeatToQryResponse(Long mpid, String secid, List<String> lockedSeatStrList);
	/**
	 * @param mpid
	 * @param opentype
	 * @param secid
	 * @param seqNo
	 * @param expireSeconds
	 * @param refresh
	 * @return
	 */
	ResultCode<List<String>> updateRemoteLockSeat1(Long mpid, String opentype, String secid, String seqNo);
	
	/**
	 * @param mpid
	 * @param opentype
	 * @param secid
	 * @param seqNo
	 * @param expireSeconds
	 * @param refresh
	 * @return
	 */
	ResultCode<List<String>> updateRemoteLockSeat2(Long mpid, String opentype, String secid, String seqNo, int expireSeconds, boolean refresh);
}
