package com.jincheng.bookmanage.config;



import com.jincheng.bookmanage.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringMvc配置类
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login1").setViewName("backstage/login1");

    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/index").setViewName("front/login");
                registry.addViewController("/").setViewName("front/login");

            }
        };
        return webMvcConfigurer;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态文件
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        //webjar文件
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        registry.addResourceHandler("/image/**").addResourceLocations("file:D:/ewm/");
    }

    @Bean
    public LocaleResolver localeResolver(){
        //语言国际化组件注册
        return new MyLocaleResolver();
    }



}