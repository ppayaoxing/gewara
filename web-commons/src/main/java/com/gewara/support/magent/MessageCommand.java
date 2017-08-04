package com.gewara.support.magent;

public interface MessageCommand {

	public static String NODATA = "!!nodata!!";
	public static String nodata = "!!nodata!!";
	public static String SUCCESS = "reply:success";
	public static String UNKNOWN = "unknown command, please type ¡°help¡± for help!";

	String getName();

	String getGroup();

	String getHelp();

	String getReply(String[] cmd);
}
