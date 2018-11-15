package com.spring.register.persistence;

import com.spring.register.domain.AuthInfo;
import com.spring.register.domain.ChangeDTO;
import com.spring.register.domain.LoginDTO;
import com.spring.register.domain.RegisterDTO;

public interface RegisterDAO {
	//회원가입
	public int registMember(RegisterDTO dto);
	//아이디 중복
	public RegisterDTO selectById(String userid);
	
	//로그인
	public AuthInfo selectByMember(LoginDTO login);
	
	//비밀번호 변경
	public int changePwdMember(LoginDTO login);
}
