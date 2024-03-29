package com.example.demo.filter.token;

import java.lang.reflect.Parameter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Interceptor to query tokens.
 *  
 * @author cesar.fagundes
 *
 */
@Component
public class IdentifierAndTokenInterceptor extends HandlerInterceptorAdapter {

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		//validate whether to ignore the interceptor
		HandlerMethod handlerMethod = (HandlerMethod) handler;		
		IgnoreIdentifierAndTokenInterceptor ignoreIdentifierAndTokenInterceptor = handlerMethod.getMethod().getAnnotation(IgnoreIdentifierAndTokenInterceptor.class);
		if (ignoreIdentifierAndTokenInterceptor != null) return super.preHandle(request, response, handler);
		
		//get authorization in request
		String authorization = request.getHeader("Authorization");
		
		//get identifier in request
		Map<String, Object> pathVariables = (Map<String, Object>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		String identifier = (String) pathVariables.get("identifier");

		//get Tokens in srm-login-client-app
		TokensDTO tokens = getTokens(authorization, identifier);
		
		//set atribute		
		pathVariables.put("tokens", tokens);
		
		return super.preHandle(request, response, handler);
	}
	
	private TokensDTO getTokens(String authorization, String identifier) throws Exception {
		//valid identifier and authorization
		validateIdentifierAndAuthorizationRequest(authorization, identifier);
		
		TokensDTO authorizationTokenIdentifierDTO = new TokensDTO();
		
		//TODO chamar srm-login-client-app
		
		//mock
		authorizationTokenIdentifierDTO.setAuthorizationHB("authorizationHB");
		authorizationTokenIdentifierDTO.setAuthorizationM18("authorizationM18");
		return authorizationTokenIdentifierDTO;
	}
	
	private void validateIdentifierAndAuthorizationRequest(String authorization, String identifier) throws Exception {
		if (StringUtils.isEmpty(authorization) || StringUtils.isEmpty(identifier)
				|| StringUtils.containsWhitespace(authorization) || StringUtils.containsWhitespace(identifier)){
			throw new Exception();
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		super.afterCompletion(request, response, handler, exception);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
