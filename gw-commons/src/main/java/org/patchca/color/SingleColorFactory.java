package org.patchca.color;

import java.awt.Color;

public class SingleColorFactory implements ColorFactory {
	private Color color;

	public SingleColorFactory() {
		this.color = Color.BLACK;
	}

	public SingleColorFactory(Color color) {
		this.color = color;
	}

	@Override
    public Color getColor(int index) {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}