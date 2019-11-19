package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
//	@IgnoreIdentifierAndTokenInterceptor
	@GetMapping("/identifier/{identifier}")
	public ResponseEntity<?> getAll(@PathVariable String identifier, @RequestHeader("Authorization") String authorization, 
			@PathVariable TokensDTO tokens) {
		return ResponseEntity.ok().build();
	}
}
