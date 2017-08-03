package com.gewara.api.gpticket.vo.ticket;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

public class ShowAreaVo extends BaseVo {
	private static final long serialVersionUID = 2546956596028166852L;
	
	private String saseqNo;				//partner + areaserial(TheatreSeatArea-->sellerseq)
	private String areaname;			//场区名称
	private String enname;				//场区英文名
	private String partner;				//第三方标识
	private String areaserial;			//第三方场区编号
	private String fieldserial;			//第三方场地编号
	private String pseqno;				//第三方场次编号
	private Long theatreid;				//场馆ID
	private Long dramaid;				//项目ID
	private String fieldnum;			//场地序号
	private String areanum;				//场区序号
	private String siseqNo;				//场次编号
	
	private String description;			//区域描述
	private String standing;			//是否站票
	private Integer totalnum;				//站票/座位的总量
	private Integer limitnum;				//限制数
	private Integer firstline;			//起始行
	private Integer firstrank;			//起始列
	private Integer linenum;			//表格宽度
	private Integer ranknum;			//表格高度
	private String hotzone;				//座标值
	
	private String status;				//状态：可用、删除
	private Timestamp createtime;		//创建时间
	private Timestamp updatetime;		//更新时间
	
	public ShowAreaVo(){}

	@Override
	public Serializable realId() {
		return saseqNo;
	}
	
	public String getSaseqNo() {
		return saseqNo;
	}

	public void setSaseqNo(String saseqNo) {
		this.saseqNo = saseqNo;
	}

	public String getName(){
		return areaname;
	}
	
	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getEnname() {
		return enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getAreaserial() {
		return areaserial;
	}

	public void setAreaserial(String areaserial) {
		this.areaserial = areaserial;
	}

	public String getPseqno() {
		return pseqno;
	}

	public void setPseqno(String pseqno) {
		this.pseqno = pseqno;
	}

	public Long getTheatreid() {
		return theatreid;
	}

	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}

	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public String getFieldserial() {
		return fieldserial;
	}

	public void setFieldserial(String fieldserial) {
		this.fieldserial = fieldserial;
	}

	public String getFieldnum() {
		return fieldnum;
	}

	public void setFieldnum(String fieldnum) {
		this.fieldnum = fieldnum;
	}

	public String getAreanum() {
		return areanum;
	}

	public void setAreanum(String areanum) {
		this.areanum = areanum;
	}

	public String getSiseqNo() {
		return siseqNo;
	}

	public void setSiseqNo(String siseqNo) {
		this.siseqNo = siseqNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStanding() {
		return standing;
	}

	public void setStanding(String standing) {
		this.standing = standing;
	}

	public Integer getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	public Integer getLimitnum() {
		return limitnum;
	}

	public void setLimitnum(Integer limitnum) {
		this.limitnum = limitnum;
	}

	public Integer getFirstline() {
		return firstline;
	}

	public void setFirstline(Integer firstline) {
		this.firstline = firstline;
	}

	public Integer getFirstrank() {
		return firstrank;
	}

	public void setFirstrank(Integer firstrank) {
		this.firstrank = firstrank;
	}

	public Integer getLinenum() {
		return linenum;
	}

	public void setLinenum(Integer linenum) {
		this.linenum = linenum;
	}

	public Integer getRanknum() {
		return ranknum;
	}

	public void setRanknum(Integer ranknum) {
		this.ranknum = ranknum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public String getHotzone() {
		return hotzone;
	}

	public void setHotzone(String hotzone) {
		this.hotzone = hotzone;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public boolean hasStatus(String stats){
		if(StringUtils.isBlank(stats)) return false;
		return StringUtils.equals(this.status, stats);
	}
}
