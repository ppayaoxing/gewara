/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase.util;

import com.gewara.hbase.util.FilterBuilder;
import com.gewara.util.Util4Script;
import java.io.IOException;
import org.apache.hadoop.hbase.client.Scan;

public class ScanBuilder implements Util4Script {
	private FilterBuilder fb;

	public ScanBuilder() {
	}

	public ScanBuilder(FilterBuilder fb) {
		this.fb = fb;
	}

	public Scan buildScan() {
		Scan scan = new Scan();
		if (this.fb.startRow != null) {
			scan.setStartRow(this.fb.startRow);
		}

		if (this.fb.stopRow != null) {
			scan.setStopRow(this.fb.stopRow);
		}

		if (this.fb != null && !this.fb.isEmptyCondition()) {
			scan.setFilter(this.fb.buildFilters());
		}

		if (this.fb.minStamp != null && this.fb.maxStamp != null) {
			try {
				scan.setTimeRange(this.fb.minStamp.longValue(), this.fb.maxStamp.longValue());
			} catch (IOException arg2) {
				;
			}
		}

		return scan;
	}

	public boolean isEmptyCondition() {
		return this.fb.isEmptyCondition();
	}

	public FilterBuilder getFb() {
		return this.fb;
	}
}