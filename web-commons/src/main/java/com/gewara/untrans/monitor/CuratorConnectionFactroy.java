/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor;

import java.io.IOException;
import org.apache.curator.framework.CuratorFramework;

public interface CuratorConnectionFactroy {
	CuratorFramework getCuratorFramework() throws IOException;

	void init() throws IOException;
}