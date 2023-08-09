package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import auth.Auth;
import auth.AuthenticationException;
import auth.LoginCommand;
import service.Authenticator;



@Controller
@RequestMapping("/auth/login")
public class LoginController {
	private static final String LOGIN_FORM = "auth/loginForm";
	@Autowired
	private Authenticator authenticator;
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;	}
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String loginForm(LoginCommand loginCommand, Model m, String msg) {
			return LOGIN_FORM;	}	
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public String login(LoginCommand loginCommand,HttpServletRequest request) {
		String msg=request.getParameter("msg");
		try {
			Auth auth = authenticator.authenticate(loginCommand.getEmail(),
					loginCommand.getPassword());
			HttpSession session = request.getSession();
			session.setAttribute("auth", auth);
			System.out.println(auth);
			return "redirect:/hello.do";
		} catch (AuthenticationException ex) {
			if (msg==null) 			return LOGIN_FORM;
			else return "redirect:/auth/login";  //한번 msg 처리를 한후에 url에서 삭제 해야함
		}	} }
