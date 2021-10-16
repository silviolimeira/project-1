package br.com.sl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import com.sl.tool.Tool;
import com.sl.batch.*;
//import com.sl.data.JpaExample;


@Controller
public class HomeController {

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
