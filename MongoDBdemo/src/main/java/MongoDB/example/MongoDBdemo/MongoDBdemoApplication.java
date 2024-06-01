package MongoDB.example.MongoDBdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoDBdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDBdemoApplication.class, args);
		System.out.println("Server is Running");
	}
}
