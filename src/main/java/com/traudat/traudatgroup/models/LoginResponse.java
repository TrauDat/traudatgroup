package com.traudat.traudatgroup.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginResponse {
	private String accessToken;
	private String tokenType = "Bearer ";
	
	public LoginResponse(String accessToken) {
		this.accessToken = accessToken;
	}
	
	
}
