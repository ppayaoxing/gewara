package com.gewara.ucenter.api.member;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.cmd.UsefulAddressVo;
import com.gewara.ucenter.vo.member.ExpressProvinceVo;
import com.gewara.ucenter.vo.member.MemberUsefulAddressVo;

/**
 * 快递相关信息查询
 */
public interface MemberUsefullVoService {

	ResultCode<MemberUsefulAddressVo> checkCreanteUsefulAddress(UsefulAddressVo userAddress);
	
	/**
	 * 根据id获取MemberUsefulAddressVo实例
	 * @param id
	 * @return
	 */
	ResultCode<MemberUsefulAddressVo> getMemberUsefulAddressById(Long id);
	/**
	 * 获取用户常用地址
	 * @param memberid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<MemberUsefulAddressVo>> getMemberUsefulAddressByMeberid(Long memberid, int from, int maxnum);
	/**
	 * 根据用户手机号获取常用地址
	 * @param mobile
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<MemberUsefulAddressVo>> getMemberUsefulAddressByMobile(String mobile, int from, int maxnum);
	/**
	 * 获取该快递方式下某一省份的邮费等信息
	 * @param expressid
	 * @param provincecode
	 * @return
	 */
	ResultCode<ExpressProvinceVo> getExpressProvince(String expressid, String provincecode);
	
	/**
	 * 获取该快递方式下所有省份的邮费等信息
	 * @param expressid
	 * @return
	 */
	ResultCode<List<ExpressProvinceVo>> getExpressProvinceList(String expressid);
	/**
	 * 创建收货地址
	 * @param usefulAddress
	 * @return
	 */
	ResultCode<MemberUsefulAddressVo> addOrUpdateUsefulAddress(UsefulAddressVo usefulAddress);
	/**
	 * 根据主键拿地址
	 * @param idList
	 * @return
	 */
	ResultCode<List<MemberUsefulAddressVo>> getMemberUsefulAddressByIdList(List<Long> idList);
	/**
	 * 用户删除地址
	 * @param id 地址id
	 * @param memberid 用户id
	 * @return
	 */
	ResultCode delOldAddress(Long id, Long memberid);
	/**
	 * 修改默认地址
	 * @param id	地址id
	 * @param memberid	用户id
	 * @param defaultAddress 状态
	 * @return
	 */
	ResultCode changeDefaultAddress(Long id, Long memberid, String defaultAddress);
	ResultCode<MemberUsefulAddressVo> saveMemberUsefulAddress(Long id, Long memberid, String realname, String provincecode, String provincename,
			String citycode, String cityname, String countycode, String countyname, String address, String mobile, String postalcode, String IDcard);
}
