package com.gewara.api.gworder.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.cons.OpiConstant;
import com.gewara.util.DateUtil;
import com.gewara.util.JsonUtils;
import com.gewara.util.StringUtil;

public class OrderMpiVo extends BaseVo {
	private static final long serialVersionUID = 7825970506234199792L;
	
	protected Long id;			//����ID
	protected Long mpid;			//
	protected Long movieid;		//ӰƬID
	protected Long cinemaid;		//ӰԺID
	protected String language;	//����
	protected Date playdate;		//��ӳ����
	protected String showtime;	//��ӳʱ��
	protected Integer price;		//ӰԺ��
	protected Integer lowest;		//���Ʊ��
	protected Integer gewaprice;	//��������
	protected String edition;		//�汾
	protected Long roomid;		//Ӱ��
	protected String roomnum;
	protected String opentype;	//��������
	protected String citycode;	//����
	protected String seqNo;		//�ⲿ����ID
	protected Long batch;				//���α�ʶ
	protected Timestamp createtime;	//����ʱ��
	protected String openStatus;		//����״̬��init����ʼ״̬��open���ѿ��ţ�close���Ժ�Ҳ������
	protected String mpitype;			//�������� filmfest ��Ӱ�ڳ���
	
	//����Ϊopi����
	protected Long openid;			//					------>ԭopi���id
	protected String moviename;
	protected String cinemaname;
	protected String roomname;
	protected Timestamp playtime;   //				------>ԭopi���playtime
	protected Integer costprice; 		//�ɱ��ۣ�Ʊ��ۣ�
	protected Integer fee;				//�����
	protected String status;			//״̬����Ԥ��������Ԥ���� Y[��Ԥ��]N[����Ԥ��]D[ɾ��]
	protected String partner;			//������鿪��״̬��Y���⿪��,N�����⿪��
	protected Timestamp opentime;		//���Ź�Ʊʱ��
	protected Timestamp closetime;		//�رչ�Ʊʱ��
	protected String elecard;			//1)���õĵ���ȯ����ABC��2) M��ʾ�����̼������Żݻ

	protected String spflag;			//�ؼۻ��ʶ
	
	protected String buylimit;			//�����������ƣ�1,2,3,4,5
	protected Long topicid;				//ȡƱ����
	protected String dayotime;			//day open time ÿ�տ���ʱ��
	protected String dayctime;			//day close time ÿ�չر�ʱ��
	protected Integer givepoint;		//�����֣�����ʾ���ӻ��֣�����ʾ������
	protected String expressid;			//��ݷ�ʽ
	protected Integer lockminute;
	protected Integer maxseat;
	protected String roomtype;
	protected String otherinfo;
	protected String remark;			//��ע
	protected Timestamp updatetime;	//����ʱ��
	protected Integer seatnum;		//��λ����
	protected Integer asellnum;		//allow ����������
	protected Integer gsellnum;		//Gewa������
	protected Integer csellnum;		//ӰԺ����
	protected Integer locknum;		//Gewa������
	
	public OrderMpiVo(){}
	@Override
	public Serializable realId() {
		return mpid;
	}
	
	public boolean isHfh() {
		return !hasGewara() && StringUtils.isNotBlank(seqNo);
	}
	
