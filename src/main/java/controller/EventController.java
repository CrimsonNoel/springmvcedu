package controller;


import java.util.List;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
		return "event/list";  //WEB-INF/view/event/list.jsp
	}	
	
	}	
	

