package service;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import auth.Auth;

public class LoginInterceptor  extends HandlerInterceptorAdapter {
     @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
    		  Object handler)
    		throws Exception {
    	 HttpSession   session = request.getSession();
    	 Auth auth = (Auth) session.getAttribute("auth");
    	 
    	 if (auth !=null) {  return true;
    	 } else {
    		
    		 response.sendRedirect(request.getContextPath()+"/auth/login");
    		 
    	 }
    	 
    	// TODO Auto-generated method stub
    	  System.out.println("login: preHandle()");
    	return true;
    }
      
    
}
