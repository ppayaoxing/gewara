/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.text.renderer;

import java.util.Iterator;
import org.patchca.text.renderer.AbstractTextRenderer;
import org.patchca.text.renderer.TextCharacter;
import org.patchca.text.renderer.TextString;

public class BestFitTextRenderer extends AbstractTextRenderer {
	protected void arrangeCharacters(int width, int height, TextString ts) {
		double widthRemaining = ((double) width - ts.getWidth() - (double) this.leftMargin - (double) this.rightMargin)
				/ (double) ts.getCharacters().size();
		double x = (double) this.leftMargin + widthRemaining / 2.0D;
		height -= this.topMargin + this.bottomMargin;

		TextCharacter tc;
		for (Iterator arg7 = ts.getCharacters().iterator(); arg7.hasNext(); x += tc.getWidth() + widthRemaining) {
			tc = (TextCharacter) arg7.next();
			double y = (double) this.topMargin + ((double) height + tc.getAscent() * 0.7D) / 2.0D;
			tc.setX(x);
			tc.setY(y);
		}

	}
}