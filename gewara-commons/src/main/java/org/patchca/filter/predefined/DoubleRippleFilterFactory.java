/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.filter.predefined;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;
import org.patchca.filter.AbstractFilterFactory;
import org.patchca.filter.library.DoubleRippleImageOp;

public class DoubleRippleFilterFactory extends AbstractFilterFactory {
	protected List<BufferedImageOp> filters;
	protected DoubleRippleImageOp ripple = new DoubleRippleImageOp();

	public List<BufferedImageOp> getFilters() {
		if (this.filters == null) {
			this.filters = new ArrayList();
			this.filters.add(this.ripple);
		}

		return this.filters;
	}
}