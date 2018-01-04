package com.gewara.drama.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.drama.constant.Status;

public class DramaProfileVo extends BaseVo {

	private static final long serialVersionUID = 2713318692410184246L;
	private Long dramaid;
	private String limittype;			//�������ͣ�ÿ�죬ÿ�����Σ���Ŀ���ڣ�
	private Integer limitnum;			//��������
	private String limitsite;			//����վ��:Web, Wap
	private String uniqueby;			//����Ψһ��ʶ
	private String itemid;				//���Ƴ���ID����
	private String opustype;			//��Ʒ����(Y��Ƶ)
	private String opuslink;
	private String reserve;				//�Ƿ��ԤԼ(Y,N)
	private String validorder;			//ԤԼ��֤����(Y,N)
	private Integer rmaxnum;			//���ο�ԤԼ�������
	private Integer rlimitnum;			//��ԤԼ����
	private Integer delayedday;			//�ӳ�����
	private Timestamp rstarttime;		//ԤԼ���ſ�ʼʱ��
	private Timestamp rendtime;			//ԤԼ���Ž���ʱ��
	private Date rstartdate;			//ԤԼ��ʼ����
	private String reserveexp;
	private String businessname;		//ԤԼ�����̻�����
	private String businessurl;			//ԤԼ�����̻���ַ
	private String remind;				//��Ʊ����
	private String remindcontent;		//��������
	private String remindtext;			//��������2
	private Timestamp remindtime;		//��Ʊ����ʱ��
	private Timestamp addtime;
	private Timestamp updatetime;

	private String unlimituser; 		//���������û�
	private String prioritize;			//���ȹ�
	private Timestamp pstarttime;
	private Timestamp pendtime;
	private String checkprice;			//ԤԼ��֤�۸�(Y,N)
	private String reserverlogo;		//ԤԼ����ͼ
	private String reservercolor;		//ԤԼ����ɫ
	private String sharepic;  			//��Ŀ����ͼƬ
	private String appTopPic;
	private String pcToText;
	private String pcToLink;
	private String wapToText;
	private String wapToLink;
	private String appToText;
	private String appToLink;
	private String sellOutMark;

	private String wplogo;				//����������logo
	private String origin;
	private String autoseat;			//Y/N
	private String secondtype;			//�ڶ�����
	
	private String domain;		//����������
	private String shortUrl;	//�����ӷ��ʵ�ַ
	private Integer remnantnum;		//��Ʊ������������
	private String remnantnotice;	//��Ʊ�����İ�
	
	@Override
	public Serializable realId() {
		return dramaid;
	}

