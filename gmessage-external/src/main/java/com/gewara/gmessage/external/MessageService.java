package com.gewara.gmessage.external;

import java.util.Collection;

import com.gewara.api.vo.ResultCode;
import com.gewara.gmessage.external.constant.MCategory;
import com.gewara.gmessage.external.entity.MUser;
import com.gewara.gmessage.external.entity.Message;
import com.gewara.gmessage.external.entity.ReceiverMessage;
import com.gewara.gmessage.external.entity.ReceiverQueryParam;
import com.gewara.gmessage.external.entity.SendStateQueryParam;
import com.gewara.gmessage.external.entity.SendStateQueryResult;
import com.gewara.gmessage.external.entity.UnReadCountResult;
import com.gewara.gmessage.external.entity.UpdateMStateParam;

/**
 * 消息对外接口。
 * @author 董明
 * @createDate 2015年3月9日
 */
public interface MessageService {

	/**
	 * 发送消息
	 * 
	 * @param source 系统来源
	 * @param message 消息体
	 * @param version 指定数据版本，不指定，默认为 0.0
	 * @return 成功 返回消息ID，失败，返回失败代码。
	 */
	ResultCode<String> sendMessage(String source,Message message,String version);
	
	/**
	 * 用户的所有消息（已过期消息和已删除消息不包含在内），按照发送时间时间倒序进行排列。
	 * 如果查询所有的消息，未读消息会排在前面。 
	 * NOTE：reciveTimes 如果不设置，默认会使用上一次查询时间，该时间的最大值为半年内。
	 * @param source 系统来源
	 * @param query 查询条件
	 * @param version 指定最低版本。 高于或者等于该版本的数据才会返回。
	 * @return 返回消息列表
	
	 * @return
	 */
	ResultCode<Collection<ReceiverMessage>> findMessageListByReceiver(String source,ReceiverQueryParam query,String version);
	
	/**
	 * 查询单个消息
	 * @param category
	 * @param messageID
	 * @return
	 */
	ResultCode<ReceiverMessage> findMessageByReceiver(MCategory category, Long messageID);
	
	
	/**
	 * 统计未读消息
	 * @param source 系统来源
	 * @param receiver 接收者用户信息
	 * @return 返回消息种类统计结果
	 */
	ResultCode<UnReadCountResult> countUnReadMessage(String source,MUser receiverID);
	
	
	/**
	 * 更新用户消息状态。
	 * @param source
	 * @param param
	 * @return
	 */
	ResultCode<String> updateMessageState(String source,UpdateMStateParam param);
	
	/**
	 * 获取消息的发送情况.
	 * 本系统无法获取push，sms等的发送状态。
	 * @param source  系统来源 
	 * @param messageID  消息ID
	 * @return 返回消息发送情况
	 */
	ResultCode<Collection<SendStateQueryResult>> findMessageStateByRelateID(String source,SendStateQueryParam query);
	
	/**
	 * 根本版本获取用户的未读消息数量
	 * @param source
	 * @param query
	 * @param version
	 * @return
	 */
	ResultCode<UnReadCountResult> getUserUnReadCount(String source, ReceiverQueryParam query, String version);
	
	/**
	 * 屏蔽某一类消息，或者某一发送者的消息。二者必须填写一个，占坑
	 * 发送者ID和发送者类型
	 * @param source 系统来源
	 * @param messageType 消息类型
	 * @param sender  发送者
	 * @return 
	 */
	//OperateResult shieldMessage(String source,Short messageType,MUser sender);
	
	/**======================================================*/
	/**
	 * 用户的所有消息，按照发送时间倒序进行排列。
	 * @param source 系统来源
	 * @param query 查询条件
	 * @return 返回指定发送者的消息列表
	 */
	//Collection<SenderMessage> findMessageListBySender(String source,SenderQueryParam query);
	
	/**
	 * 屏蔽消息，屏蔽后，所有接收者都将接受不到该消息
	 * @param messageID
	 * @return
	 * 
	 */
	//updateResult shieldMessage(long messageID);
}
