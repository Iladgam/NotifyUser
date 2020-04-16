package soa.utwente.nl.notifyuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import soa.utwente.nl.notifyuser.integrations.task.IdList;

import java.util.ArrayList;

@Service
public class RequestIds {

//    @Autowired private RestTemplateBuilder restTemplateBuilder;
    @Autowired private JmsTemplate jmsTemplate;
    @Value("UsersUpdate") private String UsersUpdateQueue;

    public void MailService(ArrayList<Integer> assigned){
        IdList task = new IdList();
        for (int id : assigned) {
            task.getId().add((byte) id);
        }
        jmsTemplate.convertAndSend(UsersUpdateQueue, task);
    }
}
