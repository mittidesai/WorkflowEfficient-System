/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wfes;

/**
 *
 * @author hp pav 15-e015tx
 */
import email.EmailDetails;
import java.io.File;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class mailtry {

    public mailtry(EmailDetails emailDetails) throws MessagingException {
        String host = "smtp.gmail.com";
        String Password = "wfes-123";
        String from = "workflowefficientsystem@gmail.com";
        //  String toAddress[] = emailDetails.getTo();
        String str[] = emailDetails.getTo();
        String filename[] = emailDetails.getAttachFiles();
//        filename[0] = "C:\\Users\\hp pav 15-e015tx\\Documents\\srs.pdf";
//        filename[1] = "C:\\Users\\hp pav 15-e015tx\\Documents\\testinnnn.pdf";
        // Get system properties




        int l=0;
        for(int k=0;k<str.length;k++){
            if(str[k]!=null){
                l++;
            }
            else{
                break;
            }
        }
        int len = l;
        System.out.println("mailclasslen" + len);
        
        
         int maill=0;
        for(int k=0;k<filename.length;k++){
            if(filename[k]!=null){
                maill++;
            }
            else{
                break;
            }
        }
        int maillen = maill;
        System.out.println("filennnnn" + maill);
        






        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props, null);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        Address addresses[] = new Address[len];
        for (int j = 0; j < len; j++) {

            addresses[j] = new javax.mail.internet.InternetAddress(str[j]);



        }

        message.setRecipients(Message.RecipientType.TO, addresses);
        message.setSubject(emailDetails.getSubject());
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(emailDetails.getMessage());
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        System.out.println("fileength" + filename.length);
        for (int i = 0; i < maillen; i++) {
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(filename[i]);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename[i]);
            multipart.addBodyPart(messageBodyPart);
        }
        message.setContent(multipart);

        try {
            Transport tr = session.getTransport("smtps");
            tr.connect(host, from, Password);
            tr.sendMessage(message, message.getAllRecipients());
            System.out.println("Mail Sent Successfully");
            tr.close();
        } catch (SendFailedException sfe) {
            System.out.println(sfe);
        }
    }
}