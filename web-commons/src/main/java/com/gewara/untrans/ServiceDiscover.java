/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.untrans.ServiceDetails;
import java.util.List;
import org.apache.curator.x.discovery.ServiceInstance;

public interface ServiceDiscover {
	List<ServiceInstance<ServiceDetails>> getServiceInstance(String arg0) throws Exception;

	List<ServiceInstance<ServiceDetails>> getServiceInstance(String arg0, String arg1) throws Exception;
}