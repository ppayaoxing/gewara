/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.filter.predefined;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;
import org.patchca.filter.library.MarbleImageOp;
import org.patchca.filter.predefined.RippleFilterFactory;

public class MarbleRippleFilterFactory extends RippleFilterFactory {
	protected MarbleImageOp marble = new MarbleImageOp();

	protected List<BufferedImageOp> getPreRippleFilters() {
		ArrayList list = new ArrayList();
		list.add(this.marble);
		return list;
	}
}