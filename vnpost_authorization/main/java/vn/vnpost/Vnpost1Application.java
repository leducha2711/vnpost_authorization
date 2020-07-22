package vn.vnpost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"vn.vnpost"})
@EntityScan(basePackages = "vn.vnpost.entity")
@EnableJpaRepositories(basePackages = "vn.vnpost.repository")
public class Vnpost1Application {

	public static void main(String[] args) {
		SpringApplication.run(Vnpost1Application.class, args);
	}

}
