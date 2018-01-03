package com.gewara.model;

import java.io.Serializable;

import com.gewara.support.LocalCachable;
import com.gewara.support.TraceErrorException;

/**
 * equals() and hashCode();
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28下午02:05:17
 */
public abstract class BaseObject implements LocalCachable, Serializable {
	private static final long serialVersionUID = -3658698824540003392L;
	/**
	 * @return 数据的真实ID，不加get方法减少相关反射输出
	 */
	public abstract Serializable realId();
	@Override
	public final int hashCode() {
		return (realId() == null) ? 0 : realId().hashCode();
	}
	
	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		BaseObject other = (BaseObject) obj;
		return !(this.realId() != null ? !(this.realId().equals(other.realId())) : (other.realId() != null));
	}
	@Override
	public boolean fromCache() {
		//subclass imp it
		return false;
	}
	@Override
	public void fix2Cache() {
		//nothing, for subclass 
	}
	@Override
	public boolean cachable() {
		//subclass imp it 
		return false;
	}
	public void checkSetAllow(){
		if(fromCache()){
			throw new TraceErrorException("LocalCachable set Error!");
		}
	}
	
}
