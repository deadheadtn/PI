/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author deadhead
 */
public class MailService {
    final String username = "russia2018.pi@gmail.com";
    final String password = "Ru123456";
                public Session getProperties(){
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
                return session ;
                    }
		String p1 = "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" dir=\"ltr\" lang=\"en\">\n" +
"         <tbody><tr>\n" +
"                <td valign=\"top\">\n" +
"                <td valign=\"top\">\n" +
"                \n" +
"               <table width=\"640\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" dir=\"ltr\" lang=\"en\" style=\"border-left:1px solid #e3e3e3;border-right:1px solid #e3e3e3\">\n" +
"                <tbody><tr style=\"background-color:#0072c6\">\n" +
"                    <td width=\"1\" style=\"background:#0072c6;border-top:1px solid #e3e3e3\"></td>\n" +
"                    <td width=\"24\" style=\"border-top:1px solid #e3e3e3;border-bottom:1px solid #e3e3e3\">&nbsp;</td>\n" +
"                    <td width=\"310\" valign=\"middle\" style=\"border-top:1px solid #e3e3e3;border-bottom:1px solid #e3e3e3;padding:12px 0\">\n" +
"                        <h1 style=\"line-height:20pt;font-family:Segoe UI Light;font-size:18pt;color:#ffffff;font-weight:normal\">\n" +
"                            \n" +
"    <span id=\"m_1881277496855528315HeaderPlaceholder_UserVerificationEmailHeader\"><font color=\"#FFFFFF\">Reclamation Recieved</font></span>\n" +
"\n" +
"                        </h1>\n" +
"                    </td>\n" +
"                    <td width=\"24\" style=\"border-top:1px solid #e3e3e3;border-bottom:1px solid #e3e3e3\">&nbsp;</td>\n" +
"                </tr>\n" +
"               </tbody></table>\n" +
"               \n" +
"               <table width=\"640\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" dir=\"ltr\" lang=\"en\">\n" +
"                <tbody><tr>\n" +
"                    <td width=\"1\" style=\"background:#e3e3e3\"></td>\n" +
"                    <td width=\"24\">&nbsp;</td>\n" +
"                    <td id=\"m_1881277496855528315PageBody\" width=\"640\" valign=\"top\" colspan=\"2\" style=\"border-bottom:1px solid #e3e3e3;padding:10px 0 20px;border-bottom-style:hidden\">		\n" +
"                        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
"                            <tbody><tr>\n" +
"                                <td width=\"630\" style=\"font-size:10pt;line-height:13pt;color:#000\">\n" +
"                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" dir=\"ltr\" lang=\"en\">\n" +
"                                        <tbody><tr>\n" +
"                                            <td>\n" +
"                                                \n" +
"    <div style=\"font-family:'Segoe UI',Tahoma,sans-serif;font-size:14px;color:#333\">\n" +
"        <span id=\"m_1881277496855528315BodyPlaceholder_UserVerificationEmailBodySentence1\">Your Reclamation has been successfully Recieved</span>\n" +
"    </div>\n" +
"    <br>\n" +
"    <div style=\"font-family:'Segoe UI',Tahoma,sans-serif;font-size:14px;color:#333;font-weight:bold\">\n" +
"        <span id=\"m_1881277496855528315BodyPlaceholder_UserVerificationEmailBodySentence2\">";
                String p3 = "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" dir=\"ltr\" lang=\"en\">\n" +
"         <tbody><tr>\n" +
"                <td valign=\"top\">\n" +
"                <td valign=\"top\">\n" +
"                \n" +
"               <table width=\"640\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" dir=\"ltr\" lang=\"en\" style=\"border-left:1px solid #e3e3e3;border-right:1px solid #e3e3e3\">\n" +
"                <tbody><tr style=\"background-color:#0072c6\">\n" +
"                    <td width=\"1\" style=\"background:#0072c6;border-top:1px solid #e3e3e3\"></td>\n" +
"                    <td width=\"24\" style=\"border-top:1px solid #e3e3e3;border-bottom:1px solid #e3e3e3\">&nbsp;</td>\n" +
"                    <td width=\"310\" valign=\"middle\" style=\"border-top:1px solid #e3e3e3;border-bottom:1px solid #e3e3e3;padding:12px 0\">\n" +
"                        <h1 style=\"line-height:20pt;font-family:Segoe UI Light;font-size:18pt;color:#ffffff;font-weight:normal\">\n" +
"                            \n" +
"    <span id=\"m_1881277496855528315HeaderPlaceholder_UserVerificationEmailHeader\"><font color=\"#FFFFFF\">Reclamation reponse</font></span>\n" +
"\n" +
"                        </h1>\n" +
"                    </td>\n" +
"                    <td width=\"24\" style=\"border-top:1px solid #e3e3e3;border-bottom:1px solid #e3e3e3\">&nbsp;</td>\n" +
"                </tr>\n" +
"               </tbody></table>\n" +
"               \n" +
"               <table width=\"640\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" dir=\"ltr\" lang=\"en\">\n" +
"                <tbody><tr>\n" +
"                    <td width=\"1\" style=\"background:#e3e3e3\"></td>\n" +
"                    <td width=\"24\">&nbsp;</td>\n" +
"                    <td id=\"m_1881277496855528315PageBody\" width=\"640\" valign=\"top\" colspan=\"2\" style=\"border-bottom:1px solid #e3e3e3;padding:10px 0 20px;border-bottom-style:hidden\">		\n" +
"                        <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
"                            <tbody><tr>\n" +
"                                <td width=\"630\" style=\"font-size:10pt;line-height:13pt;color:#000\">\n" +
"                                    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" dir=\"ltr\" lang=\"en\">\n" +
"                                        <tbody><tr>\n" +
"                                            <td>\n" +
"                                                \n" +
"    <div style=\"font-family:'Segoe UI',Tahoma,sans-serif;font-size:14px;color:#333\">\n" +
"        <span id=\"m_1881277496855528315BodyPlaceholder_UserVerificationEmailBodySentence1\">Your Reclamation Reponse</span>\n" +
"    </div>\n" +
"    <br>\n" +
"    <div style=\"font-family:'Segoe UI',Tahoma,sans-serif;font-size:14px;color:#333;font-weight:bold\">\n" +
"        <span id=\"m_1881277496855528315BodyPlaceholder_UserVerificationEmailBodySentence2\">";
                
