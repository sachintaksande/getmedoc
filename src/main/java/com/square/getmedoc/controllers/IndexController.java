package com.square.getmedoc.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@RequestMapping(value="/")
public class IndexController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(){
		return "redirect:index.html";
	}
}
