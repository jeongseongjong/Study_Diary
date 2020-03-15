package com.biz.study.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.study.domain.UserVO;
import com.biz.study.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService uService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "msg", required = false, defaultValue = "0") String msg, Model model) {

		model.addAttribute("msg", msg);

		return "user/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO userVO, Model model, HttpSession hSession) {

		boolean loginOk = uService.userLoginCheck(userVO);

		// service에서 Login 유효성검사 결과가 true라면
		if (loginOk == true) {
			
			// session에 담겨져있는 시간은 60초 * 60 = 1hour
			hSession.setMaxInactiveInterval(60 * 60);
			
			// getUser에서 findById된 u_id를 vo에 담아준다.
			userVO = uService.getUser(userVO.getU_id());
			
			// vo에서 받은 id 정보를 session에 저장된 시간동안 set해준다.
			hSession.setAttribute("userVO", userVO);
		}else {
			// removeAttribute : 요소의 속성을 제거한다.
			// httpSession에 있는 userVO를 제거하겠다.
			hSession.removeAttribute("userVO");
			model.addAttribute("msg","FAIL");
			return "redirect:/user/login";
		}

		return "redirect:/list";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession hSession) {
		
		hSession.setAttribute("userVO", null);
		hSession.removeAttribute("userVO");
		return "redirect:/list";
	}
		
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(Model model) {
		
		/*
		 * 아무것도 없는 vo이지만 view단에서 form태그를 사용했기 때문에
		 * 빈깡통이라도 model에 담아서 보내주어야
		 * view단에서 modelAttribute로 받을 수 있다. 
		 */
		UserVO userVO = new UserVO();
		
		model.addAttribute("userVO", userVO);
		return"user/join";
		
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(Model model, 
			@ModelAttribute("userVO") @Valid UserVO userVO,BindingResult bResult) {
		
		if(bResult.hasErrors()) {
			return "join";
		}else {
			int ret = uService.userJoin(userVO);
			return "redirect:/list";
		}
			
		
	}
	
	@ResponseBody
	@RequestMapping(value="/idcheck",method=RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public Boolean userIdCheck(@RequestParam(value="u_id", required = false, defaultValue ="0")String u_id, Model model){
		
		log.debug("ID {}",u_id );
		boolean idYes = uService.userIdCheck(u_id);
		log.debug("Result {}" , idYes);
		return idYes;
	}
	
//	@ResponseBody
//	@RequestMapping(value="/password", method=RequestMethod.GET)
//	public String passwordTest(String strText, Model model) {
//		
//		String cryptTest = passwordEncoder.encode(strText);
//		long textLeng = cryptTest.length();
//		
//		return cryptTest + ":" + textLeng;
//	}
}
