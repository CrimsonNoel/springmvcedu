package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auth.Auth;
import auth.AuthenticationException;
import member.MemberInfo;


@Service
public class Authenticator {
	
	@Autowired
	private MemberService memberService;
	
	
	
	public Auth authenticate(String email, String password) {
		MemberInfo mi = memberService.getMemberInfoByEmail(email);
		System.out.println(mi);
		if (mi == null)
			throw new AuthenticationException();
		if (!mi.matchPassword(password))
			throw new AuthenticationException();

		return new Auth(mi.getId(), mi.getName());
	}
	
	
	

}
