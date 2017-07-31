package com.gewara.support;

public class CacheSlowException extends RuntimeException {
	private static final long serialVersionUID = 6959794011102615332L;
	public CacheSlowException(Class clazz){
		super(clazz.getCanonicalName() + ": cache too slow!" );
	}
}
