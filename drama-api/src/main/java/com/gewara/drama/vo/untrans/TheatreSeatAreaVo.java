package com.gewara.drama.vo.untrans;

import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;
import com.gewara.drama.constant.OdiConstant;
import com.gewara.drama.constant.Status;
import com.gewara.model.BaseObject;
import com.gewara.support.LocalCachable;
import com.gewara.util.DateUtil;

public class TheatreSeatAreaVo extends BaseObject implements LocalCachable {
	private static final long serialVersionUID = 7040516605857737934L;
	private Long id; //
	private Long dpid; // ����ID
	private Long theatreid;
	private Long dramaid;
	private String areaname; // ��������
	private String enname; //
	private String seller; // ����:��ӦDramaPlayItem seller
	private String sellerseq; // �����ţ�ShowArea-->saseqNo��
	private String fieldnum; // �������
	private String roomnum; // �������
	private String description; // ��������
	private String standing; // �Ƿ�վƱ
	private Integer total; // վƱ/��λ����
	private Integer limitnum; // ������
	private Integer firstline; // ��ʼ��
	private Integer firstrank; // ��ʼ��
	private Integer linenum; // �����
	private Integer ranknum; // ���߶�
	private String hotzone; // ����ֵ
	private String mobilehotzone; // ����ֵ
	private String status; // ״̬�����á�ɾ��
	private String seatmap; // ��λͼ
	private Timestamp addtime;
	private Timestamp updatetime;
	private Integer gsellnum; // Gewa������
	private Integer csellnum; // ����������
	private Integer locknum; // Gewa������
	private String svgpath;
	private String otherinfo;
	private transient boolean localCache;

	public TheatreSeatAreaVo() {
	}

	public TheatreSeatAreaVo(Long dpid) {
		this.dpid = dpid;
		this.status = Status.Y;
		this.total = 0;
		this.limitnum = 0;
		this.gsellnum = 0;
		this.csellnum = 0;
		this.locknum = 0;
		this.addtime = DateUtil.getCurFullTimestamp();
		this.updatetime = this.addtime;
		this.otherinfo = "{}";
	}

	@Override
	public Serializable realId() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDpid() {
		return dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
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

	public String getAreaname() {
		return areaname;
	}

	public String getName() {
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

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getSellerseq() {
		return sellerseq;
	}

	public void setSellerseq(String sellerseq) {
		this.sellerseq = sellerseq;
	}

	public String getFieldnum() {
		return fieldnum;
	}

	public void setFieldnum(String fieldnum) {
		this.fieldnum = fieldnum;
	}

	public String getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
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

	public String getHotzone() {
		return hotzone;
	}

	public void setHotzone(String hotzone) {
		this.hotzone = hotzone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getSeatnum() {
		return this.total;
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

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getSeatmap() {
		return seatmap;
	}

	public void setSeatmap(String seatmap) {
		this.seatmap = seatmap;
	}

	public boolean hasStatus(String stats) {
		if (StringUtils.isBlank(stats)) {
            return false;
        }
		return StringUtils.equals(this.status, stats);
	}

	public boolean hasSeller(String sell) {
		if (StringUtils.isBlank(sell)) {
            return false;
        }
		return StringUtils.equals(this.seller, sell);
	}

	public boolean hasGewara() {
		return StringUtils.equals(this.seller, OdiConstant.PARTNER_GEWA);
	}

	public Integer getRemainnum() {
		return this.limitnum - gsellnum - csellnum - locknum;
	}

	public String getMobilehotzone() {
		return mobilehotzone;
	}

	public void setMobilehotzone(String mobilehotzone) {
		this.mobilehotzone = mobilehotzone;
	}

	public String getSvgpath() {
		return svgpath;
	}

	public void setSvgpath(String svgpath) {
		this.svgpath = svgpath;
	}

	@Override
	public boolean fromCache() {
		return this.localCache;
	}

	@Override
	public boolean cachable() {
		return true;
	}

	@Override
	public void fix2Cache() {
		this.localCache = true;
	}

}
