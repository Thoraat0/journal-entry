package amosh.Journal.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import amosh.Journal.Entity.userEntries;
import org.springframework.stereotype.Component;


@Component
public interface userEntriesRepo extends MongoRepository<userEntries,ObjectId  > {


}
