package kr.or.connect.reservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// DispatcherServlet이 읽는다. 

// 설정 파일 
@Configuration
// 기본적인 설정 자동 
@EnableWebMvc
// controller 읽어 오기 
@ComponentScan(basePackages = { "kr.or.connect.reservation.controller" })
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("WebMvcContextConfiguration.java => addResourceHandlers");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }
 
    // default servlet handler를 사용하게 합니다. (mapping 정보가 없는 url 요청이 들어왔을 때 DefaultServletHttpRequesetHandler가 처리하도록 한다.) 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    	System.out.println("WebMvcContextConfiguration.java => configureDefaultServletHandling");
        configurer.enable();
    }
   
    // 특정 url에 대한 처리를 controller 작성하지 않고 mapping 할 수 있도록 한다. 
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
    	System.out.println("WebMvcContextConfiguration.java => addViewControllers");
    		System.out.println("addViewControllers가 호출됩니다. ");
        registry.addViewController("/").setViewName("index");
    }
    
    // ViewResolver가 ViewName을 찾을 수 있도록 한다. 
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
    	System.out.println("WebMvcContextConfiguration.java => InternalResourceViewResolver");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
}
