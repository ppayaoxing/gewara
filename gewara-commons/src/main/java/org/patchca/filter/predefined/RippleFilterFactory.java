/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.filter.predefined;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.math.RandomUtils;
import org.patchca.filter.AbstractFilterFactory;
import org.patchca.filter.library.RippleImageOp;

public class RippleFilterFactory extends AbstractFilterFactory {
	protected RippleImageOp[] ripple = new RippleImageOp[100];

	public RippleFilterFactory() {
		for (int i = 0; i < 100; ++i) {
			this.ripple[i] = new RippleImageOp();
		}

	}

	protected List<BufferedImageOp> getPreRippleFilters() {
		return new ArrayList();
	}

	public List<BufferedImageOp> getFilters() {
		ArrayList filters = new ArrayList();
		filters.addAll(this.getPreRippleFilters());
		filters.add(this.ripple[RandomUtils.nextInt(100)]);
		return filters;
	}
}