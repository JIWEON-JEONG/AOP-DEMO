package spring.aop.demo.global.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import spring.aop.demo.global.interceptor.LoggingInterceptor;
import spring.aop.demo.global.querycounter.ApiQueryCounter;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	private final ApiQueryCounter apiQueryCounter;

	public WebConfiguration(final ApiQueryCounter apiQueryCounter) {
		this.apiQueryCounter = apiQueryCounter;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggingInterceptor(apiQueryCounter))
			.excludePathPatterns("/css/**", "/images/**", "/js/**");
	}
}
