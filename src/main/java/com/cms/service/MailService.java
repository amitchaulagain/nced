package com.cms.service;

import com.cms.dto.EmailDTO;

import javax.mail.MessagingException;


public interface MailService {

	public void configureMailServer(String username, String password);
	
	public void sendMail(String from, String to, String subject, String content) throws MessagingException;

	public void sendMail(EmailDTO emailDTO) throws MessagingException;
	
}
