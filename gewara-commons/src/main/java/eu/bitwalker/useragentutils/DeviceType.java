/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package eu.bitwalker.useragentutils;

public enum DeviceType {
	COMPUTER("Computer"), MOBILE("Mobile"), TABLET("Tablet"), GAME_CONSOLE("Game console"), DMR(
			"Digital media receiver"), WEARABLE("Wearable computer"), UNKNOWN("Unknown");

	String name;

	private DeviceType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}