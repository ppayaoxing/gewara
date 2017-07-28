/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.color;

import java.awt.Color;
import java.util.Random;
import org.patchca.color.ColorFactory;

public class RandomColorFactory implements ColorFactory {
	private Color min = new Color(20, 40, 80);
	private Color max = new Color(21, 50, 140);
	private Color color;

	public void setMin(Color min) {
		this.min = min;
	}

	public void setMax(Color max) {
		this.max = max;
	}

	public Color getColor(int index) {
		if (this.color == null) {
			Random r = new Random();
			this.color = new Color(this.min.getRed() + r.nextInt(this.max.getRed() - this.min.getRed()),
					this.min.getGreen() + r.nextInt(this.max.getGreen() - this.min.getGreen()),
					this.min.getBlue() + r.nextInt(this.max.getBlue() - this.min.getBlue()));
		}

		return this.color;
	}
}