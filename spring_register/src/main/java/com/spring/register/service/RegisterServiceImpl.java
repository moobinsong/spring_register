package com.spring.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.register.domain.AuthInfo;
import com.spring.register.domain.ChangeDTO;
import com.spring.register.domain.LoginDTO;
import com.spring.register.domain.RegisterDTO;
import com.spring.register.persistence.RegisterDAO;

@Service("member")
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterDAO dao;
	
	@Override
	public int registMember(RegisterDTO dto) {		
		return dao.registMember(dto);
	}

	@Override
	public RegisterDTO selectById(String userid) {
		return dao.selectById(userid);
	}
	
	@Override
	public AuthInfo selectByMember(LoginDTO login) {		
		return dao.selectByMember(login);
	}

	@Override
	public int changePwdMember(LoginDTO login) {
		// TODO Auto-generated method stub
		return dao.changePwdMember(login);
	}
	
	
}








