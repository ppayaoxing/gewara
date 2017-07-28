/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.filter.predefined;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;
import org.patchca.color.ColorFactory;
import org.patchca.filter.library.CurvesImageOp;
import org.patchca.filter.predefined.RippleFilterFactory;

public class CurvesRippleFilterFactory extends RippleFilterFactory {
	protected CurvesImageOp curves = new CurvesImageOp();

	public CurvesRippleFilterFactory() {
	}

	public CurvesRippleFilterFactory(ColorFactory colorFactory) {
		this.setColorFactory(colorFactory);
	}

	protected List<BufferedImageOp> getPreRippleFilters() {
		ArrayList list = new ArrayList();
		list.add(this.curves);
		return list;
	}

	public void setStroke(float stroke) {
		this.curves.setStroke(stroke);
	}

	public void setColorFactory(ColorFactory colorFactory) {
		this.curves.setColorFactory(colorFactory);
	}
}