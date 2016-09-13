package com.leon.test;

import com.asiainfo.commit_handler.CheckHandler;
import com.asiainfo.commit_handler.Context;

public class CheckHandlerImp implements CheckHandler {

	@Override
	public boolean check(Context context) {
		String regex = "";
		String commitNote = context.getCommitNote();
		if (commitNote.contains(regex)) {
			System.out.println(commitNote);
			return true;
		} else {
			System.out.println(context.getCommitNote());
			return false;
		}
	}

}
