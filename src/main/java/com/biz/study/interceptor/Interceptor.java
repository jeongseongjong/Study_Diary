package com.biz.study.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Interceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// url의 전체적인 값
		String urlPath = request.getRequestURL().toString();
		
		// url의 자세한 값
		String uriPath = request.getRequestURI().toString();
		
		String msg = String.format("URL : %S, \n URI : %S", urlPath, uriPath);
		
		// session에 등록된 정보를 불러와 HttpSession객체에 주입
		HttpSession session = request.getSession();
		
		// user session을 확인하기 위해 Attribute하여 userVO추출
		// Object객체에 userVO정보 담기
		Object sessionObj = session.getAttribute("userVO");
		
		if(sessionObj == null) {
			
			// login 경로를 확실히 지정해주어 redirect를 수행하게 한다.
			response.sendRedirect(request.getContextPath() + "/user/login");
			
			return false;
			
		}
		
		// url과 uri가 제대로 찍히는지 확인하자
		log.debug(msg);
		
		return super.preHandle(request, response, handler);
	}

	
}
