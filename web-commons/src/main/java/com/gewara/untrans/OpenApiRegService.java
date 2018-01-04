package com.gewara.untrans;

public interface OpenApiRegService {
	/**
	 * 注册openapi
	 * @param path
	 * @param data
	 */
	void registerOpenApi(String path, String data);

	/**
	 * 取消注册openapi
	 */
	void unregisterOpenApi();
}
