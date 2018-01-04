package com.gewara.api.gworder.vo;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

/**
 * 订单创建请求对象
 * <br>默认创建到进入业务处理逻辑节点超时时间为30秒
 * @author quzhuping
 *
 */
public class CreateOrderReq extends BaseVo {
	private static final long serialVersionUID = -6371087548888845993L;
	
	public  static final String TAG_MOVIE="movie";
	public  static final String TAG_DRAMA="drama";
	public  static final String TAG_GOODS="goods";
	
	protected String tag;				//movie、drama。。。
	protected String contextKey;		//上下文key
	protected String asyncQueueKey;		//异步响应队列key，请求端设置
	protected Long invalidTime;			//请求对象有效时间，超出有效时间抛弃该请求的后续处理
	protected Long memberId;			//关联用户
	protected Long relatedId;			//mpid,goodsid,ottid(sport),dpid(drama),pubid(pubsale),gci(gym),mctid(membercard)
	protected String remoteIp;			//用户ip
	protected String source;			//订单来源，用来标识订单来源：比如网站，Openapi
	public CreateOrderReq(){
		invalidTime = System.currentTimeMillis() + 60 * 1000;
	}
	
	public CreateOrderReq(String tag, String contextKey, String asyncQueueKey, String remoteIp, Long memberId, Long relatedId) {
		super();
		invalidTime = System.currentTimeMillis() + 60 * 1000;
		this.tag = tag;
		this.contextKey = contextKey;
		this.asyncQueueKey = asyncQueueKey;
		this.memberId = memberId;
		this.relatedId = relatedId;
		this.remoteIp = remoteIp;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public long getRelatedId() {
		return relatedId;
	}

	public Long getInvalidTime() {
		return invalidTime;
	}

	public void setInvalidTime(Long invalidTime) {
		this.invalidTime = invalidTime;
	}

	public String getContextKey() {
		return contextKey;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public void setRelatedId(Long relatedId) {
		this.relatedId = relatedId;
	}

	public void setContextKey(String contextKey) {
		this.contextKey = contextKey;
	}

	public String getAsyncQueueKey() {
		return asyncQueueKey;
	}
	

	public String getRemoteIp() {
		return remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}

	/**
	 * 设置异步响应队列key,发送消息到调用方机器
	 * @param asyncQueueKey 规则：queueName + systemId + systemhost
	 */
	public void setAsyncQueueKey(String asyncQueueKey) {
		this.asyncQueueKey = asyncQueueKey;
	}

	/**
	 * 生成唯一key,如果用户不指定则使用默认规则
	 * <br>异步上下文关联使用
	 * @return
	 */
	public String buildContextKey(){
		if(StringUtils.isBlank(contextKey)){
			contextKey =  memberId + ":" + tag + ":" + relatedId;
		}
		return contextKey;
	}
	
	/**
	 * 设置超时时间
	 * @param invalidTime
	 */
	public void setInvalidTime(long invalidTime, TimeUnit unit){
		this.invalidTime = System.currentTimeMillis() + unit.toMillis(invalidTime);
	}

	/**
	 * 是否是超时请求
	 * @return true 超时，false 未超时
	 */
	public boolean isTimeoutReq(){
		return (System.currentTimeMillis() - invalidTime) > 0;
	}
	
	@Override
	public Serializable realId() {
		return this.buildContextKey();
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
}
