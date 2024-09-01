package amosh.Journal.service;


import amosh.Journal.Entity.userEntries;
import amosh.Journal.Entity.users;
import amosh.Journal.repository.userEntriesRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import amosh.Journal.repository.usersRepo;

import java.util.List;

@Component
public class userService {

    @Autowired
    private usersRepo usersRepo;



    public users findByUSername(String username){
        return usersRepo.findByUsername(username);
    }
    public void saveEntries(users users){
        usersRepo.save(users);

    }
}
