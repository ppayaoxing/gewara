/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package org.patchca.text.renderer;

import java.util.ArrayList;
import java.util.Iterator;
import org.patchca.text.renderer.TextCharacter;

public class TextString {
	private ArrayList<TextCharacter> characters = new ArrayList();

	public void clear() {
		this.characters.clear();
	}

	public void addCharacter(TextCharacter tc) {
		this.characters.add(tc);
	}

	public ArrayList<TextCharacter> getCharacters() {
		return this.characters;
	}

	public double getWidth() {
		double minx = 0.0D;
		double maxx = 0.0D;
		boolean first = true;
		Iterator arg5 = this.characters.iterator();

		while (arg5.hasNext()) {
			TextCharacter tc = (TextCharacter) arg5.next();
			if (first) {
				minx = tc.getX();
				maxx = tc.getX() + tc.getWidth();
				first = false;
			} else {
				if (minx > tc.getX()) {
					minx = tc.getX();
				}

				if (maxx < tc.getX() + tc.getWidth()) {
					maxx = tc.getX() + tc.getWidth();
				}
			}
		}

		return maxx - minx;
	}

	public double getHeight() {
		double miny = 0.0D;
		double maxy = 0.0D;
		boolean first = true;
		Iterator arg5 = this.characters.iterator();

		while (arg5.hasNext()) {
			TextCharacter tc = (TextCharacter) arg5.next();
			if (first) {
				miny = tc.getY();
				maxy = tc.getY() + tc.getHeight();
				first = false;
			} else {
				if (miny > tc.getY()) {
					miny = tc.getY();
				}

				if (maxy < tc.getY() + tc.getHeight()) {
					maxy = tc.getY() + tc.getHeight();
				}
			}
		}

		return maxy - miny;
	}
}