package com.gewara.movie.vo.common;
import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28下午02:05:17
 */
public class CityVo  extends BaseVo{
	private static final long serialVersionUID = -1449397931879372657L;
	private String citycode;
	private String cityname;
	private String cityename;
	
	public CityVo() {
	}

	public CityVo(String citycode) {
		this.citycode = citycode;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCityname() {
		return this.cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getCityename() {
		return this.cityename;
	}

	public void setCityename(String cityename) {
		this.cityename = cityename;
	}

	@Override
	public Serializable realId() {
		return citycode;
	}

	/**
	 * for manage perpose
	 * @return
	 */
	public String getId() {
		return citycode;
	}
}
