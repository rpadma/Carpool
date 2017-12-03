package mailutil;

import java.io.*;
import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;

import Gutils.MailUtilGmail;

import java.time.Clock;



public class EmailListServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        String url = "/index.jsp";
        if (action.equals("join")) {
            url = "/index.jsp";    // the "join" page
        } else if (action.equals("add")) {
            // get parameters from the request
          String firstName = request.getParameter("firstName");
           String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            System.out.println("email servlet ");
            // store data in User object
            //User user = new User(firstName, lastName, email);
            //UserDB.insert(user);
            //request.setAttribute("user", user);

            // send email to user
            String to = email;
            String from = "likhithchinnam@gmail.com";
            String subject = "Welcome to our Pet Store";
            String body = "Dear Customer"  + ",\n\n"
                    + "Thanks for shopping at the Pet Store."                   
                    + "Have a great day and thanks again!\n\n"
                    + "likhith chinnam\n"
                    + "UNC Charlotte";
            boolean isBodyHTML = false;

            try {
                System.out.println("after send mail in try initial");
                //MailUtilLocal.sendMail(to, from, subject, body, isBodyHTML);
                MailUtilGmail.sendMail(to, from, subject, body, isBodyHTML);
                System.out.println("after send mail in try");
            } catch (MessagingException e) {
                
                String errorMessage
                        = "ERROR: Unable to send email. "
                        + "Check Tomcat logs for details.<br>"
                        + "NOTE: You may need to configure your system "
                        + "as described in chapter 14.<br>"
                        + "ERROR MESSAGE: " + e.getMessage();
                request.setAttribute("errorMessage", errorMessage);
                this.log(
                        "Unable to send email. \n"
                        + "Here is the email you tried to send: \n"
                        + "=====================================\n"
                        + "TO: " + email + "\n"
                        + "FROM: " + from + "\n"
                        + "SUBJECT: " + subject + "\n"
                        + "\n"
                        + body + "\n\n");
            }
            url = "/index.jsp";
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}