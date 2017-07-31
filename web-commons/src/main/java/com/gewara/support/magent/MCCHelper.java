package com.gewara.support.magent;

/**
 * ÃüÁîÖĞĞÄ°ïÖúÀà
 * @author gebiao(ge.biao@gewara.com)
 * @since Feb 27, 2014 8:34:53 PM
 */
public class MCCHelper {
	private static MessageCommandCenter mcc;
	static{
		mcc = new MessageCommandCenter();
		mcc.registerGroup(new JVMCommandProcessorGroup());
		mcc.registerGroup(new MethodCommandProcessorGroup());
	}
	public static MessageCommandCenter getDefaultInstance(){
		return mcc;
	}
}
