package controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.LombokObject;



@RestController
public class LombokController {
	
	
	@RequestMapping("/lombok/json")
	public LombokObject json(LombokObject  lo) {
		lo.setName("lombok name");
		lo.setAge(100);
		lo.setLine("lombok test 중입니다");
		return lo;
	}
	
	
	

}


