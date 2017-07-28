/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.activity;

import java.io.Serializable;

public abstract class ApiObject implements Serializable {
	private static final long serialVersionUID = 1L;

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
				ApiObject other = (ApiObject) obj;
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
}