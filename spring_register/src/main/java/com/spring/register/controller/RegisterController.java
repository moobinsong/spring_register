package com.spring.register.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.register.domain.RegisterDTO;
import com.spring.register.service.RegisterService;

@Controller
public class RegisterController {
	private static final Logger logger=
			LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	private RegisterService service;
	
	
	//@RequestMapping("/step1")
	@GetMapping("/step1")
	public void handleStep1() {
		//① step1.jsp 보여주기
		logger.info("===== step1.jsp 보여주기 =====");
	}
	
	@RequestMapping(value="/step2",method=RequestMethod.POST) //post처리되있어서 주소에서 2를 넣으면 에러 1->2로 거쳐야뜸
	public String handleStep2(boolean agree) {		
		logger.info("===== step1.jsp 정보 가져오기 =====");
		logger.info("===== step2.jsp 보여주기 =====");
		
		if(!agree) { //step1으로 돌려보내기
			return "redirect:/step1";
		}else {//step2 보여주기
			return "step2";
		}
	}
	
	@RequestMapping(value="/step3",method=RequestMethod.POST)
	public String handleStep3(@ModelAttribute("dto")RegisterDTO dto) {
		logger.info("===== 회원가입요청 =====");
		//step2.jsp에 있는 내용 가져오기
		//작업이 끝난 후 step3.jsp로 이동
		service.registMember(dto);
		return "step3";
	}
	
	//아이디 중복
	@PostMapping("/checkId")
	@ResponseBody //리턴되는 값을 보내기 위해서 반드시 필요 밑에 false랑 true부분
	public String checkId(String userid) {
		logger.info("중복 아이디 검사");
		//db확인
		RegisterDTO dto=service.selectById(userid);
		if(dto!=null)//아이디 중복일때
			return "false";
		else
			return "true";
	}
	
	//사용자가 직접 접근하여 step2, step3를 요청할 때 step1으로 이동시키기
	@RequestMapping(value= {"/step2","step3"},method=RequestMethod.GET)
	public String handleStepGet() {
		return "redirect:/step1";
		
	}
}