	public String getWpLimg(){
		if(StringUtils.isBlank(wplogo)) {
            return "img/default_logo.png";
        }
		return wplogo;
	}
	public Long getDramaid() {
		return dramaid;
	}

	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}

	public String getLimittype() {
		return limittype;
	}

	public void setLimittype(String limittype) {
		this.limittype = limittype;
	}

	public Integer getLimitnum() {
		return limitnum;
	}

	public void setLimitnum(Integer limitnum) {
		this.limitnum = limitnum;
	}

	public String getLimitsite() {
		return limitsite;
	}

	public void setLimitsite(String limitsite) {
		this.limitsite = limitsite;
	}

	public String getUniqueby() {
		return uniqueby;
	}

	public void setUniqueby(String uniqueby) {
		this.uniqueby = uniqueby;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getOpustype() {
		return opustype;
	}

	public void setOpustype(String opustype) {
		this.opustype = opustype;
	}

	public String getOpuslink() {
		return opuslink;
	}

	public void setOpuslink(String opuslink) {
		this.opuslink = opuslink;
	}

	public String getReserve() {
		return reserve;
	}

	public void setReserve(String reserve) {
		this.reserve = reserve;
	}

	public String getValidorder() {
		return validorder;
	}

	public void setValidorder(String validorder) {
		this.validorder = validorder;
	}

	public Integer getRmaxnum() {
		return rmaxnum;
	}

	public void setRmaxnum(Integer rmaxnum) {
		this.rmaxnum = rmaxnum;
	}

	public Integer getRlimitnum() {
		return rlimitnum;
	}

	public void setRlimitnum(Integer rlimitnum) {
		this.rlimitnum = rlimitnum;
	}

	public Integer getDelayedday() {
		return delayedday;
	}

	public void setDelayedday(Integer delayedday) {
		this.delayedday = delayedday;
	}

	public Timestamp getRstarttime() {
		return rstarttime;
	}

	public void setRstarttime(Timestamp rstarttime) {
		this.rstarttime = rstarttime;
	}

	public Timestamp getRendtime() {
		return rendtime;
	}

	public void setRendtime(Timestamp rendtime) {
		this.rendtime = rendtime;
	}

	public Date getRstartdate() {
		return rstartdate;
	}

	public void setRstartdate(Date rstartdate) {
		this.rstartdate = rstartdate;
	}

	public String getReserveexp() {
		return reserveexp;
	}

	public void setReserveexp(String reserveexp) {
		this.reserveexp = reserveexp;
	}

	public String getBusinessname() {
		return businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	public String getBusinessurl() {
		return businessurl;
	}

	public void setBusinessurl(String businessurl) {
		this.businessurl = businessurl;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getUnlimituser() {
		return unlimituser;
	}

	public void setUnlimituser(String unlimituser) {
		this.unlimituser = unlimituser;
	}

	public String getPrioritize() {
		return prioritize;
	}

	public void setPrioritize(String prioritize) {
		this.prioritize = prioritize;
	}

	public Timestamp getPstarttime() {
		return pstarttime;
	}

	public void setPstarttime(Timestamp pstarttime) {
		this.pstarttime = pstarttime;
	}

	public Timestamp getPendtime() {
		return pendtime;
	}

	public void setPendtime(Timestamp pendtime) {
		this.pendtime = pendtime;
	}

	public String getRemind() {
		return remind;
	}

	public void setRemind(String remind) {
		this.remind = remind;
	}

	public String getRemindcontent() {
		return remindcontent;
	}

	public void setRemindcontent(String remindcontent) {
		this.remindcontent = remindcontent;
	}

	public String getRemindtext() {
		return remindtext;
	}

	public void setRemindtext(String remindtext) {
		this.remindtext = remindtext;
	}

	public Timestamp getRemindtime() {
		return remindtime;
	}

	public void setRemindtime(Timestamp remindtime) {
		this.remindtime = remindtime;
	}

	public String getCheckprice() {
		return checkprice;
	}

	public void setCheckprice(String checkprice) {
		this.checkprice = checkprice;
	}
	public String getReserverlogo() {
		return reserverlogo;
	}

	public void setReserverlogo(String reserverlogo) {
		this.reserverlogo = reserverlogo;
	}

	public String getReservercolor() {
		return reservercolor;
	}

	public void setReservercolor(String reservercolor) {
		this.reservercolor = reservercolor;
	}
	public String getSharepic() {
		return sharepic;
	}

	public void setSharepic(String sharepic) {
		this.sharepic = sharepic;
	}

	public String getAppTopPic() {
		return appTopPic;
	}

	public void setAppTopPic(String appTopPic) {
		this.appTopPic = appTopPic;
	}

	public String getPcToText() {
		return pcToText;
	}

	public void setPcToText(String pcToText) {
		this.pcToText = pcToText;
	}

	public String getPcToLink() {
		return pcToLink;
	}

	public void setPcToLink(String pcToLink) {
		this.pcToLink = pcToLink;
	}

	public String getWapToText() {
		return wapToText;
	}

	public void setWapToText(String wapToText) {
		this.wapToText = wapToText;
	}

	public String getWapToLink() {
		return wapToLink;
	}

	public void setWapToLink(String wapToLink) {
		this.wapToLink = wapToLink;
	}

	public String getAppToText() {
		return appToText;
	}

	public void setAppToText(String appToText) {
		this.appToText = appToText;
	}

	public String getAppToLink() {
		return appToLink;
	}

	public void setAppToLink(String appToLink) {
		this.appToLink = appToLink;
	}

	public String getSellOutMark() {
		return sellOutMark;
	}

	public void setSellOutMark(String sellOutMark) {
		this.sellOutMark = sellOutMark;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getWplogo() {
		return wplogo;
	}

	public void setWplogo(String wplogo) {
		this.wplogo = wplogo;
	}

	public String getAutoseat() {
		return autoseat;
	}

	public void setAutoseat(String autoseat) {
		this.autoseat = autoseat;
	}
	
	public boolean isAuto() {
		return StringUtils.equals(this.autoseat, Status.Y);
	}
	
	public String getSecondtype() {
		return secondtype;
	}

	public void setSecondtype(String secondtype) {
		this.secondtype = secondtype;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public Integer getRemnantnum() {
		return remnantnum;
	}

	public void setRemnantnum(Integer remnantnum) {
		this.remnantnum = remnantnum;
	}

	public String getRemnantnotice() {
		return remnantnotice;
	}

	public void setRemnantnotice(String remnantnotice) {
		this.remnantnotice = remnantnotice;
	}
	
}
