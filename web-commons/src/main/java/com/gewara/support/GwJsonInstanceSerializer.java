package com.gewara.support;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.details.InstanceSerializer;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gewara.untrans.ServiceDetails;
import com.gewara.util.BindUtils;

public class GwJsonInstanceSerializer<T extends ServiceDetails> implements InstanceSerializer<T> {

	private final ObjectMapper mapper;
	private final Class<T> payloadClass;
	private final JavaType type;

	public GwJsonInstanceSerializer(Class<T> payloadClass) {
		this.payloadClass = payloadClass;
		mapper = new ObjectMapper();
		type = mapper.getTypeFactory().constructType(ServiceInstance.class);
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public ServiceInstance<T> deserialize(byte[] bytes) throws Exception {
		ServiceInstance<Map> si = mapper.readValue(bytes, type);
		T payload =  payloadClass.newInstance();
		BindUtils.bindData(payload, si.getPayload());
		return new ServiceInstance<T>(si.getName(), si.getId(), si.getAddress(), si.getPort(), si.getSslPort(), payload, si.getRegistrationTimeUTC(), si.getServiceType(), si.getUriSpec());
	}

	@Override
	public byte[] serialize(ServiceInstance<T> instance) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		mapper.writeValue(out, instance);
		return out.toByteArray();
	}
}
