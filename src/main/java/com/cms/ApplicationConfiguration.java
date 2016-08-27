/*
package com.cms;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class ApplicationConfiguration {

    Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);

    @Value("${mainstay.web.port:8080}")
    private String port;

    @Value("${mainstay.web.context:/nced}")
    private String context;

    private Set<ErrorPage> pageHandlers;

    @PostConstruct
    private void init(){
        pageHandlers = new HashSet<ErrorPage>();
        pageHandlers.add(new ErrorPage(HttpStatus.NOT_FOUND,"/notfound.html"));
        pageHandlers.add(new ErrorPage(HttpStatus.FORBIDDEN,"/forbidden.html"));
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer(){
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        logger.info("Setting custom configuration for Mainstay:");
        logger.info("Setting port to {}",port);
        logger.info("Setting context to {}",context);
        factory.setPort(Integer.valueOf(port));
        factory.setContextPath(context);
        factory.setErrorPages(pageHandlers);
        return factory;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
*/
