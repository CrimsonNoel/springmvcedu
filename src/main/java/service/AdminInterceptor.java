package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import auth.Auth;


public class AdminInterceptor extends HandlerInterceptorAdapter{
@Override  //controller service before
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
	// TODO Auto-generated method stub
	System.out.println("AdminInterceptor:preHandle");
	
	HttpSession session = request.getSession();
	Auth auth = (Auth) session.getAttribute("auth");
	
	if (auth==null || !auth.getId().equals("m1")) {
		response.sendRedirect(request.getContextPath()+"/auth/login");
		return false;
		}
	return true;
}

@Override  //controller service after
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("AdminInterceptor:afterCompletion");
	}

@Override  // controller service에서 view return 전에 실행
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AdminInterceptor:postHandle");
		
		
		
		
	}


}


