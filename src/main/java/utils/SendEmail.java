package utils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendEmail {
    public static void main(String[] args) {
        
        String emailSender = args[0];
        String emailRecipient = args[1];
        String emailSubject = args[2];
        String emailBody = args[3];
        String fileAttachment = args[4];
        
        System.out.println("===Start Send Email===");
        
        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";
        
        // Get system properties
        Properties properties = System.getProperties();
        
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dwkfadhilah@gmail.com", "password");
            }
            
        });
        
        // Used to debug SMTP issues
        session.setDebug(true);
        
        try {
            // Create object of MimeMessage class
            Message message = new MimeMessage(session);
            
            // Set the from address
            message.setFrom(new InternetAddress(emailSender));
            
            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailRecipient));
            
            // Add the subject link
            message.setSubject(emailSubject);
            
            // Create object to add multimedia type content
            BodyPart messageBodyPart1 = new MimeBodyPart();
            
            // Set the body of email
            messageBodyPart1.setText(emailBody);
            
            // Create another object to add another content
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
            
            // Create data source and pass the filename
            DataSource source = new FileDataSource(fileAttachment);
            
            // set the handler
            messageBodyPart2.setDataHandler(new DataHandler(source));
            
            // set the file
            messageBodyPart2.setFileName(fileAttachment);
            
            // Create object of MimeMultipart class
            Multipart multipart = new MimeMultipart();
            
            // add body part 1
            multipart.addBodyPart(messageBodyPart2);
            
            // add body part 2
            multipart.addBodyPart(messageBodyPart1);
            
            // set the content
            message.setContent(multipart);
            
            // finally send the email
            Transport.send(message);
            System.out.println("=====Email Sent=====");
            
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
