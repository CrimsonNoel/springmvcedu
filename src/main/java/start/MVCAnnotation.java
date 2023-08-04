package start;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import controller.HelloController2;

@Configuration
@EnableWebMvc   //webmvc
public class MVCAnnotation {
	
	@Bean
	public  InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver  viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	
	
	@Bean
	public HelloController2   helloController2() {
		
		return new HelloController2();
	}
	

}
