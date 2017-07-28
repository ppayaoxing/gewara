/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.filter.library;

import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Float;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.util.Hashtable;

public abstract class AbstractImageOp implements BufferedImageOp {
	public static final int EDGE_ZERO = 0;
	public static final int EDGE_MIRROR = 1;
	public static final int EDGE_CLAMP = 2;
	protected int edgeMode = 0;
	protected RenderingHints hints;

	public int getEdgeMode() {
		return this.edgeMode;
	}

	public void setEdgeMode(int edgeMode) {
		this.edgeMode = edgeMode;
	}

	protected int getPixel(int[] pixels, int x, int y, int width, int height) {
		if (x >= 0 && x < width && y >= 0 && y < height) {
			return pixels[x + y * width];
		} else if (this.edgeMode == 0) {
			return 0;
		} else if (this.edgeMode == 2) {
			if (x < 0) {
				x = 0;
			} else if (x >= width) {
				x = width - 1;
			}

			if (y < 0) {
				y = 0;
			} else if (y >= height) {
				y = height - 1;
			}

			return pixels[x + y * width];
		} else {
			if (x < 0) {
				x = -x;
			} else if (x >= width) {
				x = width + width - x - 1;
			}

			if (y < 0) {
				y = -y;
			} else if (y > height) {
				--height;
				y = height - y;
			}

			try {
				return pixels[x + y * width];
			} catch (Exception arg6) {
				return 0;
			}
		}
	}

	private int linear(int from, int to, int shift, double d) {
		return (int) Math.floor(
				(double) (from >> shift & 255) + d * (double) ((to >> shift & 255) - (from >> shift & 255))) << shift;
	}

	private int linear(int from, int to, double d) {
		int c = 0;

		for (int i = 0; i < 4; ++i) {
			c += this.linear(from, to, i * 8, d);
		}

		return c;
	}

	protected int bilinear(int nw, int ne, int sw, int se, double xd, double yd) {
		return this.linear(this.linear(nw, ne, xd), this.linear(sw, se, xd), yd);
	}

	protected int getPixelBilinear(int[] pixels, double x, double y, int width, int height) {
		int xi = (int) Math.floor(x);
		int yi = (int) Math.floor(y);
		double xd = x - (double) xi;
		double yd = y - (double) yi;
		int nw = this.getPixel(pixels, xi, yi, width, height);
		int ne = this.getPixel(pixels, xi + 1, yi, width, height);
		int sw = this.getPixel(pixels, xi, yi + 1, width, height);
		int se = this.getPixel(pixels, xi + 1, yi + 1, width, height);
		return this.bilinear(nw, ne, sw, se, xd, yd);
	}

	protected int limit(int v, int min, int max) {
		if (v < min) {
			v = min;
		} else if (v > max) {
			v = max;
		}

		return v;
	}

	protected int limitByte(int v) {
		return this.limit(v, 0, 255);
	}

	protected abstract void filter(int[] arg0, int[] arg1, int arg2, int arg3);

	public BufferedImage filter(BufferedImage src, BufferedImage dest) {
		if (dest == null) {
			dest = this.createCompatibleDestImage(src, (ColorModel) null);
		}

		int width = src.getWidth();
		int height = src.getHeight();
		int[] inPixels = new int[width * height];
		int[] outPixels = new int[width * height];
		src.getRaster().getDataElements(0, 0, width, height, inPixels);
		this.filter(inPixels, outPixels, width, height);
		dest.getRaster().setDataElements(0, 0, width, height, outPixels);
		return dest;
	}

	public BufferedImage createCompatibleDestImage(BufferedImage src, ColorModel destCM) {
		if (destCM == null) {
			destCM = src.getColorModel();
			if (destCM instanceof IndexColorModel) {
				destCM = ColorModel.getRGBdefault();
			}
		}

		return new BufferedImage(destCM, destCM.createCompatibleWritableRaster(src.getWidth(), src.getHeight()),
				destCM.isAlphaPremultiplied(), (Hashtable) null);
	}

	public Rectangle2D getBounds2D(BufferedImage src) {
		return src.getRaster().getBounds();
	}

	public Point2D getPoint2D(Point2D srcPt, Point2D dstPt) {
		if (dstPt == null) {
			dstPt = new Float();
		}

		((Point2D) dstPt).setLocation(srcPt.getX(), srcPt.getY());
		return (Point2D) dstPt;
	}

	public RenderingHints getRenderingHints() {
		return this.hints;
	}
}