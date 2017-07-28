/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class HtmlCharacterEntityReferences {
	private static final String PROPERTIES_FILE = "HtmlCharacterEntityReferences.properties";
	static final char REFERENCE_START = '&';
	static final String DECIMAL_REFERENCE_START = "&#";
	static final String HEX_REFERENCE_START = "&#x";
	static final char REFERENCE_END = ';';
	static final char CHAR_NULL = '?';
	private final String[] characterToEntityReferenceMap = new String[3000];
	private final Map<String, Character> entityReferenceToCharacterMap = new HashMap(252);

	public HtmlCharacterEntityReferences() {
		Properties entityReferences = new Properties();
		InputStream is = HtmlCharacterEntityReferences.class
				.getResourceAsStream("HtmlCharacterEntityReferences.properties");
		if (is == null) {
			throw new IllegalStateException(
					"Cannot find reference definition file [HtmlCharacterEntityReferences.properties] as class path resource");
		} else {
			try {
				try {
					entityReferences.load(is);
				} finally {
					is.close();
				}
			} catch (IOException arg10) {
				throw new IllegalStateException(
						"Failed to parse reference definition file [HtmlCharacterEntityReferences.properties]: "
								+ arg10.getMessage());
			}

			Enumeration keys = entityReferences.propertyNames();

			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				int referredChar = Integer.parseInt(key);
				if (referredChar >= 1000 && (referredChar < 8000 || referredChar >= 10000)) {
					throw new IllegalArgumentException("Invalid reference to special HTML entity: " + referredChar);
				}

				int index = referredChar < 1000 ? referredChar : referredChar - 7000;
				String reference = entityReferences.getProperty(key);
				this.characterToEntityReferenceMap[index] = '&' + reference + ';';
				this.entityReferenceToCharacterMap.put(reference, new Character((char) referredChar));
			}

		}
	}

	public int getSupportedReferenceCount() {
		return this.entityReferenceToCharacterMap.size();
	}

	public boolean isMappedToReference(char character) {
		return this.convertToReference(character) != null;
	}

	public String convertToReference(char character) {
		if (character < 1000 || character >= 8000 && character < 10000) {
			int index = character < 1000 ? character : character - 7000;
			String entityReference = this.characterToEntityReferenceMap[index];
			if (entityReference != null) {
				return entityReference;
			}
		}

		return null;
	}

	public char convertToCharacter(String entityReference) {
		Character referredCharacter = (Character) this.entityReferenceToCharacterMap.get(entityReference);
		return referredCharacter != null ? referredCharacter.charValue() : '?';
	}
}