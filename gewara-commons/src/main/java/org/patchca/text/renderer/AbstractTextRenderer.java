/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.text.renderer;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import org.patchca.color.ColorFactory;
import org.patchca.font.FontFactory;
import org.patchca.text.renderer.TextCharacter;
import org.patchca.text.renderer.TextRenderer;
import org.patchca.text.renderer.TextString;

public abstract class AbstractTextRenderer implements TextRenderer {
	protected int leftMargin;
	protected int rightMargin;
	protected int topMargin;
	protected int bottomMargin;

	protected abstract void arrangeCharacters(int arg0, int arg1, TextString arg2);

	public AbstractTextRenderer() {
		this.leftMargin = this.rightMargin = 0;
		this.topMargin = this.bottomMargin = 0;
	}

	public void setLeftMargin(int leftMargin) {
		this.leftMargin = leftMargin;
	}

	public void setRightMargin(int rightMargin) {
		this.rightMargin = rightMargin;
	}

	public void setTopMargin(int topMargin) {
		this.topMargin = topMargin;
	}

	public void setBottomMargin(int bottomMargin) {
		this.bottomMargin = bottomMargin;
	}

	public void draw(String text, BufferedImage canvas, FontFactory fontFactory, ColorFactory colorFactory) {
		Graphics2D g = (Graphics2D) canvas.getGraphics();
		TextString ts = this.convertToCharacters(text, g, fontFactory, colorFactory);
		this.arrangeCharacters(canvas.getWidth(), canvas.getHeight(), ts);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		Iterator arg6 = ts.getCharacters().iterator();

		while (arg6.hasNext()) {
			TextCharacter tc = (TextCharacter) arg6.next();
			g.setColor(tc.getColor());
			g.drawString(tc.iterator(), (float) tc.getX(), (float) tc.getY());
		}

	}

	protected TextString convertToCharacters(String text, Graphics2D g, FontFactory fontFactory,
			ColorFactory colorFactory) {
		TextString characters = new TextString();
		FontRenderContext frc = g.getFontRenderContext();
		double lastx = 0.0D;

		for (int i = 0; i < text.length(); ++i) {
			Font font = fontFactory.getFont(i);
			char c = text.charAt(i);
			FontMetrics fm = g.getFontMetrics(font);
			Rectangle2D bounds = font.getStringBounds(String.valueOf(c), frc);
			TextCharacter tc = new TextCharacter();
			tc.setCharacter(c);
			tc.setFont(font);
			tc.setWidth((double) fm.charWidth(c));
			tc.setHeight((double) (fm.getAscent() + fm.getDescent()));
			tc.setAscent((double) fm.getAscent());
			tc.setDescent((double) fm.getDescent());
			tc.setX(lastx);
			tc.setY(0.0D);
			tc.setFont(font);
			tc.setColor(colorFactory.getColor(i));
			lastx += bounds.getWidth();
			characters.addCharacter(tc);
		}

		return characters;
	}
}