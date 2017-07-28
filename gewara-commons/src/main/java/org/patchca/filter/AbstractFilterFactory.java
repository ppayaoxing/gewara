/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.filter;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.util.Iterator;
import java.util.List;
import org.patchca.filter.FilterFactory;

public abstract class AbstractFilterFactory implements FilterFactory {
	protected abstract List<BufferedImageOp> getFilters();

	public BufferedImage applyFilters(BufferedImage source) {
		BufferedImage dest = source;

		BufferedImageOp y;
		for (Iterator x = this.getFilters().iterator(); x.hasNext(); dest = y.filter(dest, (BufferedImage) null)) {
			y = (BufferedImageOp) x.next();
		}

		int x1 = (source.getWidth() - dest.getWidth()) / 2;
		int y1 = (source.getHeight() - dest.getHeight()) / 2;
		source = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
		source.getGraphics().drawImage(dest, x1, y1, (ImageObserver) null);
		return source;
	}
}