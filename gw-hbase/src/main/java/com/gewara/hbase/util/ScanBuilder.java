package com.gewara.hbase.util;

import java.io.IOException;

import org.apache.hadoop.hbase.client.Scan;

import com.gewara.util.Util4Script;

/**
 * TODO:
 * 1,add return columns
 * 2,add groovy expression
 */
public class ScanBuilder implements Util4Script {
	private FilterBuilder fb;
	public ScanBuilder(){
		
	}
	public ScanBuilder(FilterBuilder fb){
		this.fb = fb;
	}
	
	/**
	 * build scan
	 * @return
	 */
	public Scan buildScan(){
		Scan scan = new Scan();
		if(fb.startRow!=null){
			scan.setStartRow(fb.startRow);
		}
		if(fb.stopRow!=null){
			scan.setStopRow(fb.stopRow);
		}
		if(fb!=null && !fb.isEmptyCondition()){
			scan.setFilter(fb.buildFilters());
		}
		if(fb.minStamp!=null && fb.maxStamp!=null){
			try {
				scan.setTimeRange(fb.minStamp, fb.maxStamp);
			} catch (IOException e) {
			}
		}
		return scan;
	}
	
	public boolean isEmptyCondition(){
		return fb.isEmptyCondition();
	}

	public FilterBuilder getFb() {
		return fb;
	}
}
