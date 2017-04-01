package com.zx.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class SpringAdapter extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SelfInterceptor())
			.addPathPatterns("/getAllArticel")
			.addPathPatterns("/deleteArt")
			.addPathPatterns("/saveArticel")
			.addPathPatterns("/updateArticel")
			.addPathPatterns("/getArticelByPage")
			.addPathPatterns("/getArtModel/**")
			.addPathPatterns("/openOrder")
			.addPathPatterns("/closeOrder")
			.addPathPatterns("/deleteBanner")
			.addPathPatterns("/uploadBanner")
			.addPathPatterns("/getAllComment")
			.addPathPatterns("/deleteCom")
			.addPathPatterns("/getOneLevelModel")
			.addPathPatterns("/getTwoLevelModel")
			.addPathPatterns("/getAllArtModel")
			.addPathPatterns("/getAllvideo")
			.addPathPatterns("/deleteVideo")
			.addPathPatterns("/uploadVoide")
			.addPathPatterns("/getUserorder");
		super.addInterceptors(registry);
	}
}
