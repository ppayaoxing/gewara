/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StringType;

public class GewaOracleDialect extends Oracle10gDialect {
	public GewaOracleDialect() {
		this.registerFunction("wmconcat", new StandardSQLFunction("WMSYS.WM_CONCAT", new StringType()));
		this.registerFunction("md5", new StandardSQLFunction("FN_MD5", new StringType()));
		this.registerFunction("gewarandom", new StandardSQLFunction("FN_RANDOM"));
	}
}