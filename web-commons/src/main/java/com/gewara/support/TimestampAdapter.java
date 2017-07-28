/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import java.sql.Timestamp;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TimestampAdapter extends XmlAdapter<String, Timestamp> {
	public String marshal(Timestamp v) throws Exception {
		return v.toString();
	}

	public Timestamp unmarshal(String v) throws Exception {
		return Timestamp.valueOf(v);
	}
}