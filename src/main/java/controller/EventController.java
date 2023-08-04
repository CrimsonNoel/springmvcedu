package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import event.Event;
import event.EventService;
import event.EventType;
import event.SearchOption;



@Controller
@RequestMapping("/event/")
public class EventController {
	
	private EventService eventService = new EventService();
	
	
	
	
	@RequestMapping("list")
	public String list(Model model, SearchOption option) {
		System.out.println(option);
		List<Event> eventList = eventService.getOpenedEventList(option);
		model.addAttribute("eventList", eventList);  //request.setAttribute
		model.addAttribute("eventTypes", EventType.values());
		return "event/list";
	}	
	
	}	
	
}
