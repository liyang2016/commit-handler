package com.leon.test;

import com.asiainfo.commit_handler.CheckHandler;
import com.asiainfo.commit_handler.Context;

public class CheckHandlerImp implements CheckHandler {

	@Override
	public boolean check(Context context) {
		String regex = "mod";
		String commitNote = context.getCommitNote();
		if (commitNote.contains(regex)) {
			return true;
		} else {
			return false;
		}
	}

}
