/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.background;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import org.patchca.background.BackgroundFactory;
import org.patchca.color.ColorFactory;
import org.patchca.color.SingleColorFactory;

public class ComplexBackgroundFactory implements BackgroundFactory {
	private Random random = new Random();
	private ColorFactory factory = new SingleColorFactory(new Color(25, 60, 170));

	public void fillBackground(BufferedImage image) {
		Graphics graphics = image.getGraphics();
		int imgWidth = image.getWidth();
		int imgHeight = image.getHeight();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, imgWidth, imgHeight);

		for (int i = 0; i < 10; ++i) {
			graphics.setColor(this.factory.getColor(1));
			int xInt = this.random.nextInt(imgWidth - 3);
			int yInt = this.random.nextInt(imgHeight - 2);
			int sAngleInt = this.random.nextInt(360);
			int eAngleInt = this.random.nextInt(360);
			int wInt = this.random.nextInt(6);
			int hInt = this.random.nextInt(6);
			graphics.fillArc(xInt, yInt, wInt, hInt, sAngleInt, eAngleInt);
			if (i % 2 == 0) {
				int xInt2 = this.random.nextInt(imgWidth);
				int yInt2 = this.random.nextInt(imgHeight);
				graphics.drawLine(xInt, yInt, xInt2, yInt2);
			}
		}

	}
}