/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mto.cr.Model;

import java.io.UnsupportedEncodingException;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Wafa
 */
public class Mail {
    
    
	public  boolean Send(String toAddress,String emailBody) throws UnsupportedEncodingException, MessagingException {
	 	final String password="09829531";
                final String from = "wafa.dardouri@esprit.tn";
                final String name="RUSSIA WORLD CUP 2018";
                String subject="Changing Password";
                
                Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
		if(Session.getDefaultInstance(props)!=null){
			System.out.println("connected");
		}else{
			System.out.println("not connected");
		}
		
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {                                      
                                        @Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, password);
					}
				  });
                
		
		try {
			Message message = new MimeMessage(session);	 
			message.setFrom(new InternetAddress(from));			
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(toAddress));
			message.setSubject(subject);
			message.setContent(emailBody,"text/html");
			InternetAddress fromAddress=new InternetAddress(from, name);
			message.setFrom(fromAddress);
			Transport.send(message);
			return true;
		} catch (MessagingException c) {
			return false;
		}
		
    
}
}