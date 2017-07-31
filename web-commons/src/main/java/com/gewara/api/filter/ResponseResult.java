package com.gewara.api.filter;

import com.alibaba.dubbo.rpc.RpcResult;
import com.gewara.api.vo.ResultCode;

public class ResponseResult extends RpcResult{
		private static final long serialVersionUID = 6016707108550302385L;
		public ResponseResult(ResultCode result) {
			super(result);
		}
		@Override
		public ResultCode getValue() {
			return (ResultCode) super.getValue();
		}
	}