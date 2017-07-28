/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.word;

import java.util.Random;
import org.patchca.word.WordFactory;

public class RandomWordFactory implements WordFactory {
	protected String characters = "absdegkmnopwx23456789";
	protected int minLength = 6;
	protected int maxLength = 6;

	public void setCharacters(String characters) {
		this.characters = characters;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public String getNextWord() {
		Random rnd = new Random();
		StringBuffer sb = new StringBuffer();
		int l = this.minLength + (this.maxLength > this.minLength ? rnd.nextInt(this.maxLength - this.minLength) : 0);

		for (int i = 0; i < l; ++i) {
			int j = rnd.nextInt(this.characters.length());
			sb.append(this.characters.charAt(j));
		}

		return sb.toString();
	}
}