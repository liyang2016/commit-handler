package com.leon.test;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Stack;

import com.asiainfo.commit_handler.CheckHandler;
import com.asiainfo.commit_handler.Context;
import com.asiainfo.commit_handler.HandlerChain;
import com.asiainfo.commit_handler.Service;

public class CheckHandlerTest {

	public static void main(String[] args) {
		testHandlerChain();
	}

	public static void testHandlerChain() {
		CheckHandlerImp checkHandlerImp1 = new CheckHandlerImp();
		CheckHandlerImp checkHandlerImp2 = new CheckHandlerImp();
		CheckHandlerImp checkHandlerImp3 = new CheckHandlerImp();
		HandlerChain chain = new HandlerChain(new Stack<CheckHandler>());
		chain.registerHandler(checkHandlerImp1);
		chain.registerHandler(checkHandlerImp2);
		chain.registerHandler(checkHandlerImp3);
		Service service = new Service(new File("resource//log1"));
		Map<String, Context> map = null;
		try {
			map = service.getContextMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Map.Entry<String, Context> entry : map.entrySet()) {
			Context context = chain.check(entry.getValue());
			System.out.println(context);
		}
	}
}
