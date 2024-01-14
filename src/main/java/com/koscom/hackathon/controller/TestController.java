package com.koscom.hackathon.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value = "/")
	public String home(){

		return "hello-home!!!!";
	}

}