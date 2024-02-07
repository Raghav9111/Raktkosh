package com.raktosh.config;

import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService 
{
	private JavaMailSenderImpl mailSender;
	private Properties props;
	
	public MailService() 
	{
		mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);	    
	    mailSender.setUsername("justsample4mail@gmail.com");
	    mailSender.setPassword("nnmohhfiokrcapqf");
	    
	    props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	}
	
	public void verificationMail(String mail,String name) throws Exception 
	{
			MimeMessage mimeMessage = mailSender.createMimeMessage();
		
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
			
			String htmlMsg = "<html>"
					+ "<body>"
					+ "<h1 style='color:red'>Welcome "+ name + " in Raktkosh ......"
					+ "<hr>"
					+ "<p>"
					+ "&nbsp;&nbsp; Your Account is created successfully. Please verify your account via below link : <br>"
					+ "</p>"
					+ "<a href='http://localhost:8080/web/verify/"+mail+"'> <h4 align='center'> Verify Account  </h4> </a>"
					+ "</body>"
					+ "</html>";
			
			mimeMessage.setContent(htmlMsg, "text/html"); 
			helper.setText(htmlMsg, true); 
			helper.setTo(mail);
			helper.setSubject("Verification Mail Via Raktkosh");
			helper.setFrom("justsample4mail@gmail.com");
			mailSender.send(mimeMessage);
	}
	
}
