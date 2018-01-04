package com.gewara.api.activity;

import java.io.Serializable;

public abstract class ApiObject implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract Serializable realId();
	
	@Override
	public final int hashCode() {
		return (realId() == null) ? 0 : realId().hashCode();
	}
	
	@Override
	public final boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
		if (getClass() != obj.getClass()) {
            return false;
        }
		ApiObject other = (ApiObject) obj;
		return !(this.realId() != null ? !(this.realId().equals(other.realId())) : (other.realId() != null));
	}
}

