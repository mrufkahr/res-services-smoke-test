package com.smoketest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.smoketest.MyFilter;
import com.smoketest.MyServletContextListener;
import com.smoketest.MyServlet;

@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}

	// Register Servlet
	  @Bean
	  public ServletRegistrationBean servletRegistrationBean() {
	    ServletRegistrationBean bean = new ServletRegistrationBean(
	        new MyServlet(), "/myServlet");
	    return bean;
	  }

	  // Register Filter
	  @Bean
	  public FilterRegistrationBean filterRegistrationBean() {
	    FilterRegistrationBean bean = new FilterRegistrationBean(new MyFilter());
	    // Mapping filter to a Servlet
	    bean.addServletRegistrationBeans(new ServletRegistrationBean[] {
	          servletRegistrationBean()
	       });
	    return bean;
	  }

//	  // Register ServletContextListener
//	  @Bean
//	  public ServletListenerRegistrationBean<ServletContextListener> listenerRegistrationBean() {
//	    ServletListenerRegistrationBean<ServletContextListener> bean =
//	        new ServletListenerRegistrationBean<>();
//	    bean.setListener(new MyServletContextListener());
//	    return bean;
//
//	  }


	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}