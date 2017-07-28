/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.BeanUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class DramaCloseRuleVo extends BaseVo {
	private static final long serialVersionUID = -1337926425282216885L;
	public static final String RULETYPE_DPI = "dpi";
	public static final String RULETYPE_DRAMA = "drama";
	public static final String RULETYPE_CITY = "city";
	public static final String RULETYPE_SEATTYPE = "seattype";
	public static final String RULETYPE_ROOMNUM = "roomnum";
	public static final String MATCH_INCLUDE = "include";
	public static final String MATCH_EXCLUDE = "exclude";
	private Long id;
	private String ruletype;
	private String partnerids;
	private String dramaids;
	private String seattypes;
	private String roomnums;
	private String dpids;
	private String citys;
	private String pmatch;
	private String dmatch;
	private String imatch;
	private String smatch;
	private String rmatch;
	private String cmatch;
	private Timestamp opentime;
	private Timestamp closetime;
	private String description;
	private Timestamp updatetime;

	public Serializable realId() {
		return this.id;
	}

	public String getPartnerids() {
		return this.partnerids;
	}

	public void setPartnerids(String partnerids) {
		this.partnerids = partnerids;
	}

	public Timestamp getOpentime() {
		return this.opentime;
	}

	public void setOpentime(Timestamp opentime) {
		this.opentime = opentime;
	}

	public Timestamp getClosetime() {
		return this.closetime;
	}

	public void setClosetime(Timestamp closetime) {
		this.closetime = closetime;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRuletype() {
		return this.ruletype;
	}

	public void setRuletype(String ruletype) {
		this.ruletype = ruletype;
	}

	public String getPmatch() {
		return this.pmatch;
	}

	public void setPmatch(String pmatch) {
		this.pmatch = pmatch;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getDramaids() {
		return this.dramaids;
	}

	public void setDramaids(String dramaids) {
		this.dramaids = dramaids;
	}

	public String getSeattypes() {
		return this.seattypes;
	}

	public void setSeattypes(String seattypes) {
		this.seattypes = seattypes;
	}

	public String getRoomnums() {
		return this.roomnums;
	}

	public void setRoomnums(String roomnums) {
		this.roomnums = roomnums;
	}

	public String getDpids() {
		return this.dpids;
	}

	public void setDpids(String dpids) {
		this.dpids = dpids;
	}

	public String getDmatch() {
		return this.dmatch;
	}

	public void setDmatch(String dmatch) {
		this.dmatch = dmatch;
	}

	public String getSmatch() {
		return this.smatch;
	}

	public void setSmatch(String smatch) {
		this.smatch = smatch;
	}

	public String getRmatch() {
		return this.rmatch;
	}

	public void setRmatch(String rmatch) {
		this.rmatch = rmatch;
	}

	public String getImatch() {
		return this.imatch;
	}

	public void setImatch(String imatch) {
		this.imatch = imatch;
	}

	public String getCitys() {
		return this.citys;
	}

	public void setCitys(String citys) {
		this.citys = citys;
	}

	public String getCmatch() {
		return this.cmatch;
	}

	public void setCmatch(String cmatch) {
		this.cmatch = cmatch;
	}

	public boolean matchPartner(Long partnerid) {
		boolean matchPartner = StringUtils.equals(this.partnerids, "000000");
		if (!matchPartner) {
			List pidList = BeanUtil.getIdList(this.partnerids, ",");
			matchPartner = pidList.contains(partnerid);
		}

		return StringUtils.equals(this.pmatch, "exclude") ? !matchPartner : matchPartner;
	}

	public boolean matchDrama(Long dramaid) {
		if (StringUtils.isBlank(this.dramaids)) {
			return false;
		} else {
			List dramaidList = BeanUtil.getIdList(this.dramaids, ",");
			boolean match = dramaidList.contains(dramaid);
			return StringUtils.equals(this.dmatch, "exclude") ? !match : match;
		}
	}

	public boolean matchCity(String citycode) {
		if (StringUtils.isBlank(this.citys)) {
			return false;
		} else {
			String[] idList = this.citys.split(",");
			List cityList = Arrays.asList(idList);
			boolean match = cityList.contains(citycode);
			return StringUtils.equals(this.cmatch, "exclude") ? !match : match;
		}
	}

	public boolean matchDpid(Long dpid) {
		if (StringUtils.isBlank(this.dpids)) {
			return false;
		} else {
			List dpidList = BeanUtil.getIdList(this.dpids, ",");
			boolean match = dpidList.contains(dpid);
			return StringUtils.equals(this.imatch, "exclude") ? !match : match;
		}
	}

	public boolean matchRoomnum(Long dpid, String roomnum) {
		if (StringUtils.isBlank(this.roomnums)) {
			return false;
		} else {
			boolean match = this.matchArea(roomnum);
			if (StringUtils.isBlank(this.dpids)) {
				return match;
			} else {
				boolean match2 = this.matchDpid(dpid);
				return match2 & match;
			}
		}
	}

	public boolean matchSeattype(Long dpid, String seattype) {
		if (StringUtils.isBlank(this.seattypes)) {
			return false;
		} else {
			boolean match = this.matchPrice(seattype);
			if (StringUtils.isBlank(this.dpids)) {
				return match;
			} else {
				boolean match2 = this.matchDpid(dpid);
				return match2 & match;
			}
		}
	}

	public boolean matchArea(String roomnum) {
		String[] rooms = StringUtils.split(this.roomnums, ",");
		List roomnumList = Arrays.asList(rooms);
		boolean match = roomnumList.contains(roomnum);
		return StringUtils.equals(this.rmatch, "exclude") ? !match : match;
	}

	private boolean matchPrice(String seattype) {
		String[] seats = StringUtils.split(this.seattypes, ",");
		List seattypeList = Arrays.asList(seats);
		boolean match = seattypeList.contains(seattype);
		return StringUtils.equals(this.smatch, "exclude") ? !match : match;
	}
}