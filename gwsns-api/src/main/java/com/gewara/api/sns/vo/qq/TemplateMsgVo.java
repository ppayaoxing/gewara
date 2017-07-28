/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.qq;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.util.Map;

public class TemplateMsgVo extends BaseVo {
	private static final long serialVersionUID = 6643303791137590738L;
	private String tousermob;
	private String templateid;
	private String msgtype;
	private String type;
	private String key;
	private String url;
	private Map<String, TemplateMsgVo.DataValue> data;
	private Map<String, TemplateMsgVo.Button> buttonMap;

	public String getTemplateid() {
		return this.templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public String getMsgtype() {
		return this.msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, TemplateMsgVo.Button> getButtonMap() {
		return this.buttonMap;
	}

	public void setButtonMap(Map<String, TemplateMsgVo.Button> buttonMap) {
		this.buttonMap = buttonMap;
	}

	public Map<String, TemplateMsgVo.DataValue> getData() {
		return this.data;
	}

	public void setData(Map<String, TemplateMsgVo.DataValue> data) {
		this.data = data;
	}

	public String getTousermob() {
		return this.tousermob;
	}

	public void setTousermob(String tousermob) {
		this.tousermob = tousermob;
	}

	public Serializable realId() {
		return this.tousermob + "" + this.templateid;
	}

	public class Button {
		private String type;
		private String key;
		private String url;

		public String getType() {
			return this.type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getKey() {
			return this.key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getUrl() {
			return this.url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}

	public class DataValue {
		private String value;

		public String getValue() {
			return this.value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public DataValue() {
		}

		public DataValue(String value) {
			this.value = value;
		}
	}
}