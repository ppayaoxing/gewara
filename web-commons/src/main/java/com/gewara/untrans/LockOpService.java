/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

public interface LockOpService {
	Long updateOperation(String arg0, int arg1);

	void resetOperation(String arg0, Long arg1);

	Long updateFlagOperation(String arg0, int arg1, String arg2);

	void resetFlagOperation(String arg0, String arg1);
}