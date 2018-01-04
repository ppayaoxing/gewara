package com.gewara.api.gpticket.vo.ticket;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

public class ShowAreaVo extends BaseVo {
	private static final long serialVersionUID = 2546956596028166852L;
	
	private String saseqNo;				//partner + areaserial(TheatreSeatArea-->sellerseq)
	private String areaname;			//锟斤拷锟斤拷锟斤拷锟斤拷
	private String enname;				//锟斤拷锟斤拷英锟斤拷锟斤拷
	private String partner;				//锟斤拷锟斤拷锟斤拷锟斤拷识
	private String areaserial;			//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
	private String fieldserial;			//锟斤拷锟斤拷锟斤拷锟斤拷锟截憋拷锟�
	private String pseqno;				//锟斤拷锟斤拷锟斤拷锟斤拷锟轿憋拷锟�
	private Long theatreid;				//锟斤拷锟斤拷ID
	private Long dramaid;				//锟斤拷目ID
	private String fieldnum;			//锟斤拷锟斤拷锟斤拷锟�
	private String areanum;				//锟斤拷锟斤拷锟斤拷锟�
	private String siseqNo;				//锟斤拷锟轿憋拷锟�
	
	private String description;			//锟斤拷锟斤拷锟斤拷锟斤拷
	private String standing;			//锟角凤拷站票
	private Integer totalnum;				//站票/锟斤拷位锟斤拷锟斤拷锟斤拷
	private Integer limitnum;				//锟斤拷锟斤拷锟斤拷
	private Integer firstline;			//锟斤拷始锟斤拷
	private Integer firstrank;			//锟斤拷始锟斤拷
	private Integer linenum;			//锟斤拷锟斤拷锟�
	private Integer ranknum;			//锟斤拷锟竭讹拷
	private String hotzone;				//锟斤拷锟斤拷值
	
	private String status;				//状态锟斤拷锟斤拷锟矫★拷删锟斤拷
	private Timestamp createtime;		//锟斤拷锟斤拷时锟斤拷
	private Timestamp updatetime;		//锟斤拷锟斤拷时锟斤拷
	
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
		if(StringUtils.isBlank(stats)) {
            return false;
        }
		return StringUtils.equals(this.status, stats);
	}
}
