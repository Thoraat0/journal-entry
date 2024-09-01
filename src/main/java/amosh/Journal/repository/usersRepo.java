package amosh.Journal.repository;

import amosh.Journal.Entity.users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface usersRepo extends MongoRepository<users, ObjectId> {

    public users findByUsername(String username);
}
