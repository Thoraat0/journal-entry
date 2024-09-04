package amosh.Journal.service;


import amosh.Journal.Entity.users;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import amosh.Journal.repository.usersRepo;

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

    public void deleteByUsername(String username, ObjectId id) {
        users byUsername = usersRepo.findByUsername(username);
        byUsername.getUserEntries().remove(id);
    }
}
