/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.filter.library;

import org.patchca.filter.library.AbstractImageOp;

public abstract class AbstractConvolveImageOp extends AbstractImageOp {
	private float[][] matrix;

	protected AbstractConvolveImageOp(float[][] matrix) {
		this.matrix = matrix;
	}

	protected void filter(int[] inPixels, int[] outPixels, int width, int height) {
		int matrixWidth = this.matrix[0].length;
		int matrixHeight = this.matrix.length;
		int mattrixLeft = -matrixWidth / 2;
		int matrixTop = -matrixHeight / 2;

		for (int y = 0; y < height; ++y) {
			int ytop = y + matrixTop;
			int ybottom = y + matrixTop + matrixHeight;

			for (int x = 0; x < width; ++x) {
				float[] sum = new float[] { 0.5F, 0.5F, 0.5F, 0.5F };
				int xleft = x + mattrixLeft;
				int xright = x + mattrixLeft + matrixWidth;
				int matrixY = 0;

				for (int my = ytop; my < ybottom; ++matrixY) {
					int matrixX = 0;

					for (int mx = xleft; mx < xright; ++matrixX) {
						int pixel = this.getPixel(inPixels, mx, my, width, height);
						float m = this.matrix[matrixY][matrixX];
						sum[0] += m * (float) (pixel >> 24 & 255);
						sum[1] += m * (float) (pixel >> 16 & 255);
						sum[2] += m * (float) (pixel >> 8 & 255);
						sum[3] += m * (float) (pixel & 255);
						++mx;
					}

					++my;
				}

				outPixels[x + y * width] = this.limitByte((int) sum[0]) << 24 | this.limitByte((int) sum[1]) << 16
						| this.limitByte((int) sum[2]) << 8 | this.limitByte((int) sum[3]);
			}
		}

	}
}