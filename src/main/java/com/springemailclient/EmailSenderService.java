package com.springemailclient;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailSender;

	public void sendSimpleEmail(String toEmail, String body, String subject) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("sng123sng@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);

		mailSender.send(message);
		System.out.println("Mail sent sucessfully........");
	}
	
	
	public void sendEmailWithAttachment(String toEmail, String from, String body, String subject , String attachment) throws MessagingException
	{
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
		mimeMessageHelper.setFrom(from);
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		
		FileSystemResource fileSystemResource =  new FileSystemResource(new File(attachment));
		
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		
		mailSender.send(mimeMessage);
		System.out.println("Email sent sucessfully via SpringBoot.........!");
	}
}