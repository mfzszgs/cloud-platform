package com.scutpress.cloud.pressofficewechat.dao;

import com.scutpress.cloud.pressofficewechat.domain.Msg;

public interface MsgCallbackHandler {
	public void processMsg(Msg msg);
}
