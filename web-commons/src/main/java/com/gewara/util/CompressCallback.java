package com.gewara.util;

import java.io.File;

public interface CompressCallback {
	void onComplete(File destFile, long oldsize, long newsize);
	void onFailure();
}
