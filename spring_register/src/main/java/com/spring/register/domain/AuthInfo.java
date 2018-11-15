package com.spring.register.domain;

public class AuthInfo {
	//로그인 성공시 개인 정보 담는 객체
	private String userid;
	private String name;
	@Override
	public String toString() {
		return "AuthInfo [userid=" + userid + ", name=" + name + "]";
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
