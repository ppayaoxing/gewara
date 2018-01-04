package com.gewara.trace;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 采样率<br>
 * 基数，每秒100<br>
 * 超过100按10%采样
 * @author quzhuping
 *
 */
public class Sampler {
	private AtomicInteger count = new AtomicInteger();
    private int baseNumber = 100;
    private Long lastTime = -1L;

    public Sampler(){
        lastTime = System.currentTimeMillis();
    }

    /**
     * 是否采样
     * @return true采样
     */
    public boolean isSample(){
       boolean isSample = true;
       long n = count.incrementAndGet();
       if(System.currentTimeMillis() - lastTime  < 1000){
           if(n > baseNumber){
               n = n%10;
               if(n != 0){
                   isSample = false;
               }
           }
       }else{
           count.getAndSet(0);
           lastTime = System.currentTimeMillis();//
       }
       return isSample;
    }
}
