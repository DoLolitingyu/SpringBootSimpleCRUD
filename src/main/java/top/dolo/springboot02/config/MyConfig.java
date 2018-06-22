package top.dolo.springboot02.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import top.dolo.springboot02.interceptor.LoginHandlerInterceptor;

@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/lty").setViewName("/index");
    }

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        return new WebMvcConfigurerAdapter() {
            //配置视图解析
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            //配置拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).
                                                addPathPatterns("/**").
                                                    excludePathPatterns("/", "/login");
            }

        };
    }
    //国际化配置
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}

//@Configuration
//public class MyConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/lty").setViewName("/index");
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/index.html").setViewName("index");
//        registry.addViewController("/main.html").setViewName("dashboard");
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/login");
//    }
//
//    @Bean
//    public LocaleResolver localeResolver() {
//        return new MyLocaleResolver();
//    }
//
//}
