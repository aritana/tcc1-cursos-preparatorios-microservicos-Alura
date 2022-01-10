package alura.br.microservicesspringcloud;

import alura.br.microservicesspringcloud.config.MongoDb;
import com.mongodb.client.MongoClients;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class MicroservicesSpringCloudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesSpringCloudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//https://cloud.mongodb.com/v2/61b7e2d2053861179fc7707c#clusters
		MongoDb.client = MongoClients.create("mongodb+srv://root:root@cluster0.6m67u.mongodb.net/exceptionHandlerDB?retryWrites=true&w=majority");

	}
}