/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.filter;

import java.awt.image.BufferedImageOp;
import java.util.List;
import org.patchca.filter.AbstractFilterFactory;

public class ConfigurableFilterFactory extends AbstractFilterFactory {
	private List<BufferedImageOp> filters;

	public List<BufferedImageOp> getFilters() {
		return this.filters;
	}

	public void setFilters(List<BufferedImageOp> filters) {
		this.filters = filters;
	}
}