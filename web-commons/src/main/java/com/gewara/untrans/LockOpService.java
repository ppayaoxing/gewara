package com.gewara.untrans;

public interface LockOpService {
	/**
	 * 同OperationService，使用Memcache实现
	 * @param opkey
	 * @param allowIntervalSecond
	 * @return lockvalue
	 */
	Long updateOperation(String opkey, int allowIntervalSecond);
	/**
	 * 同OperationService，使用Memcache实现
	 * @param opkey
	 */
	void resetOperation(String opkey, Long lockvalue);
	/**
	 * flag表示身份，同一身份
	 * @param opkey
	 * @param allowIntervalSecond
	 * @param flag
	 * @return
	 */
	Long updateFlagOperation(String opkey, int allowIntervalSecond, String flag);
	/**
	 * 同OperationService，使用Memcache实现
	 * @param opkey
	 */
	void resetFlagOperation(String opkey, String flag);
}
