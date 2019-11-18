package com.example.demo.filter.token;

/**
 * Data returned after project login without login-client-app.
 * 
 * @author cesar.fagundes
 *
 */
public class TokensDTO {

	/**
	 * token for home bank. 
	 */
	private String authorizationHB;
	
	/**
	 * token for M18. 
	 */
	private String authorizationM18;

	public String getAuthorizationHB() {
		return authorizationHB;
	}

	public void setAuthorizationHB(String authorizationHB) {
		this.authorizationHB = authorizationHB;
	}

	public String getAuthorizationM18() {
		return authorizationM18;
	}

	public void setAuthorizationM18(String authorizationM18) {
		this.authorizationM18 = authorizationM18;
	}
}
