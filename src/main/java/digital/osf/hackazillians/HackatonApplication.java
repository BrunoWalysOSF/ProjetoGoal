package digital.osf.hackazillians;

import digital.osf.hackazillians.handler.UserIdInterceptor;
import digital.osf.hackazillians.handler.UserInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableCaching
public class HackatonApplication implements WebMvcConfigurer {

	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		registry.addInterceptor(userInterceptor());
	}

	@Bean
	public UserIdInterceptor userInterceptor() {
		return new UserIdInterceptor(userId());
	}
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**").allowedMethods("*");
//	}

	public static void main(String[] args) {
		SpringApplication.run(HackatonApplication.class, args);
	}


	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public UserInterceptor userId() {
		return  UserInterceptor.builder().build();
	}

}
