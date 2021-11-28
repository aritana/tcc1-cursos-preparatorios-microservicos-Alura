package alura.br.microservicesspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class MicroservicesSpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesSpringCloudApplication.class, args);
	}

}
