/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.HtmlCharacterEntityDecoder;
import com.gewara.util.HtmlCharacterEntityReferences;

public abstract class HtmlUtils {
	private static final HtmlCharacterEntityReferences characterEntityReferences = new HtmlCharacterEntityReferences();

	public static String htmlEscape(String input) {
		if (input == null) {
			return null;
		} else {
			StringBuilder escaped = new StringBuilder(input.length() * 2);

			for (int i = 0; i < input.length(); ++i) {
				char character = input.charAt(i);
				String reference = characterEntityReferences.convertToReference(character);
				if (reference != null) {
					escaped.append(reference);
				} else {
					escaped.append(character);
				}
			}

			return escaped.toString();
		}
	}

	public static String htmlEscapeDecimal(String input) {
		if (input == null) {
			return null;
		} else {
			StringBuilder escaped = new StringBuilder(input.length() * 2);

			for (int i = 0; i < input.length(); ++i) {
				char character = input.charAt(i);
				if (characterEntityReferences.isMappedToReference(character)) {
					escaped.append("&#");
					escaped.append(character);
					escaped.append(';');
				} else {
					escaped.append(character);
				}
			}

			return escaped.toString();
		}
	}

	public static String htmlEscapeHex(String input) {
		if (input == null) {
			return null;
		} else {
			StringBuilder escaped = new StringBuilder(input.length() * 2);

			for (int i = 0; i < input.length(); ++i) {
				char character = input.charAt(i);
				if (characterEntityReferences.isMappedToReference(character)) {
					escaped.append("&#x");
					escaped.append(Integer.toString(character, 16));
					escaped.append(';');
				} else {
					escaped.append(character);
				}
			}

			return escaped.toString();
		}
	}

	public static String htmlUnescape(String input) {
		return input == null ? null : (new HtmlCharacterEntityDecoder(characterEntityReferences, input)).decode();
	}
}