/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.filter.library;

import org.patchca.filter.library.RippleImageOp;

public class DoubleRippleImageOp extends RippleImageOp {
	protected void transform(int x, int y, double[] t) {
		double tx = Math.sin((double) y / this.yWavelength + this.yRandom)
				+ 1.3D * Math.sin(0.6D * (double) y / this.yWavelength + this.yRandom);
		double ty = Math.cos((double) x / this.xWavelength + this.xRandom)
				+ 1.3D * Math.cos(0.6D * (double) x / this.xWavelength + this.xRandom);
		t[0] = (double) x + this.xAmplitude * tx;
		t[1] = (double) y + this.yAmplitude * ty;
	}
}