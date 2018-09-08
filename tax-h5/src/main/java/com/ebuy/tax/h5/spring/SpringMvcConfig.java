package com.ebuy.tax.h5.spring;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.ebuy.tax.common.constants.SysConstant;
import com.ebuy.tax.h5.servlet.SessionTimeoutFilter;
import com.ebuy.tax.h5.utils.FastJsonUtil;

/**
 * 
* @author dd
* @date 2018年9月5日
 */
@Configuration
@EnableWebMvc
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
//		converters.add(converter());
	}
    
	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		messageConverters.add(converter());
		restTemplate.setMessageConverters(messageConverters );
		return restTemplate;
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(999999);
		return resolver;
	}
	
	@Bean
	public AbstractHttpMessageConverter<Object> converter() {
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(new JsonObjectMapper());
		
		FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setCharset(Charset.forName(SysConstant.CHARSET_UTF8));
		fastJsonConfig.setWriteContentLength(false);
		fastJsonConfig.setSerializerFeatures(FastJsonUtil.getSerializerFeatures());
		fastJsonConfig.setDateFormat(SysConstant.YYYY_MM_DD_HH_MM_SS);
		fastJsonConfig.setSerializeFilters(FastJsonUtil.getValueFilter());
		
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(MediaType.APPLICATION_JSON);
		converter.setSupportedMediaTypes(supportedMediaTypes );
		
		converter.setFastJsonConfig(fastJsonConfig);
	    return converter;
	}
	
	@Bean
	public FilterRegistrationBean getRequestContextFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		RequestContextFilter requestContextFilter = new RequestContextFilter();
		registrationBean.setFilter(requestContextFilter);
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");// 拦截路径，可以添加多个
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}
	
	@Bean
	public FilterRegistrationBean sessionFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		SessionTimeoutFilter sessionTimeoutFilter = new SessionTimeoutFilter();
		registrationBean.setFilter(sessionTimeoutFilter);
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");// 拦截路径，可以添加多个
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/static/**").addResourceLocations("/static/")
	            .setCacheControl(CacheControl.maxAge(60, TimeUnit.MINUTES)
                .cachePrivate())
			    .resourceChain(false);
	}

}