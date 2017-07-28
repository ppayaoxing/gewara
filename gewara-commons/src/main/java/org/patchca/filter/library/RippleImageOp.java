/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.filter.library;

import org.patchca.filter.library.AbstractTransformImageOp;

public class RippleImageOp extends AbstractTransformImageOp {
	protected double xWavelength = 20.0D;
	protected double yWavelength = 10.0D;
	protected double xAmplitude = 5.0D;
	protected double yAmplitude = 5.0D;
	protected double xRandom = 5.0D * Math.random();
	protected double yRandom = 5.0D * Math.random();

	public double getxWavelength() {
		return this.xWavelength;
	}

	public void setxWavelength(double xWavelength) {
		this.xWavelength = xWavelength;
	}

	public double getyWavelength() {
		return this.yWavelength;
	}

	public void setyWavelength(double yWavelength) {
		this.yWavelength = yWavelength;
	}

	public double getxAmplitude() {
		return this.xAmplitude;
	}

	public void setxAmplitude(double xAmplitude) {
		this.xAmplitude = xAmplitude;
	}

	public double getyAmplitude() {
		return this.yAmplitude;
	}

	public void setyAmplitude(double yAmplitude) {
		this.yAmplitude = yAmplitude;
	}

	protected void transform(int x, int y, double[] t) {
		double tx = Math.sin((double) y / this.yWavelength + this.yRandom);
		double ty = Math.cos((double) x / this.xWavelength + this.xRandom);
		t[0] = (double) x + this.xAmplitude * tx;
		t[1] = (double) y + this.yAmplitude * ty;
	}
}