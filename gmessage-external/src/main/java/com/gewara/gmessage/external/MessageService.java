/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external;

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
import java.util.Collection;

public abstract interface MessageService {
	public abstract ResultCode<String> sendMessage(String paramString1, Message paramMessage, String paramString2);

	public abstract ResultCode<Collection<ReceiverMessage>> findMessageListByReceiver(String paramString1,
			ReceiverQueryParam paramReceiverQueryParam, String paramString2);

	public abstract ResultCode<ReceiverMessage> findMessageByReceiver(MCategory paramMCategory, Long paramLong);

	public abstract ResultCode<UnReadCountResult> countUnReadMessage(String paramString, MUser paramMUser);

	public abstract ResultCode<String> updateMessageState(String paramString, UpdateMStateParam paramUpdateMStateParam);

	public abstract ResultCode<Collection<SendStateQueryResult>> findMessageStateByRelateID(String paramString,
			SendStateQueryParam paramSendStateQueryParam);

	public abstract ResultCode<UnReadCountResult> getUserUnReadCount(String paramString1,
			ReceiverQueryParam paramReceiverQueryParam, String paramString2);
}