package com.emmaveletic.vjezba4.entities;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataDTO {

	String date;

	String time;
	
	Double value;

	long deviceId;
}
