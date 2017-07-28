/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.filter.library;

import org.patchca.filter.library.AbstractConvolveImageOp;

public class SoftenImageOp extends AbstractConvolveImageOp {
	private static final float[][] matrix = new float[][] { { 0.0F, 0.0625F, 0.0F }, { 0.0625F, 0.75F, 0.0625F },
			{ 0.0F, 0.0625F, 0.0F } };

	public SoftenImageOp() {
		super(matrix);
	}
}