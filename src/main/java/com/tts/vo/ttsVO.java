package com.tts.vo;

public class ttsVO {
	private String id;
	private String test;
	

	public ttsVO() {
	}


	public ttsVO(String id, String test) {
		super();
		this.id = id;
		this.test = test;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTest() {
		return test;
	}


	public void setTest(String test) {
		this.test = test;
	}


}
