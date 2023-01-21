package com.emmaveletic.vjezba4.entities;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {

	private Integer statusCode;
	
	private String message;
	
	private Date timestamp;
}
