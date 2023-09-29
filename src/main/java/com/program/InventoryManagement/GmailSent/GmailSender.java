package com.program.InventoryManagement.GmailSent;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class GmailSender {

    public boolean sendMail(String to,String from,String subject,String msg){

        boolean flag=false;
        String username="mukeshsilwal5";
        String password="$@31Brother";
        //Properties
        Properties props=new Properties();
//        properties.put("mail.smtp.auth",true);
//        properties.put("mail.smtp.starttls.enable",true);
//        properties.put("mail.smtp.port","587");
//        properties.put("mail.smtp.host","smtp.gmail.com");
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        //Sessions
        Session session=Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });
        try{
            Message message=new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(msg);
            Transport.send(message);
            flag=true;
        }
        catch (Exception e){
            e.printStackTrace();

        }

        return flag;
    }
}
