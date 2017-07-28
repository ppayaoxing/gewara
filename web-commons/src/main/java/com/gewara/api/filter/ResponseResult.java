/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.api.filter;

import com.alibaba.dubbo.rpc.RpcResult;
import com.gewara.api.vo.ResultCode;

public class ResponseResult extends RpcResult {
	private static final long serialVersionUID = 6016707108550302385L;

	public ResponseResult(ResultCode result) {
		super(result);
	}

	public ResultCode getValue() {
		return (ResultCode) super.getValue();
	}
}