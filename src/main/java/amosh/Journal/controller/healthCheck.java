package amosh.Journal.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthCheck {
    @GetMapping("health")
    public String health(){
        return "i am good";
    }
}