	public boolean isValid(){
		return StringUtils.isNotBlank(roomname) && this.playdate != null && StringUtils.isNotBlank(this.showtime);
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPlaydate() {
		return playdate;
	}

	public void setPlaydate(Date playdate) {
		this.playdate = playdate;
	}

	public String getShowtime() {
		return showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getBatch() {
		return batch;
	}
	public void setBatch(Long batch) {
		this.batch = batch;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Long getRoomid() {
		return roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}

	public Long getMovieid() {
		return movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public Long getCinemaid() {
		return cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public Integer getGewaprice() {
		return gewaprice;
	}
	public void setGewaprice(Integer gewaprice) {
		this.gewaprice = gewaprice;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public Integer getLowest() {
		return lowest;
	}
	public void setLowest(Integer lowest) {
		this.lowest = lowest;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public String getOpenStatus() {
		return openStatus;
	}
	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public String getOpentype() {
		return opentype;
	}
	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}
	
	public String getMpitype() {
		return mpitype;
	}
	public void setMpitype(String mpitype) {
		this.mpitype = mpitype;
	}
	
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	
	public String getTimeStr(){
		return DateUtil.format(getPlaytime(),"HH:mm");
	}

	public Long getOpenid() {
		return openid;
	}

	public void setOpenid(Long openid) {
		this.openid = openid;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getCinemaname() {
		return cinemaname;
	}

	public void setCinemaname(String cinemaname) {
		this.cinemaname = cinemaname;
	}

	public String getRoomname() {
		return roomname;
	}
	public String getPlayroom() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public Integer getCostprice() {
		return costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
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

	public String getElecard() {
		return elecard;
	}

	public void setElecard(String elecard) {
		this.elecard = elecard;
	}

	public String getSpflag() {
		return spflag;
	}

	public void setSpflag(String spflag) {
		this.spflag = spflag;
	}

	public String getBuylimit() {
		return buylimit;
	}

	public void setBuylimit(String buylimit) {
		this.buylimit = buylimit;
	}

	public Long getTopicid() {
		return topicid;
	}

	public void setTopicid(Long topicid) {
		this.topicid = topicid;
	}

	public String getDayotime() {
		return dayotime;
	}

	public void setDayotime(String dayotime) {
		this.dayotime = dayotime;
	}

	public String getDayctime() {
		return dayctime;
	}

	public void setDayctime(String dayctime) {
		this.dayctime = dayctime;
	}

	public Integer getGivepoint() {
		return givepoint;
	}

	public void setGivepoint(Integer givepoint) {
		this.givepoint = givepoint;
	}

	public String getExpressid() {
		return expressid;
	}

	public void setExpressid(String expressid) {
		this.expressid = expressid;
	}

	public Integer getLockminute() {
		return lockminute;
	}

	public void setLockminute(Integer lockminute) {
		this.lockminute = lockminute;
	}

	public Integer getMaxseat() {
		return maxseat;
	}

	public void setMaxseat(Integer maxseat) {
		this.maxseat = maxseat;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public Integer getSeatnum() {
		return seatnum;
	}

	public void setSeatnum(Integer seatnum) {
		this.seatnum = seatnum;
	}

	public Integer getAsellnum() {
		return asellnum;
	}

	public void setAsellnum(Integer asellnum) {
		this.asellnum = asellnum;
	}

	public Integer getGsellnum() {
		return gsellnum;
	}

	public void setGsellnum(Integer gsellnum) {
		this.gsellnum = gsellnum;
	}

	public Integer getCsellnum() {
		return csellnum;
	}

	public void setCsellnum(Integer csellnum) {
		this.csellnum = csellnum;
	}

	public Integer getLocknum() {
		return locknum;
	}

	public void setLocknum(Integer locknum) {
		this.locknum = locknum;
	}

	public String getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}
	public Long getMpid(){
		if(this.mpid ==null){
			return id;
		}
		return mpid;
	}
	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}
	
	public Timestamp getPlaytime() {
		if(playtime==null){
			return DateUtil.parseTimestamp(DateUtil.formatDate(playdate) + " " + showtime + ":00");
		}
		return playtime;
	}
	public void setPlaytime(Timestamp playtime) {
		this.playtime = playtime;
	}
	public boolean isOpenToPartner(){
		return hasOpenid() && "Y".equals(partner);
	}
	public boolean isOpenPointPay(){
		return hasOpenid() && !StringUtils.contains(this.elecard, "N");
	}
	public boolean isOpenCardPay(){
		return hasOpenid() && StringUtils.containsAny(this.elecard, "ABD");
	}
	public boolean isDisCountPay(){
		return hasOpenid() && StringUtils.contains(this.elecard, "M");
	}
	public String seatAmountStatus(){
		if(seatnum==null || asellnum==null || gsellnum==null || csellnum==null || locknum==null){
			return "2";
		}
		Integer remain = this.seatnum - this.gsellnum - this.csellnum - this.locknum;
		if(remain == 0) {
            return "0";
        }
		if(0 < remain && remain < 10) {
			return "1";
		}
		return "2";
	}
	public String getSeatStatus(){
		if(!hasOpenid()){
			return "";
		}
		if(seatnum==null || asellnum==null ||  gsellnum==null || csellnum==null || locknum==null){
			return "ѡ����Ʊ";
		}
		/*Integer remain = this.seatnum - this.gsellnum - this.csellnum - this.locknum;
		if(remain <= 0) {
			return "�����ˡ�";
		}else if(remain < 10) {
			return "��λ����";
		}*/
		Timestamp curtime = DateUtil.getCurFullTimestamp();
		String resText = "ѡ����Ʊ";
		if(opentime!=null){
			if(opentime.after(curtime) && DateUtil.formatDate(curtime).equals(DateUtil.formatDate(opentime))){
				resText = DateUtil.format(opentime, "HH:mm")+"��Ʊ";
			}
		}
		return resText;
	}
	public boolean hasGewara(){
		return StringUtils.equals(opentype, OpiConstant.OPEN_GEWARA);
	}
	
	public boolean hasOpentype(String type){
		if(StringUtils.isBlank(type)) {
            return false;
        }
		return StringUtils.equals(this.opentype, type);
	}
	
	public boolean hasOpenStatus(String statuss){
		return StringUtils.equals(this.openStatus, statuss);
	}
	public boolean isUnOpenToGewa(){
		return StringUtils.contains(otherinfo, OpiConstant.UNOPENGEWA);
	}
	public boolean isUnShowToGewa(){
		return StringUtils.contains(otherinfo, OpiConstant.UNSHOWGEWA) || StringUtils.contains(otherinfo, OpiConstant.UNOPENGEWA) || StringUtils.contains(otherinfo, OpiConstant.MPITYPE_BAOCHANG);
	}
	public boolean hasOpenid(){
		return this.openid!=null;
	}
	public boolean isOrder(){
		if(!hasOpenid()){
			return false;
		}
		Timestamp curtime = new Timestamp(System.currentTimeMillis());
		String time = DateUtil.format(curtime, "HHmm");
		boolean open = getPlaytime().after(curtime) && opentime.before(curtime) 
			&& closetime.after(curtime) && status.equals(OpiConstant.STATUS_BOOK) 
			&& StringUtil.between(time, dayotime, dayctime);
		
		return open;
	}
	public boolean isShowOrder(){
		if(!hasOpenid()){
			return false;
		}
		Timestamp curtime = new Timestamp(System.currentTimeMillis());
		if(opentime.after(curtime) && !DateUtil.formatDate(curtime).equals(DateUtil.formatDate(opentime))){
			return false;
		}
		String time = DateUtil.format(curtime, "HHmm");
		boolean open = getPlaytime().after(curtime) 
			&& closetime.after(curtime) && status.equals(OpiConstant.STATUS_BOOK) 
			&& StringUtil.between(time, dayotime, dayctime);
		
		return open;
	}
	public Timestamp getFullPlaytime() {
		if(openid==null){
			return DateUtil.parseTimestamp(DateUtil.formatDate(playdate) + " " + showtime + ":00");
		}
		return playtime;
	}
	//����ķ���ֻ�ں�̨��
	public boolean isOpen(){
		if(hasOpenid()){
			return opentime!=null && opentime.before(new Timestamp(System.currentTimeMillis()));
		}
		return false;
	}
	
	public boolean isBooking(){
		if(hasOpenid()){
			return StringUtils.equals(status, OpiConstant.STATUS_BOOK) && !isClosed();
		}
		return false;
	}
	
	public boolean isExpired(){
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		if(hasOpenid()){
			return playtime!=null && playtime.before(cur) || StringUtils.equals(status, OpiConstant.STATUS_PAST);
		}
		return getPlaytime().before(cur);
	}
	public boolean isClosed(){
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		if(hasOpenid()){
			return closetime==null || cur.after(closetime);
		}
		return cur.before(getPlaytime());
	}
	public boolean hasOpi(){
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		if(hasOpenid()){
			if(closetime.before(cur) || (opentime.after(cur) && !DateUtil.formatDate(cur).equals(DateUtil.formatDate(opentime)))
					|| !StringUtils.equals(status, OpiConstant.STATUS_BOOK) || (gsellnum != null && asellnum != null && gsellnum>=asellnum)){
				return false;
			}
			return true;
		}
		return false;
	}
	public Integer gainServiceFee(){
		if(gewaprice==null || costprice==null){
			return 0;
		}
		int serviceFee=gewaprice-costprice;
		return serviceFee<0?0:serviceFee;
	}
	public Integer getServicefee(){
		return gainServiceFee();
	}
	
	public int gainLockSeat(){
		if(hasOpentype(OpiConstant.OPEN_MTX)
			|| hasOpentype(OpiConstant.OPEN_JY)
			|| hasOpentype(OpiConstant.OPEN_NJY)
			|| hasOpentype(OpiConstant.OPEN_MJY)
			|| hasOpentype(OpiConstant.OPEN_WD)
			|| hasOpentype(OpiConstant.OPEN_WD2)
			|| hasOpentype(OpiConstant.OPEN_GPTBS)){
			return OpiConstant.MAXSEAT_PER_ORDER_PNX;
		}
		return OpiConstant.MAXSEAT_PER_ORDER;
	}
	
	public int gainLockMinute(){
		return OpiConstant.MAX_MINUTS_TICKETS;
	}
	
	public boolean hasRefund(){
		Map<String, String> map = JsonUtils.readJsonToMap(otherinfo);
		return StringUtils.equals(map.get("isRefund"), "Y");
	}
	public boolean hasBaoChang(){
		return StringUtils.contains(otherinfo, OpiConstant.MPITYPE_BAOCHANG);
	}
}
