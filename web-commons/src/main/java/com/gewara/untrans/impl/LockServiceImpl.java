package com.gewara.untrans.impl;

import com.gewara.support.ErrorCode;
import com.gewara.support.concurrent.AtomicCounter;
//import com.gewara.support.concurrent.AtomicCounter;
import com.gewara.untrans.LockCallback;
import com.gewara.untrans.LockService;

/**
 * ÔÝ¶¨
 * 
 * @author sunder
 *
 */
public class LockServiceImpl implements LockService {

	private AtomicCounter atomicCounter;

	public AtomicCounter getAtomicCounter(String ticketTradeNO) {
		return atomicCounter;
	}

	public void setAtomicCounter(AtomicCounter atomicCounter) {
		this.atomicCounter = atomicCounter;
	}

	@Override
	public <T> ErrorCode<T> doWithWriteLock(String lockKey, LockCallback<T> lc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ErrorCode<T> doWithWriteLock(String lockKey, int waitSeconds, LockCallback<T> lc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> ErrorCode<T> tryDoWithWriteLock(String lockKey, LockCallback<T> lc) {
		// TODO Auto-generated method stub
		return null;
	}

}
