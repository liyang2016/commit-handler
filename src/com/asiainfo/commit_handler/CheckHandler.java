package com.asiainfo.commit_handler;

import com.asiainfo.commit_handler.Context;

public interface CheckHandler {

	/*
	 * 验证对象信息是否符合要求
	 */
	public boolean check(Context context);

}
