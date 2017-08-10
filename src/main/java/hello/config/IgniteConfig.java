package hello.config;

import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.websession.WebSessionFilter;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.startup.servlet.ServletContextListenerStartup;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by adel on 10/08/17.
 */

@Configuration
public class IgniteConfig {

    @Bean
    public IgniteConfiguration igniteConfiguration() {
        IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
        igniteConfiguration.setIgniteInstanceName("demoIgnite");
        igniteConfiguration.setCacheConfiguration(this.cacheConfiguration());
        return igniteConfiguration;
    }

    private CacheConfiguration cacheConfiguration() {
        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setName("demoIgniteCache");
        cacheConfiguration.setCacheMode(CacheMode.REPLICATED);
        return cacheConfiguration;
    }

//    @Bean
//    public ServletListenerRegistrationBean igniteListener() {
//        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean();
//        registrationBean.setListener(new ServletContextListenerStartup());
//        return registrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean WebSessionFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new WebSessionFilter());
//        System.out.println("Adel and Dmitri Debugging");
//        registration.addUrlPatterns("/*");
//        registration.setName("IgniteWebSessionsFilter");
//        registration.setOrder(1);
//        return registration;
//    }


}
