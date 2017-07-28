/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package eu.bitwalker.useragentutils;

public enum RenderingEngine {
	EDGE_HTML("EdgeHTML"), TRIDENT("Trident"), WORD("Microsoft Office Word"), GECKO("Gecko"), WEBKIT("WebKit"), PRESTO(
			"Presto"), MOZILLA("Mozilla"), KHTML("KHTML"), BLINK("Blink"), OTHER("Other");

	String name;

	private RenderingEngine(String name) {
		this.name = name;
	}
}