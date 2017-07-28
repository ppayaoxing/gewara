/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.text.renderer;

import java.util.Iterator;
import java.util.Random;
import org.patchca.text.renderer.AbstractTextRenderer;
import org.patchca.text.renderer.TextCharacter;
import org.patchca.text.renderer.TextString;

public class RandomBestFitTextRenderer extends AbstractTextRenderer {
	protected void arrangeCharacters(int width, int height, TextString ts) {
		Random r = new Random();
		this.leftMargin = r.nextInt(10);
		this.topMargin = r.nextInt(3);
		double widthRemaining = ((double) width - ts.getWidth() - (double) this.leftMargin - (double) this.rightMargin)
				/ (double) ts.getCharacters().size();
		widthRemaining = 0.0D;
		double x = (double) this.leftMargin + widthRemaining / 2.0D;
		height -= this.topMargin + this.bottomMargin;

		TextCharacter tc;
		for (Iterator arg8 = ts.getCharacters().iterator(); arg8
				.hasNext(); x += tc.getWidth() + widthRemaining - 3.0D) {
			tc = (TextCharacter) arg8.next();
			double y = (double) this.topMargin + ((double) height + tc.getAscent() * 0.7D) / 2.0D;
			tc.setX(x);
			tc.setY(y);
		}

	}
}