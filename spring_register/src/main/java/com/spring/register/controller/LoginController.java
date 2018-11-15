package com.spring.register.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.register.domain.AuthInfo;
import com.spring.register.domain.ChangeDTO;
import com.spring.register.domain.LoginDTO;
import com.spring.register.service.RegisterService;

@Controller
public class LoginController {
	private static final Logger logger=
			LoggerFactory.getLogger(LoginController.class);
	@Inject
	private RegisterService service;
	
	@GetMapping("/login")
	public String loginGet() {
		logger.info("로그인 폼 보여주기.....");
		return "signin";
	}
	
	/*@PostMapping("/login")
	public void loginPost() {
		logger.info("로그인 실행.....");
	}*/
	
	@PostMapping("/login")
	public String loginPost(LoginDTO dto,HttpSession session,RedirectAttributes rttr, Model model) {
		logger.info("로그인실행");
		AuthInfo info=service.selectByMember(dto);
		if(info==null) {
			model.addAttribute("error", "아이디나 비밀번호를 확인해주세요.");
			//rttr.addFlashAttribute("error", "아이디나 비밀번호를 확인해 주세요.");
			return "signin";
		}else {
			session.setAttribute("info", info);
			return "redirect:index";
		}
	
	}
	@GetMapping("/logout")
	public String logoutGet(HttpSession session) {
		logger.info("로그아웃 처리");
		session.removeAttribute("info");
		return "index";
	}
	
	//changePwd 폼 띄우기
	@GetMapping("/changePwd")
	public void changePwdGet() {
		logger.info("changePwd 폼 띄우기");
	}

	@PostMapping("/changePwd")
	public String changePwdPost(@ModelAttribute("change")ChangeDTO change,HttpSession session,Model model) {
		logger.info("changePwd 폼 정보 가져오기");
		//기존 세션에 있는 아이디와 비밀번호를 넘겨서 있는 사용자이라면
		// 아이디 : 세션,  기존 비밀번호 : ChangeDTO객체 안의 password
		AuthInfo info=(AuthInfo) session.getAttribute("info");

		LoginDTO login=new LoginDTO();
		login.setUserid(info.getUserid()); 
		login.setCurrent_password(change.getCurrent_password());

		AuthInfo auth=service.selectByMember(login);				
		//비밀번호를 변경
		// 새 비밀번호 : ChangeDTO객체 안의 new_password
		if(auth!=null) { //비밀번호 변경하는 서비스 메소드 호출 후 세션 종료 index로 이동
			login.setCurrent_password(change.getNew_password());
			service.changePwdMember(login);			
			session.removeAttribute("info");
			return "redirect:/index";				
		}else {  //다시 changePwd로 보내기
			model.addAttribute("error", "비밀번호를 확인해 주세요");	
			return "/changePwd";
		}		
	}
	
	@GetMapping("/except")
	public void exceptionGet(int no) {
		logger.info("Exception 발생....");
	}
}



