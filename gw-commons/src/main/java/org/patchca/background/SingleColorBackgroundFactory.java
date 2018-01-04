package org.patchca.background;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.patchca.color.ColorFactory;
import org.patchca.color.SingleColorFactory;

public class SingleColorBackgroundFactory implements BackgroundFactory {
	private ColorFactory colorFactory;

	public SingleColorBackgroundFactory() {
		SingleColorFactory scf = new SingleColorFactory(Color.WHITE);
		this.colorFactory = scf;
	}

	public SingleColorBackgroundFactory(Color color) {
		this.colorFactory = new SingleColorFactory(color);
	}

	public void setColorFactory(ColorFactory colorFactory) {
		this.colorFactory = colorFactory;
	}

	@Override
    public void fillBackground(BufferedImage dest) {
		Graphics2D g = dest.createGraphics();
		g.setBackground(this.colorFactory.getColor(0));
		// 填充背景色
		g.clearRect(0, 0, dest.getWidth(), dest.getHeight());
	}
}
