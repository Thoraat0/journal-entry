package amosh.Journal.controller;

import amosh.Journal.Entity.users;
import amosh.Journal.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Component
@RestController
@RequestMapping("/users")
public class usersController {

    @Autowired
    private userService userService;

    @PostMapping()
    public ResponseEntity<users> createUser(@RequestBody users users){
        try {
            userService.saveEntries(users);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/username/{username}")
    public ResponseEntity<users> getByUsername(@PathVariable String username){
        try {
            users byUSername = userService.findByUSername(username);
            return new ResponseEntity<>(byUSername, HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
