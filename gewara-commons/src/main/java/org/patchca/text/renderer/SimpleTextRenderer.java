/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.text.renderer;

import java.util.Iterator;
import org.patchca.text.renderer.AbstractTextRenderer;
import org.patchca.text.renderer.TextCharacter;
import org.patchca.text.renderer.TextString;

public class SimpleTextRenderer extends AbstractTextRenderer {
	protected void arrangeCharacters(int width, int height, TextString ts) {
		double x = (double) this.leftMargin;

		TextCharacter tc;
		for (Iterator arg5 = ts.getCharacters().iterator(); arg5.hasNext(); x += tc.getWidth()) {
			tc = (TextCharacter) arg5.next();
			double y = (double) this.topMargin + ((double) height + tc.getAscent() * 0.7D) / 2.0D;
			tc.setX(x);
			tc.setY(y);
		}

	}
}