package com.ebuy.tax.auth.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2068328628491141217L;
	
	private String id;

	private String username;
	
	private String password;

}
