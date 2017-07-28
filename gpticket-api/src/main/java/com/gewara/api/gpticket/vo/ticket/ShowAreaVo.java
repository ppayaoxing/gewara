/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.vo.ticket;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class ShowAreaVo extends BaseVo {
	private static final long serialVersionUID = 2546956596028166852L;
	private String saseqNo;
	private String areaname;
	private String enname;
	private String partner;
	private String areaserial;
	private String fieldserial;
	private String pseqno;
	private Long theatreid;
	private Long dramaid;
	private String fieldnum;
	private String areanum;
	private String siseqNo;
	private String description;
	private String standing;
	private Integer totalnum;
	private Integer limitnum;
	private Integer firstline;
	private Integer firstrank;
	private Integer linenum;
	private Integer ranknum;
	private String hotzone;
	private String status;
	private Timestamp createtime;
	private Timestamp updatetime;

	public Serializable realId() {
		return this.saseqNo;
	}

	public String getSaseqNo() {
		return this.saseqNo;
	}

	public void setSaseqNo(String saseqNo) {
		this.saseqNo = saseqNo;
	}

	public String getName() {
		return this.areaname;
	}

	public String getAreaname() {
		return this.areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getEnname() {
		return this.enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	public String getPartner() {
		return this.partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getAreaserial() {
		return this.areaserial;
	}

	public void setAreaserial(String areaserial) {
		this.areaserial = areaserial;
	}

	public String getPseqno() {
		return this.pseqno;
	}

	public void setPseqno(String pseqno) {
		this.pseqno = pseqno;
	}

	public Long getTheatreid() {
		return this.theatreid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}

	public Long getDramaid() {
		return this.dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public String getFieldserial() {
		return this.fieldserial;
	}

	public void setFieldserial(String fieldserial) {
		this.fieldserial = fieldserial;
	}

	public String getFieldnum() {
		return this.fieldnum;
	}

	public void setFieldnum(String fieldnum) {
		this.fieldnum = fieldnum;
	}

	public String getAreanum() {
		return this.areanum;
	}

	public void setAreanum(String areanum) {
		this.areanum = areanum;
	}

	public String getSiseqNo() {
		return this.siseqNo;
	}

	public void setSiseqNo(String siseqNo) {
		this.siseqNo = siseqNo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStanding() {
		return this.standing;
	}

	public void setStanding(String standing) {
		this.standing = standing;
	}

	public Integer getTotalnum() {
		return this.totalnum;
	}

	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	public Integer getLimitnum() {
		return this.limitnum;
	}

	public void setLimitnum(Integer limitnum) {
		this.limitnum = limitnum;
	}

	public Integer getFirstline() {
		return this.firstline;
	}

	public void setFirstline(Integer firstline) {
		this.firstline = firstline;
	}

	public Integer getFirstrank() {
		return this.firstrank;
	}

	public void setFirstrank(Integer firstrank) {
		this.firstrank = firstrank;
	}

	public Integer getLinenum() {
		return this.linenum;
	}

	public void setLinenum(Integer linenum) {
		this.linenum = linenum;
	}

	public Integer getRanknum() {
		return this.ranknum;
	}

	public void setRanknum(Integer ranknum) {
		this.ranknum = ranknum;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public String getHotzone() {
		return this.hotzone;
	}

	public void setHotzone(String hotzone) {
		this.hotzone = hotzone;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public boolean hasStatus(String stats) {
		return StringUtils.isBlank(stats) ? false : StringUtils.equals(this.status, stats);
	}
}