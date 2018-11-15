package com.spring.register.domain;

public class LoginDTO {
	//로그인 폼에서 전송되는 데이터 담는 객체
	private String userid;
	private String current_password;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCurrent_password() {
		return current_password;
	}
	public void setCurrent_password(String current_password) {
		this.current_password = current_password;
	}
}
