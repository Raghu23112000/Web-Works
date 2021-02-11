package com.example.WebWorks.AddOnServices;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author rahul
 */
public class MailUtil {
    public static void sendMail(String rec, String Key) throws Exception {
        Properties prop=new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.port","587");
        String myAcc="rahulglenn92@gmail.com";
        String pass="solution";
        Session sess=Session.getInstance(prop,new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAcc, pass); //To change body of generated methods, choose Tools | Templates.
            }
        });
        Message mess=prepareMessage(sess, myAcc, rec,Key);
        Transport.send(mess);
    }
    private static Message prepareMessage(Session sess,String myAcc,String rec,String key)
    {
        try{
            Message mess=new MimeMessage(sess);
            mess.setFrom(new InternetAddress(myAcc));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(rec));
            mess.setSubject("WEBWORKS : Your Activation Key!!");
            mess.setText("The Activation Key Required for activating your Company Portal is : "+key);
            return mess;
        }
        catch(Exception ee)
        {
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE,null,ee);
        }
        return null;
    }

}