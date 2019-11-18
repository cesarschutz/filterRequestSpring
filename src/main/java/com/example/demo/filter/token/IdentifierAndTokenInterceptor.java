package com.example.demo.filter.token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class IdentifierAndTokenInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		System.out.println("---Request Completed---");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("---method executed---");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

//		HandlerMethod handlerMethod = (HandlerMethod) handler;
//
//		String emailAddress = request.getParameter("emailaddress");
//		String password = request.getParameter("password");
//
//		if (StringUtils.isEmpty(emailAddress) || StringUtils.containsWhitespace(emailAddress)
//				|| StringUtils.isEmpty(password) || StringUtils.containsWhitespace(password)) {
//			throw new Exception("Invalid User Id or Password. Please try again.");
//		}
//
//		return true;
		System.out.println("---method vai executar---");

		return true;
	}

}
