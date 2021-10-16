package br.com.sl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	//@CrossOrigin(origins="http://localhost:9090")
	@GetMapping("/home")
	public String sayHello(Model theModel) {
		theModel.addAttribute("dateServer", new java.util.Date());

		//Tool tool = new Tool();
		//System.out.println(tool.getGreeting());
		
		// Test Quartz
		//QuartzExample.test();

		return "home";
	}

}
