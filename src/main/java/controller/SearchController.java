package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

	@RequestMapping("/search")
	public String search(@RequestParam(value = "q", 
	defaultValue="defaultValue") String query,
			Model model) {
		System.out.println("검색어: " + query);
		model.addAttribute("q", query);
		return "search/result";
	}
	
}
