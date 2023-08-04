package controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController2 {
	
	
	@RequestMapping("/hello.do2")
	public String hello() {
		
		return "index2";
	}
	
	
	

}
