package com.asiainfo.commit_handler;

import java.util.Stack;

public class HandlerChain {
	private Stack<CheckHandler> chain;

	public Stack<CheckHandler> getChain() {
		return chain;
	}

	public void setChain(Stack<CheckHandler> chain) {
		this.chain = chain;
	}

	public void registerHandler(CheckHandler checkHandler) {
		chain.push(checkHandler);
	}

	public HandlerChain() {
		super();
	}

	public HandlerChain(Stack<CheckHandler> chain) {
		super();
		this.chain = chain;
	}

	public Boolean check(Context context) throws ContextNullException{
		for (CheckHandler checkHandler : chain) {
			if (checkHandler.check(context)) {
				continue;
			} else {
				throw new ContextNullException("检查不通过，请reset后，重新提交");
			}
		}
		return true;
	}
}
