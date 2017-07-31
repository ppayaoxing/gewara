package com.gewara.untrans;

public interface LockCallback<T> {
	T processWithInLock();
}
