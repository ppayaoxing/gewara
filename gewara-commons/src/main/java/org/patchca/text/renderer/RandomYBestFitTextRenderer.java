/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.text.renderer;

import java.util.Iterator;
import java.util.Random;
import org.patchca.text.renderer.AbstractTextRenderer;
import org.patchca.text.renderer.TextCharacter;
import org.patchca.text.renderer.TextString;

public class RandomYBestFitTextRenderer extends AbstractTextRenderer {
	private double minY = 20.0D;
	private double maxY = 25.0D;

	public void setMinY(double minY) {
		this.minY = minY;
	}

	public void setMaxY(double maxY) {
		this.maxY = maxY;
	}

	protected void arrangeCharacters(int width, int height, TextString ts) {
		double widthRemaining = ((double) width - ts.getWidth() - (double) this.leftMargin - (double) this.rightMargin)
				/ (double) ts.getCharacters().size();
		double vmiddle = (double) (height / 2);
		double x = (double) this.leftMargin + widthRemaining / 2.0D;
		Random r = new Random();
		height -= this.topMargin + this.bottomMargin;

		TextCharacter tc;
		for (Iterator arg10 = ts.getCharacters().iterator(); arg10
				.hasNext(); x += tc.getWidth() + widthRemaining - 5.0D) {
			tc = (TextCharacter) arg10.next();
			double heightRemaining = (double) height - tc.getHeight();
			double y = vmiddle + 0.35D * tc.getAscent() + (1.0D - 2.0D * r.nextDouble()) * heightRemaining;
			tc.setX(x);
			y = Math.min(Math.max(this.minY, y), this.maxY);
			tc.setY(y);
		}

	}
}