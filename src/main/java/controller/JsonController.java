package controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import member.MemberInfo;
import service.MemberService;

//@Controller      //@ResponseBody로 view없이 object(json)을 보낸다
//@RestController  //@ResponseBody사용하지 않아도 된다



/* pom.xml에 추가한다 
 * <dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.2</version>
</dependency>
 * 
 * 
 * 
 */
@Controller 
public class JsonController {
	
	@Autowired
	MemberService  memberService;
	
	@RequestMapping("/json/list")
	@ResponseBody
	public List<MemberInfo> jsonList() {
		
		
		return memberService.getMembers();
	}
	@RequestMapping("/json/map")
	@ResponseBody
	public Map<String, MemberInfo> jsonMap() {
		
		
		
		return memberService.memberMap;
	}}


