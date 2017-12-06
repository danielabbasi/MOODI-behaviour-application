package team11.project.behaviorapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BehaviorappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BehaviorappApplication.class, args);
	}
}
