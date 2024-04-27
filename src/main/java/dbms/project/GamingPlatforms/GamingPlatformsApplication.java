package dbms.project.GamingPlatforms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("dbms.project.GamingPlatforms.Model")
public class GamingPlatformsApplication {
	public static void main(String[] args) {
		SpringApplication.run(GamingPlatformsApplication.class, args);
	}
}
