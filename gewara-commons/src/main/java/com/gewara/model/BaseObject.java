/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.model;

import com.gewara.support.LocalCachable;
import com.gewara.support.TraceErrorException;
import java.io.Serializable;

public abstract class BaseObject implements LocalCachable, Serializable {
	private static final long serialVersionUID = -3658698824540003392L;

	public abstract Serializable realId();

	public final int hashCode() {
		return this.realId() == null ? 0 : this.realId().hashCode();
	}

	public final boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (this.getClass() != obj.getClass()) {
			return false;
		} else {
			boolean arg9999;
			label34: {
				BaseObject other = (BaseObject) obj;
				if (this.realId() != null) {
					if (this.realId().equals(other.realId())) {
						break label34;
					}
				} else if (other.realId() == null) {
					break label34;
				}

				arg9999 = false;
				return arg9999;
			}

			arg9999 = true;
			return arg9999;
		}
	}

	public boolean fromCache() {
		return false;
	}

	public void fix2Cache() {
	}

	public boolean cachable() {
		return false;
	}

	public void checkSetAllow() {
		if (this.fromCache()) {
			throw new TraceErrorException("LocalCachable set Error!");
		}
	}
}