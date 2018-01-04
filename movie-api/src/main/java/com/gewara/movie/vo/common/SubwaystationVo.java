package com.gewara.movie.vo.common;
import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28下午02:05:17
 */
public class SubwaystationVo  extends BaseVo {
	private static final long serialVersionUID = -1449397931879372657L;
	private Long id;
	private String stationname;
	private String citycode;
	public SubwaystationVo(String stationname) {
		this.stationname = stationname;
	}

	public SubwaystationVo() {
	}
	@Override
	public Serializable realId() {
		return id;
	}

	/**
	 * for manage perpose
	 * @return
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStationname() {
		return stationname;
	}

	public void setStationname(String stationname) {
		this.stationname = stationname;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
}
