package amosh.Journal.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Document(collection = "journal_entries")
@Component
@Data
@NoArgsConstructor
public class userEntries {
    @Id
    private ObjectId id;

    private String title;

    private String content;

    private LocalDateTime date;

}
