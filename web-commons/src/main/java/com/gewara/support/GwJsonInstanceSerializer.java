/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gewara.untrans.ServiceDetails;
import com.gewara.util.BindUtils;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.details.InstanceSerializer;

public class GwJsonInstanceSerializer<T extends ServiceDetails> implements InstanceSerializer<T> {
	private final ObjectMapper mapper;
	private final Class<T> payloadClass;
	private final JavaType type;

	public GwJsonInstanceSerializer(Class<T> payloadClass) {
		this.payloadClass = payloadClass;
		this.mapper = new ObjectMapper();
		this.type = this.mapper.getTypeFactory().constructType(ServiceInstance.class);
	}

	public ServiceInstance<T> deserialize(byte[] bytes) throws Exception {
		ServiceInstance si = (ServiceInstance) this.mapper.readValue(bytes, this.type);
		ServiceDetails payload = (ServiceDetails) this.payloadClass.newInstance();
		BindUtils.bindData(payload, (Map) si.getPayload());
		return new ServiceInstance(si.getName(), si.getId(), si.getAddress(), si.getPort(), si.getSslPort(), payload,
				si.getRegistrationTimeUTC(), si.getServiceType(), si.getUriSpec());
	}

	public byte[] serialize(ServiceInstance<T> instance) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		this.mapper.writeValue(out, instance);
		return out.toByteArray();
	}
}