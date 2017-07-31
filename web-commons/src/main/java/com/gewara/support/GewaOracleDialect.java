package com.gewara.support;

import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StringType;

public class GewaOracleDialect extends Oracle10gDialect{
	public GewaOracleDialect(){
		super();
		registerFunction( "wmconcat", new StandardSQLFunction("WMSYS.WM_CONCAT", new StringType()) );
		registerFunction( "md5", new StandardSQLFunction("FN_MD5", new StringType()) );
		registerFunction( "gewarandom", new StandardSQLFunction("FN_RANDOM") );
	}

}
