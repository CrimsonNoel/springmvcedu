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
@RequestMapping("/event")
public class EventController {
	
	private EventService eventService = new EventService();
	
	@ModelAttribute("recEventList")  //request.setAttribute("recEventList",return object)
	public List<Event> recommend() {
		return eventService.getRecommendedEventService();
	}
	
	
	@RequestMapping("/list")
	public String list(Model model, SearchOption option) {
		System.out.println(option);
		List<Event> eventList = eventService.getOpenedEventList(option);
		model.addAttribute("eventList", eventList);  //request.setAttribute
		model.addAttribute("eventTypes", EventType.values());
		return "event/list";
	}
	
	
	@RequestMapping("/list2")
	public ModelAndView list2(SearchOption option) {
		ModelAndView  mv = new ModelAndView();
		List<Event> eventList = eventService.getOpenedEventList(option);
		mv.addObject("eventList", eventList);  //request.setAttribute
		mv.addObject("eventTypes", EventType.values());
		mv.setViewName("event/list");
		return mv;
		
	}
	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyyMMdd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	private static final String REDIRECT_EVENT_LIST = "redirect:/event/list";
	
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request,    Model model) {
		String id = request.getParameter("id");
		if (id == null)
			return REDIRECT_EVENT_LIST;
		Long eventId = null;
		try {
			eventId = Long.parseLong(id);
		} catch (NumberFormatException e) {
			return REDIRECT_EVENT_LIST;
		}
		Event event = getEvent(eventId);
		if (event == null)
			return REDIRECT_EVENT_LIST;

		model.addAttribute("event", event);
		return "event/detail";  
		
	}
	private Event getEvent(Long eventId) {
		return eventService.getEvent(eventId);
	}
	
	@RequestMapping("/detail2")
	public String detail2(@RequestParam("id") long eventId,    Model model) {
	
		Event event = getEvent(eventId);
		if (event==null) {
			return REDIRECT_EVENT_LIST;
		}
		model.addAttribute("event", event);
		return "event/detail"; 
	}
	
}
