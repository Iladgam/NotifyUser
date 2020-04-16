package soa.utwente.nl.notifyuser.MessageQueue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import soa.utwente.nl.notifyuser.integrations.response.MailList;

import java.util.List;

public class SendMails {
    @Value("${queue.NotifyUser}") private String NotifyUserQueue;

    @JmsListener(destination = "${queue.NotifyUser}")
    public void receiveMessage(MailList tasklist) {
        List<String> receivedEmails = tasklist.getMail();
        for (String email : receivedEmails){
            System.out.println("Notification send to e-mail address: " + email);
        }
    }

}
