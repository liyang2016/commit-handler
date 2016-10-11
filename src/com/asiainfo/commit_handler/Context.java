package com.asiainfo.commit_handler;

import java.util.ArrayList;

public class Context {

	@Override
	public String toString() {
		return "Context [commitHash=" + commitHash + ", commitAuthor=" + commitAuthor + ", commitEmail=" + commitEmail
				+ ", commitNote=" + commitNote + ", timeStamp=" + timeStamp + ", commitSubject=" + commitSubject + "]";
	}

	private String commitHash; // 提交的Hash码
	private String commitAuthor; // 提交作者
	private String commitEmail;// 提交作者的邮箱
	private String commitNote;// 提交的注释
	private String timeStamp; // Unix timestamp
	private ArrayList<String> commitSubject;// 提交对比前一次变更的文件名

	public Context() {
		super();
	}

	public String getCommitHash() {
		return commitHash;
	}

	public void setCommitHash(String commitHash) {
		this.commitHash = commitHash;
	}

	public String getCommitAuthor() {
		return commitAuthor;
	}

	public void setCommitAuthor(String commitAuthor) {
		this.commitAuthor = commitAuthor;
	}

	public String getCommitEmail() {
		return commitEmail;
	}

	public void setCommitEmail(String commitEmail) {
		this.commitEmail = commitEmail;
	}

	public String getCommitNote() {
		return commitNote;
	}

	public void setCommitNote(String commitNote) {
		this.commitNote = commitNote;
	}

	public ArrayList<String> getCommitSubject() {
		return commitSubject;
	}

	public void setCommitSubject(ArrayList<String> commitSubject) {
		this.commitSubject = commitSubject;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Context(String commitHash, String commitAuthor, String commitEmail, String commitNote, String timeStamp,
			ArrayList<String> commitSubject) {
		super();
		this.commitHash = commitHash;
		this.commitAuthor = commitAuthor;
		this.commitEmail = commitEmail;
		this.commitNote = commitNote;
		this.timeStamp = timeStamp;
		this.commitSubject = commitSubject;
	}

}
