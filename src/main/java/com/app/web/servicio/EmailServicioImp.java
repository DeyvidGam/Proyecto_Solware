package com.app.web.servicio;
//Importing required classes
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.beans.factory.annotation.Value;

	import org.springframework.mail.SimpleMailMessage;
	import org.springframework.mail.javamail.JavaMailSender;

	import org.springframework.stereotype.Service;
	import com.app.web.entidad.Email;

	
	@Service
	public class EmailServicioImp implements EmailServicio {

		@Autowired 
		private JavaMailSender javaMailSender;

		@Value("${spring.mail.username}") 
		private String sender;
		
		public String sendSimpleMail(Email details)
		{
				// Creating a simple mail message
				SimpleMailMessage mailMessage
					= new SimpleMailMessage();

				// Setting up necessary details
				mailMessage.setFrom(sender);
				mailMessage.setTo(details.getRecipient());
				mailMessage.setText(details.getMsgBody());
				mailMessage.setSubject(details.getSubject());

				// Sending the mail
				javaMailSender.send(mailMessage);
				return "Mail Sent Successfully...";

	}

}
