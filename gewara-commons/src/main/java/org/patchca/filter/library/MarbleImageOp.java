/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.filter.library;

import org.patchca.filter.library.AbstractTransformImageOp;
import org.patchca.filter.library.PerlinNoise;

public class MarbleImageOp extends AbstractTransformImageOp {
	double scale = 15.0D;
	double amount = 1.1D;
	double turbulence = 6.2D;
	double[] tx;
	double[] ty;
	double randomX = 256.0D * Math.random();
	double randomY = 256.0D * Math.random();

	public double getScale() {
		return this.scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getTurbulence() {
		return this.turbulence;
	}

	public void setTurbulence(double turbulence) {
		this.turbulence = turbulence;
	}

	protected synchronized void init() {
		this.tx = new double[256];
		this.ty = new double[256];

		for (int i = 0; i < 256; ++i) {
			double angle = 6.283185307179586D * (double) i * this.turbulence / 256.0D;
			this.tx[i] = this.amount * Math.sin(angle);
			this.ty[i] = this.amount * Math.cos(angle);
		}

	}

	protected void transform(int x, int y, double[] t) {
		int d = this.limitByte((int) (127.0D * (1.0D + PerlinNoise.noise2D((double) x / this.scale + this.randomX,
				(double) y / this.scale + this.randomY))));
		t[0] = (double) x + this.tx[d];
		t[1] = (double) y + this.ty[d];
	}

	protected void filter2(int[] outPixels, int width, int height) {
		for (int y = 0; y < height; ++y) {
			for (int x = 0; x < width; ++x) {
				int pixel = this.limitByte((int) (127.0D * (1.0D + PerlinNoise
						.noise2D((double) x / this.scale + this.randomX, (double) y / this.scale + this.randomY))));
				outPixels[x + y * width] = this.limitByte(255) << 24 | this.limitByte(pixel) << 16
						| this.limitByte(pixel) << 8 | this.limitByte(pixel);
			}
		}

	}
}