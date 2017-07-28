/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.color;

import java.awt.Color;
import org.patchca.color.ColorFactory;

public class SingleColorFactory implements ColorFactory {
	private Color color;

	public SingleColorFactory() {
		this.color = Color.BLACK;
	}

	public SingleColorFactory(Color color) {
		this.color = color;
	}

	public Color getColor(int index) {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}