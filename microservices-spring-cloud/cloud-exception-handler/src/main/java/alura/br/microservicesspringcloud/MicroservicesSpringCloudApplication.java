package alura.br.microservicesspringcloud;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroservicesSpringCloudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesSpringCloudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MongoClient mongoClient = MongoClients.create();
		System.out.println("HELLLLLLLLOOOOO WORLDAOOO");
	}
}
