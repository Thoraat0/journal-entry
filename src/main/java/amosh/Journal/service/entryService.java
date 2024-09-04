package amosh.Journal.service;


import amosh.Journal.Entity.users;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import amosh.Journal.repository.userEntriesRepo;
import amosh.Journal.Entity.userEntries;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class entryService {

    @Autowired
    private userEntriesRepo userEntriesRepo;

    @Autowired
    private userService userService;

//    public List<userEntries> findAll(){
//        return userEntriesRepo.findAll();
//    }

    public List<userEntries> getAll() {
        return userEntriesRepo.findAll();
    }
    public userEntries getById(ObjectId id){

        return userEntriesRepo.findById(id).orElse(null);
    }

    public void saveEntries(userEntries myEntries){
        userEntriesRepo.save(myEntries);
    }

    public void saveEntries(userEntries myEntries, String username){
        myEntries.setDate(LocalDateTime.now());
        users find = userService.findByUSername(username);
        userEntries saved = userEntriesRepo.save(myEntries);
        find.getUserEntries().add(saved);
        userService.saveEntries(find);
    }

    public void deleteById(ObjectId id, String username){
        users byUSername = userService.findByUSername(username);
        byUSername.getUserEntries().removeIf(x->x.getId().equals(id));
        userService.saveEntries(byUSername);
        userEntriesRepo.deleteById(id);
    }
}
