/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompagny.Service;



import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import java.io.IOException;
import com.sendgrid.Content;



/**
 *
 * @author mahdi
 */
public class ServiceMail {
    public void SendMail(String too , String contentt, String S, String f) {
    Email from = new Email(f);
  //  String subject = "Votre Boutique favorie a ajouté in nouveau produit";
    Email to = new Email(too);
    Content content = new Content("text/plain", contentt);
    Mail mail = new Mail(from, S, to, content);
    

    SendGrid sg = new SendGrid("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");
    
         Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
       ex.printStackTrace();
    }
  }



    
}