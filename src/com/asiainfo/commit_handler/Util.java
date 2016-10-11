package com.asiainfo.commit_handler;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理字符串的工具类，可以自定义工具类
 * @author Administrator
 *
 */
public class Util {

	public static List<Context> getContextList(String commitData) {
		List<Context> contextList = new ArrayList<Context>();
		String[] commitDataArray = commitData.trim().split(Tag.SEPARATOR_TAG);
		for (int i = 1; i < commitDataArray.length; i++) {
			Context context = parseString(commitDataArray[i]);
			contextList.add(context);
		}
		System.out.println(contextList.size());
		return contextList;
	}

	/**
	 * 根据标志解析String生成Context实体
	 * @param str
	 * @return Context
	 */
	private static Context parseString(String str) {
		String commitHash = getCommitStringByTags(str, Tag.HASH_TAG_PREF, Tag.HASH_TAG_SUF);
		String commitAuthor = getCommitStringByTags(str, Tag.AUTOR_TAG_PREF, Tag.AUTOR_TAG_SUF);
		String commitEmail = getCommitStringByTags(str, Tag.EMAIL_TAG_PREF, Tag.EMAIL_TAG_SUF);
		String commitNote = getCommitStringByTags(str, Tag.NOTE_TAG_PREF, Tag.NOTE_TAG_SUF);
		String timeStamp = getCommitStringByTags(str, Tag.DATE_TAG_PREF, Tag.DATE_TAG_SUF);
		ArrayList<String> commitSubjects = getCommitListByTags(str, Tag.SUBJECTS_TAG_PREF, Tag.SUBJECTS_TAG_SUF);
		Context context = new Context(commitHash, commitAuthor, commitEmail, commitNote, timeStamp, commitSubjects);
		return context;
	}

	public static String getCommitStringByTags(String str, String beginTag, String endTag) {
		int beginTagIndex = str.indexOf(beginTag) + beginTag.length();
		int endTagIndex = str.indexOf(endTag);
		String msg = str.substring(beginTagIndex, endTagIndex);
		return msg;
	}

	private static ArrayList<String> getCommitListByTags(String str, String beginTag, String endTag) {
		String[] strs = str.split(beginTag);
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i < strs.length; i++) {
			int endIndex = strs[i].indexOf(endTag);
			list.add(strs[i].substring(0, endIndex));
		}
		return list;
	}
}
