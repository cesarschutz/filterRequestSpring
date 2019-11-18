package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.filter.token.IdentifierAndTokenInterceptor;
import com.example.demo.filter.token.TokensDTO;

/**
 * Example of how to use the interceptor.
 *  
 * @author cesar.fagundes
 *
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	//@IgnoreIdentifierAndTokenInterceptor SERVE PARA IGNORAR O INTERCEPTOR
	@GetMapping("/identifier/{identifier}")
	public ResponseEntity<?> getAll(@PathVariable String identifier, @RequestHeader("Authorization") String authorization, HttpServletRequest request) {
		TokensDTO tokens = IdentifierAndTokenInterceptor.getTokens(request);
		return ResponseEntity.ok("identifier: " + identifier + " \nauthorization: " + authorization);
	}
}
