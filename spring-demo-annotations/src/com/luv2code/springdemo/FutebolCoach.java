package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FutebolCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "Run a 15 miles";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
