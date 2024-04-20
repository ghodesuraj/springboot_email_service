package com.springemailclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import jakarta.mail.MessagingException;
import jakarta.mail.Service;

@SpringBootApplication
public class SpringEmailClientApplication {

	@Autowired
	private EmailSenderService service;

	String body = "This message is for security check.!";
	String body1 = "This message is for security check.! This mail has been sent via SpringBoot with attachment.!";
	String subject = "Subject: Sending Mail via JAVA";
	String subject1 = "Subject: Sending Mail via JAVA with attachment";
	String toEmail = "surajghode1008@gmail.com";
	String from = "sng123sng@gmail.com";
	String path = "/Users/wanderwise/Desktop/Wallpapers/itachi1.png";

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
		System.out.println("Preapering to send email");

		// triggerMail(toEmail, body, subject);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException

	{
		// service.sendSimpleEmail(toEmail, body, subject);
		service.sendEmailWithAttachment(toEmail, from, body, subject1, path);
	}
}
