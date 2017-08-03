package com.gewara.api.sns.vo.qq;

import java.io.Serializable;
import java.util.Map;

import com.gewara.api.vo.BaseVo;

/**
 * QQ公众号模板消息
 * 
 */
public class TemplateMsgVo extends BaseVo {
	/**    
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）    
	 *    
	 * @since Ver 1.1    
	 */    
	
	private static final long serialVersionUID = 6643303791137590738L;
	private String tousermob;
	private String templateid;
	private String msgtype;
	private String type;
	private String key;
	private String url;
	private Map<String,DataValue> data;
	private Map<String, Button> buttonMap;
	
	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, Button> getButtonMap() {
		return buttonMap;
	}

	public void setButtonMap(Map<String, Button> buttonMap) {
		this.buttonMap = buttonMap;
	}
	
	
	public class DataValue {
		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
		public DataValue () {}
		
		
		public DataValue (String value) {
			this.value = value;
		}

	}
	
	public class Button {
		private String type;
		private String key;
		private String url;
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
	}

	public Map<String, DataValue> getData() {
		return data;
	}

	public void setData(Map<String, DataValue> data) {
		this.data = data;
	}

	public String getTousermob() {
		return tousermob;
	}

	public void setTousermob(String tousermob) {
		this.tousermob = tousermob;
	}

	@Override
	public Serializable realId() {
		return tousermob+""+templateid;
	}

}
