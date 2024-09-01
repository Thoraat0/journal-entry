package amosh.Journal.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Document(collection = "users")
@Data
@NoArgsConstructor
@Component
public class users {
    @Id
    private ObjectId id;

    @NonNull
    @Indexed(unique = true)
    private String username;
    @NonNull
    private String password;

    @DBRef
    List<userEntries> userEntries= new ArrayList<>();
}
