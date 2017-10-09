/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailtest;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
public class Mailtest {
    public static void main(String[] args) {
   Scanner input=new Scanner(System.in);
        try{
            String host ="smtp.gmail.com" ;
            String user = "bosecybert@gmail.com";
            System.out.println("enter the password.....");
            String pass =input.nextLine();
            System.out.println("enter the to address.....");
            String to = input.nextLine();
            String cc;
            System.out.println("cc:");
            cc=input.nextLine();
            String from = "bosecybert@gmail.com";
            System.out.println("enter the subject.....");
            String subject = input.nextLine();
            System.out.println("enter the message.....");
            String messageText = input.nextLine();
            boolean sessionDebug = false;
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg1 = new MimeMessage(mailSession);
            Message msg2 = new MimeMessage(mailSession);
            msg1.setFrom(new InternetAddress(from));
            msg2.setFrom(new InternetAddress(from));
            InternetAddress[] address1 = {new InternetAddress(to)};
            msg1.setRecipients(Message.RecipientType.TO, address1);
            msg1.setSubject(subject); msg1.setSentDate(new Date());
            msg1.setText(messageText);
            InternetAddress[] address2 = {new InternetAddress(cc)};
            msg2.setRecipients(Message.RecipientType.TO, address2);
            msg2.setSubject(subject); msg2.setSentDate(new Date());
            msg2.setText(messageText);
            
            
              msg1.setContent("<h1>TEST IMAGE</h1>"+"<img src=1.jpg height=42 width=42>","text/html");
              msg2.setContent("<h1>TEST IMAGE</h1>"+"<img src=1.jpg height=42 width=42>","text/html");
             
           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg1, msg1.getAllRecipients());
           transport.sendMessage(msg2, msg2.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
}

    
    

