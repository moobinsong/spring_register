package com.spring.register.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.register.domain.AuthInfo;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession(false);
		
		if(session!=null) {
			AuthInfo info=(AuthInfo)session.getAttribute("info");
			if(info!=null) //세션이 있는 경우 컨트롤러 호출하고 계속 작업 진행
				return true; 
		}
		//세션이 없는 경우 login으로 보내기
		response.sendRedirect(request.getContextPath()+"/login");
		return false;
		
	}
	
}
