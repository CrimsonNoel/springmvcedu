package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import member.MemberRegistRequest;
import member.MemberRegistValidator;
import service.MemberService;





@Controller
@RequestMapping("/member/regist")
public class RegistrationController {
	private static final String MEMBER_REGISTRATION_FORM = "member/registrationForm";
	//@Autowired
	//MemberService memberService;
	
//	@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String form(@ModelAttribute("memberInfo") MemberRegistRequest memRegReq) {
		return MEMBER_REGISTRATION_FORM;
	}
	
	
	
//	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public String regist(
			@ModelAttribute("memberInfo") MemberRegistRequest memRegReq,
			BindingResult bindingResult) {
		System.out.println(bindingResult);
		
		new MemberRegistValidator().validate(memRegReq, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return MEMBER_REGISTRATION_FORM;
		}
	//	memberService.registNewMember(memRegReq);
		return "member/registered";
	}	
	
	public void setMemberService(MemberService memberService) {
		//this.memberService = memberService;
	}

}