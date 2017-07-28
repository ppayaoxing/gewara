/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import java.io.Serializable;

public class CacheElement<T> implements Serializable {
	private static final long serialVersionUID = -1979998154391346950L;
	private Long validtime;
	private T value;
	private Long updatetime;

	public CacheElement() {
	}

	public CacheElement(T value, Integer cacheSeconds) {
		this.updatetime = Long.valueOf(System.currentTimeMillis());
		this.validtime = Long.valueOf(System.currentTimeMillis() + (long) (cacheSeconds.intValue() * 1000));
		this.value = value;
	}

	public Long getValidtime() {
		return this.validtime;
	}

	public void setValidtime(Long validtime) {
		this.validtime = validtime;
	}

	public T getValue() {
		return this.value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Long getUpdatetime() {
		return this.updatetime;
	}
}