package MongoDB.example.MongoDBdemo.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("database_sequence")
public class DatabaseSequence {

    @Id
    private String id;
    private long seq;
}
