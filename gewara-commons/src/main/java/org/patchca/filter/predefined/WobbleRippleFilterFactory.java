/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.filter.predefined;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.math.RandomUtils;
import org.patchca.filter.library.WobbleImageOp;
import org.patchca.filter.predefined.RippleFilterFactory;

public class WobbleRippleFilterFactory extends RippleFilterFactory {
	protected WobbleImageOp[] wobble = new WobbleImageOp[100];

	public WobbleRippleFilterFactory() {
		for (int i = 0; i < 100; ++i) {
			this.wobble[i] = new WobbleImageOp();
		}

	}

	protected List<BufferedImageOp> getPreRippleFilters() {
		ArrayList list = new ArrayList();
		list.add(this.wobble[RandomUtils.nextInt(100)]);
		return list;
	}
}