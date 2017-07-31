package com.gewara.support.concurrent;
public interface AtomicCounter{
    long get();
    void set(long newValue);
    long getAndAdd(long delta);
    long getAndDecrement();
    long getAndIncrement();
    long getAndSet(long newValue);
    long incrementAndGet();
}
