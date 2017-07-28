/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.filter.library;

import org.patchca.filter.library.AbstractImageOp;

public abstract class AbstractTransformImageOp extends AbstractImageOp {
	private boolean initialized;

	protected abstract void transform(int arg0, int arg1, double[] arg2);

	protected void init() {
	}

	public AbstractTransformImageOp() {
		this.setEdgeMode(2);
	}

	protected void filter(int[] inPixels, int[] outPixels, int width, int height) {
		if (!this.initialized) {
			this.init();
			this.initialized = true;
		}

		double[] t = new double[2];

		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
				this.transform(x, y, t);
				int pixel = this.getPixelBilinear(inPixels, t[0], t[1], width, height);
				outPixels[x + y * width] = pixel;
			}
		}

	}
}