                String p2="</span>\n" +
"    </div>\n" +
"    <br>\n" +
"    <br>\n" +
"\n" +
"                                                <div style=\"font-family:'Segoe UI',Tahoma,sans-serif;font-size:14px;color:#333\">\n" +
"                                                Sincerely,\n" +
"                                                </div>\n" +
"                                                <div style=\"font-family:'Segoe UI',Tahoma,sans-serif;font-size:14px;font-style:italic;color:#333\">\n" +
"                                                    FIFA.com Club\n" +
"                                                </div>\n" +
"                                            </td>\n" +
"                                        </tr>\n" +
"                                    </tbody></table>\n" +
"                                </td>\n" +
"                            </tr>\n" +
"                        </tbody></table>\n" +
"\n" +
"                    </td>\n" +
"\n" +
"                    <td width=\"1\">&nbsp;</td>\n" +
"                    <td width=\"1\"></td>\n" +
"                    <td width=\"1\">&nbsp;</td>\n" +
"                    <td width=\"1\" valign=\"top\"></td>			 \n" +
"                    <td width=\"29\">&nbsp;</td>\n" +
"                    <td width=\"1\" style=\"background:#e3e3e3\"></td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td width=\"1\" style=\"background:#e3e3e3;border-bottom:1px solid #e3e3e3\"></td>\n" +
"                    <td width=\"24\" style=\"border-bottom:1px solid #e3e3e3\">&nbsp;</td>\n" +
"                    <td id=\"m_1881277496855528315PageFooterContainer\" width=\"585\" valign=\"top\" colspan=\"6\" style=\"border-bottom:1px solid #e3e3e3;padding:0px\">\n" +
"                        \n" +
"\n" +
"                    </td>\n" +
"\n" +
"                    <td width=\"29\" style=\"border-bottom:1px solid #e3e3e3\">&nbsp;</td>\n" +
"                    <td width=\"1\" style=\"background:#e3e3e3;border-bottom:1px solid #e3e3e3\"></td>\n" +
"                </tr>\n" +
"               </tbody></table>\n" +
"\n" +
"            </td><td width=\"29\" style=\"border-bottom:1px solid #e3e3e3\">&nbsp;</td>\n" +
"                    <td width=\"1\" style=\"background:#e3e3e3;border-bottom:1px solid #e3e3e3\"></td>\n" +
"                </tr>\n" +
"               </tbody></table>\n" +
"\n" +
"            </td>\n" +
"            <td valign=\"top\" width=\"50%\"></td>\n" +
"        </tr>\n" +
"    </tbody></table>";
            public void confirmationReclamation(String mail, String reclamation) throws MessagingException{
		Message message = new MimeMessage(getProperties());
		message.setFrom(new InternetAddress("russia2018.pi@gmail.com"));
		message.setRecipients(Message.RecipientType.TO,
		InternetAddress.parse("nejmeddine.khechine@gmail.com"));
		message.setSubject("Your Reclamation has been successfully Recieved");
                message.setContent(p1+reclamation+p2, "text/html; charset=utf-8");
		Transport.send(message);
            }         
            public void reponserec(String email ,String reclamation) throws AddressException, MessagingException{
                Message message = new MimeMessage(getProperties());
		message.setFrom(new InternetAddress("russia2018.pi@gmail.com"));
		message.setRecipients(Message.RecipientType.TO,
		InternetAddress.parse("nejmeddine.khechine@gmail.com"));
		message.setSubject("Your Reclamation response");
                message.setContent(p3+reclamation+p2, "text/html; charset=utf-8");
		Transport.send(message);
            }
}
