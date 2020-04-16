package soa.utwente.nl.notifyuser.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import soa.utwente.nl.notifyuser.RequestIds;

import java.util.ArrayList;

@RestController
public class NotifyUserRestController {
    @Autowired private RequestIds service;

    @PostMapping(value = "/notifyusers", consumes = "application/json", produces = "application/json")
    public void NotifyUser(@RequestBody ArrayList<Integer> list){
        service.MailService(list);
    }
}
