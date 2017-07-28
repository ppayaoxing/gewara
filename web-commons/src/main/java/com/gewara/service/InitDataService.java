/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.service;

public interface InitDataService {
	void startInit(String arg0, Runnable arg1);

	void delayInit(String arg0, Runnable arg1, long arg2);
}