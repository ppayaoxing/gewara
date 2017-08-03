package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.BeanUtil;

public class DramaCloseRuleVo  extends BaseVo{
	private static final long serialVersionUID = -1337926425282216885L;
	public static final String RULETYPE_DPI = "dpi";			//场次
	public static final String RULETYPE_DRAMA = "drama";		//演出项目
	public static final String RULETYPE_CITY = "city";			//城市
	public static final String RULETYPE_SEATTYPE = "seattype";	//价格类型
	public static final String RULETYPE_ROOMNUM = "roomnum";	//区域
	public static final String MATCH_INCLUDE = "include";		//包含
	public static final String MATCH_EXCLUDE = "exclude";		//排除
	private Long id;
	private String ruletype;			//规则类型：只限项目、场次、价格、区域
	private String partnerids;			//商家ID
	private String dramaids;			//演出ID：不开放项目
	private String seattypes;			//价格类型：不开放价格
	private String roomnums;			//区域序号：不开放区域
	private String dpids;				//场次ID：不开放场次
	private String citys;				//城市代码：不开放场次
	private String pmatch;				//partner match model 包含还是排除商家 
	private String dmatch;				//drama match model 包含还是排除项目
	private String imatch;				//dpi match model 包含还是排除场次
	private String smatch;				//seattype match model 包含还是排除价格
	private String rmatch;				//roomnum match model 包含还是排除区域
	private String cmatch;				//city match model 包含还是排除城市
	private Timestamp opentime;			//开始时间
	private Timestamp closetime;		//结束时间
	private String description;			//屏蔽描述
	private Timestamp updatetime;		//更新时间
	@Override
	public Serializable realId() {
		return id;
	}
	public String getPartnerids() {
		return partnerids;
	}
	public void setPartnerids(String partnerids) {
		this.partnerids = partnerids;
	}
	public Timestamp getOpentime() {
		return opentime;
	}
	public void setOpentime(Timestamp opentime) {
		this.opentime = opentime;
	}
	public Timestamp getClosetime() {
		return closetime;
	}
	public void setClosetime(Timestamp closetime) {
		this.closetime = closetime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRuletype() {
		return ruletype;
	}
	public void setRuletype(String ruletype) {
		this.ruletype = ruletype;
	}
	public String getPmatch() {
		return pmatch;
	}
	public void setPmatch(String pmatch) {
		this.pmatch = pmatch;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public String getDramaids() {
		return dramaids;
	}
	public void setDramaids(String dramaids) {
		this.dramaids = dramaids;
	}
	public String getSeattypes() {
		return seattypes;
	}
	public void setSeattypes(String seattypes) {
		this.seattypes = seattypes;
	}
	public String getRoomnums() {
		return roomnums;
	}
	public void setRoomnums(String roomnums) {
		this.roomnums = roomnums;
	}
	public String getDpids() {
		return dpids;
	}
	public void setDpids(String dpids) {
		this.dpids = dpids;
	}
	public String getDmatch() {
		return dmatch;
	}
	public void setDmatch(String dmatch) {
		this.dmatch = dmatch;
	}
	public String getSmatch() {
		return smatch;
	}
	public void setSmatch(String smatch) {
		this.smatch = smatch;
	}
	public String getRmatch() {
		return rmatch;
	}
	public void setRmatch(String rmatch) {
		this.rmatch = rmatch;
	}
	public String getImatch() {
		return imatch;
	}
	public void setImatch(String imatch) {
		this.imatch = imatch;
	}
	public String getCitys() {
		return citys;
	}
	public void setCitys(String citys) {
		this.citys = citys;
	}
	public String getCmatch() {
		return cmatch;
	}
	public void setCmatch(String cmatch) {
		this.cmatch = cmatch;
	}
	public boolean matchPartner(Long partnerid) {
		boolean matchPartner = StringUtils.equals(partnerids, "000000");
		if(!matchPartner){
			List<Long> pidList = BeanUtil.getIdList(partnerids, ",");
			matchPartner = pidList.contains(partnerid);
		}
		return StringUtils.equals(pmatch, MATCH_EXCLUDE)?!matchPartner:matchPartner;
	}
	public boolean matchDrama(Long dramaid) {
		if(StringUtils.isBlank(dramaids)) return false;
		List<Long> dramaidList = BeanUtil.getIdList(dramaids, ",");
		boolean match = dramaidList.contains(dramaid);
		return StringUtils.equals(dmatch, MATCH_EXCLUDE)?!match:match;
	}
	public boolean matchCity(String citycode) {
		if(StringUtils.isBlank(citys)) return false;
		String[] idList = citys.split(",");
		List<String> cityList = Arrays.asList(idList);
		boolean match = cityList.contains(citycode);
		return StringUtils.equals(cmatch, MATCH_EXCLUDE)?!match:match;
	}
	public boolean matchDpid(Long dpid) {
		if(StringUtils.isBlank(dpids)) return false;
		List<Long> dpidList = BeanUtil.getIdList(dpids, ",");
		boolean match = dpidList.contains(dpid);
		return StringUtils.equals(imatch, MATCH_EXCLUDE)?!match:match;
	}
	public boolean matchRoomnum(Long dpid, String roomnum) {
		if(StringUtils.isBlank(roomnums)) return false;
		boolean match = matchArea(roomnum);
		if(StringUtils.isBlank(dpids)) return match;
		boolean match2 = matchDpid(dpid);
		return match2&match;
	}
	public boolean matchSeattype(Long dpid, String seattype) {
		if(StringUtils.isBlank(seattypes)) return false;
		boolean match = matchPrice(seattype);
		if(StringUtils.isBlank(dpids)) return match;
		boolean match2 = matchDpid(dpid);
		return match2&match;
	}
	public boolean matchArea(String roomnum) {
		String[] rooms = StringUtils.split(roomnums, ",");
		List<String> roomnumList = Arrays.asList(rooms);
		boolean match = roomnumList.contains(roomnum);
		return StringUtils.equals(rmatch, MATCH_EXCLUDE)?!match:match;
	}
	private boolean matchPrice(String seattype){
		String[] seats = StringUtils.split(seattypes, ",");
		List<String> seattypeList = Arrays.asList(seats);
		boolean match = seattypeList.contains(seattype);
		return StringUtils.equals(smatch, MATCH_EXCLUDE)?!match:match;
	}
}
