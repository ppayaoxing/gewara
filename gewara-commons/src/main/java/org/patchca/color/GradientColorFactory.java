/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.color;

import java.awt.Color;
import org.patchca.color.ColorFactory;

public class GradientColorFactory implements ColorFactory {
	private Color start = new Color(192, 192, 0);
	private Color step = new Color(192, 128, 128);

	public Color getColor(int index) {
		return new Color((this.start.getRed() + this.step.getRed() * index) % 256,
				(this.start.getGreen() + this.step.getGreen() * index) % 256,
				(this.start.getBlue() + this.step.getBlue() * index) % 256);
	}

	public void setStart(Color start) {
		this.start = start;
	}

	public void setStep(Color step) {
		this.step = step;
	}
}