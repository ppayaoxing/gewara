package com.gewara.drama.vo.partner.req;


public class TheatreDramaReqVo extends PartnerDramaReqVo {

	private static final long serialVersionUID = 7276826866180688064L;
	
	private Long theatreid;

	public TheatreDramaReqVo(Long theatreid, String appkey, String citycode) {
		this.theatreid = theatreid;
		this.appkey = appkey;
		this.citycode = citycode;
	}

	public Long getTheatreid() {
		return theatreid;
	}


	public void setTheatreid(Long theatreid) {
		this.theatreid = theatreid;
	}
	
	
}
