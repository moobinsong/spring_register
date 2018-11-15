package com.spring.register.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CommonException {
	private static final Logger logger=
			LoggerFactory.getLogger(CommonException.class);
	
	@ExceptionHandler(Exception.class)
	public String except(Exception ex,Model model) {
		logger.info("Exception...."+ex);
		model.addAttribute("exception",ex);
		return "error_page";
	}
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		logger.info("Page Not Found....");
		return "custom404";
	}
}
