package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ac.AccessPerm;
import ac.AclModRequest;
import service.AclService;



@Controller
public class AclController {
	@Autowired
	private AclService aclService;
	@RequestMapping("/acl/list")
	public String list(Model model) {
		model.addAttribute("aclList", aclService.getAclList());
		System.out.println("acl=====");
		return "acl/aclList";	}
	@RequestMapping("/acl/modify")
	public String modify(AclModRequest modReq) {
		List<AccessPerm> perms = new ArrayList<AccessPerm>();
		for (AccessPerm reqPerm : modReq.getPerms())
			if (reqPerm.hasData())
				perms.add(reqPerm);
		modReq.setPerms(perms);

		aclService.modifyAccessControll(modReq);
		return "redirect:/acl/list";
		}	

}
