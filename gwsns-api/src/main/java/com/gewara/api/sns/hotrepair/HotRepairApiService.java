package com.gewara.api.sns.hotrepair;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;

public interface HotRepairApiService {
	ResultCode<List<VoMap<String, String>>> getPatchList(String osType, String appVersion, String status, int from, int maxnum);
}
