package mailutil;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {

    final String username = "likhithchinnam@gmail.com";
    final String password = "7207102979";

    public String sendEmail(String emailId, String userName, String messageBody, String subject) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailId));
            message.setSubject(subject);
            message.setText("Dear " + userName + ",\n" + messageBody);
            Transport.send(message);
            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "message sent";
    }

    public static void main(String[] args) {

        MailUtil sendMail = new MailUtil();
        String messageBody = "Your reservation has been made and the cost of $ 120 has been deducted from xxxx-5678."
                + "\n\n" + "Thank You for your booking at JustRide!";
        // message.setText("Dear Mail Crawler," + "\n\n No spam to my email,
        // please!");"
        String subject = "Booking Confirmation";
        sendMail.sendEmail("likhithchinnam@gmail.com", "likhith", messageBody, subject);
    }

}
