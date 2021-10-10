package br.com.sl.controller;

import com.sl.data.CustomerTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String sayHello(Model theModel) {
		theModel.addAttribute("dateServer", new java.util.Date());

		//Tool tool = new Tool();
		//System.out.println(tool.getGreeting());
		
		// Test Quartz
		//QuartzExample.test();

		//JpaExample.test();

		CustomerTest.test();

		return "home";
	}

}
