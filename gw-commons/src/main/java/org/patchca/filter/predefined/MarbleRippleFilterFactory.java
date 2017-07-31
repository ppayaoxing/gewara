package org.patchca.filter.predefined;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;

import org.patchca.filter.library.MarbleImageOp;

public class MarbleRippleFilterFactory extends RippleFilterFactory {
	protected MarbleImageOp marble;

	public MarbleRippleFilterFactory() {
		this.marble = new MarbleImageOp();
	}

	protected List<BufferedImageOp> getPreRippleFilters() {
		List list = new ArrayList();
		list.add(this.marble);
		return list;
	}
}