package com.cms.configuration.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

	@Bean
	JavaMailSenderImpl setMailSenderProperties() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setPort(587);
		mailSender.setHost("smtp.gmail.com");
		mailSender.setUsername("achaulagain123@gmail.com");
		mailSender.setPassword("amitch!!!");
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}

}
