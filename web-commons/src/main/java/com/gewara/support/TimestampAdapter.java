package com.gewara.support;

import java.sql.Timestamp;

import javax.xml.bind.annotation.adapters.XmlAdapter;
public class TimestampAdapter extends XmlAdapter<String, Timestamp> {
	@Override
	public String marshal(Timestamp v) throws Exception {
		return v.toString();
	}
	@Override
	public Timestamp unmarshal(String v) throws Exception {
		return Timestamp.valueOf(v);
	}

}
