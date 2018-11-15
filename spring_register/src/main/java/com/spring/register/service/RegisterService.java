package com.spring.register.service;

import com.spring.register.domain.AuthInfo;
import com.spring.register.domain.ChangeDTO;
import com.spring.register.domain.LoginDTO;
import com.spring.register.domain.RegisterDTO;

public interface RegisterService {
	//dao의 메소드 호출
	public int registMember(RegisterDTO dto);
	public RegisterDTO selectById(String userid); 
	//로그인
	public AuthInfo selectByMember(LoginDTO login);
	
	//비밀번호 변경
	public int changePwdMember(LoginDTO login);
	
}
