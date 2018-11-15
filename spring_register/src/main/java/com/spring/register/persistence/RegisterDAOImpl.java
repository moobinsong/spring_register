package com.spring.register.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.register.domain.AuthInfo;
import com.spring.register.domain.ChangeDTO;
import com.spring.register.domain.LoginDTO;
import com.spring.register.domain.RegisterDTO;

@Repository
public class RegisterDAOImpl implements RegisterDAO {

	private final String namespace="mapper.registerMapper";
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int registMember(RegisterDTO dto) {		
		return sqlSession.insert(namespace+".regist", dto);
	}

	@Override
	public RegisterDTO selectById(String userid) {
		return sqlSession.selectOne(namespace+".selectById", userid);
	}

	@Override
	public AuthInfo selectByMember(LoginDTO login) {
		return sqlSession.selectOne(namespace+".selectByMember",login);
	}

	@Override
	public int changePwdMember(LoginDTO login) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".changePwd",login);
	}

	
}






