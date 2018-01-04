package com.gewara.support;

import java.io.Serializable;

public interface PriorityObject extends Serializable{
	/**
	 * 获取对象的优先权重值( 0 <= priority <= 99)
	 * @return
	 */
	public int getPriority();
}
