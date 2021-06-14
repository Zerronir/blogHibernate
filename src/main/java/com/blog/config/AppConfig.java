package com.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("com.blog")
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public List<String> getInterceptorMapping(){
        List<String> interceptorMapingList = new ArrayList<>();
        interceptorMapingList.add("/admin/{slug}/createPost");
        interceptorMapingList.add("/admin/{slug}/updatePost/{post}");
        interceptorMapingList.add("/postComment");
        interceptorMapingList.add("/createBlog");
        interceptorMapingList.add("/doRegister");
        interceptorMapingList.add("/doLogin");
        return interceptorMapingList;
    }


}
