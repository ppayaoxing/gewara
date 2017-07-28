/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.filter.library;

import org.patchca.filter.library.AbstractTransformImageOp;

public class WobbleImageOp extends AbstractTransformImageOp {
	private double xWavelength = 15.0D;
	private double yWavelength = 15.0D;
	private double xAmplitude = 4.0D;
	private double yAmplitude = 3.0D;
	private double xRandom = 3.0D * Math.random();
	private double yRandom = 10.0D * Math.random();
	private double xScale = 1.0D;
	private double yScale = 1.0D;

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

	public double getxScale() {
		return this.xScale;
	}

	public void setxScale(double xScale) {
		this.xScale = xScale;
	}

	public double getyScale() {
		return this.yScale;
	}

	public void setyScale(double yScale) {
		this.yScale = yScale;
	}

	protected void transform(int x, int y, double[] t) {
		double tx = Math.cos((this.xScale * (double) x + (double) y) / this.xWavelength + this.xRandom);
		double ty = Math.sin((this.yScale * (double) y + (double) x) / this.yWavelength + this.yRandom);
		t[0] = (double) x + this.xAmplitude * tx;
		t[1] = (double) y + this.yAmplitude * ty;
	}
}