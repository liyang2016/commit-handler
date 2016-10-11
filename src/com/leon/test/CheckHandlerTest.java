package com.leon.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;

import com.asiainfo.commit_handler.CheckHandler;
import com.asiainfo.commit_handler.Context;
import com.asiainfo.commit_handler.ContextNullException;
import com.asiainfo.commit_handler.HandlerChain;
import com.asiainfo.commit_handler.Util;

public class CheckHandlerTest {

	public static void main(String[] args) {
		testHandlerChain();
	}
	
	

	private static void testHandlerChain() {
		CheckHandlerImp checkHandlerImp1 = new CheckHandlerImp();
		CheckHandlerImp checkHandlerImp2 = new CheckHandlerImp();
		CheckHandlerImp checkHandlerImp3 = new CheckHandlerImp();
		HandlerChain chain = new HandlerChain(new Stack<CheckHandler>());
		chain.registerHandler(checkHandlerImp1);
		chain.registerHandler(checkHandlerImp2);
		chain.registerHandler(checkHandlerImp3);
		try {
			String commitContext=readBuffered(new File("resource//log"));
			List<Context> contexts=Util.getContextList(commitContext);
			for (Context context : contexts) {
				Boolean result = chain.check(context);
				System.out.println(result);
			}
		} catch (ContextNullException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	
	/*
	 * 读取信息 仅为了测试，使用时不需要该函数
	 */
	public static String readBuffered(File scrFile) throws IOException {
		if (!scrFile.exists()) {
			throw new IllegalArgumentException(scrFile + "不存在");
		}
		if (scrFile.isDirectory()) {
			throw new IllegalArgumentException(scrFile + "不是文件");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(scrFile)));
		String line;
		String commitContext = "";
		while ((line = br.readLine()) != null) {
			commitContext += line;
			commitContext += "\r\n";
		}
		br.close();
		return commitContext;
	}
}
