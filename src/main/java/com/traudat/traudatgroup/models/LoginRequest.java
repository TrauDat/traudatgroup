package com.traudat.traudatgroup.models;

import lombok.Data;

@Data
public class LoginRequest {
	private String username;
	
	private String password;
}
