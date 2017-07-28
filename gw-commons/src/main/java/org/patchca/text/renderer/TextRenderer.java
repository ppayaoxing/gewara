/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.text.renderer;

import java.awt.image.BufferedImage;
import org.patchca.color.ColorFactory;
import org.patchca.font.FontFactory;

public interface TextRenderer {
	void setLeftMargin(int arg0);

	void setRightMargin(int arg0);

	void setTopMargin(int arg0);

	void setBottomMargin(int arg0);

	void draw(String arg0, BufferedImage arg1, FontFactory arg2, ColorFactory arg3);
}