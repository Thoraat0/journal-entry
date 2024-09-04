package amosh.Journal.controller;


import amosh.Journal.Entity.userEntries;
import amosh.Journal.Entity.users;
import amosh.Journal.service.entryService;
import amosh.Journal.service.userService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class EntryController {

    @Autowired
    private entryService entryService;

    @Autowired
    private userService userService;

    @PostMapping("/username/{username}")
    public ResponseEntity<?> createEntry(@RequestBody userEntries myEntries,@PathVariable String username){

        try {
            entryService.saveEntries(myEntries,username);
            return new ResponseEntity<>(entryService,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }



    @GetMapping("/id/{id}")
    public ResponseEntity<userEntries> getById(@PathVariable ObjectId id){
        userEntries byId = entryService.getById(id);
        if(byId!=null){
            return new ResponseEntity<>(byId,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{id}/{username}")
    public ResponseEntity<?> deleteById(@PathVariable ObjectId id, @PathVariable String username){
        userEntries byId = entryService.getById(id);
//        users byUSername = userService.findByUSername(username);


        try {
            entryService.deleteById(id,username);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<?> update(@RequestBody userEntries newEntries, @PathVariable ObjectId id){
        try {
            userEntries byId = entryService.getById(id);
            byId.setContent(newEntries.getContent()!=null && !newEntries.getContent().equals("")? newEntries.getContent(): byId.getContent() );
            byId.setTitle( newEntries.getTitle()!=null && !newEntries.getTitle().equals("")?  newEntries.getTitle() :byId.getTitle() );
            entryService.saveEntries(byId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
