package com.scutpress.cloud.publicwechat.dao;

import com.scutpress.cloud.publicwechat.domain.Msg;

public interface MsgCallbackHandler {
	public void processMsg(Msg msg);
}
