package com.gewara.untrans;

public interface OpenApiRegService {
	/**
	 * ×¢²áopenapi
	 * @param path
	 * @param data
	 */
	void registerOpenApi(String path, String data);

	/**
	 * È¡Ïû×¢²áopenapi
	 */
	void unregisterOpenApi();
}
