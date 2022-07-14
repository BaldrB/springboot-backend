package net.javaguides.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import net.javaguides.springboot.storage.StorageProperties;
import net.javaguides.springboot.storage.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);

	}
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

	@Override
	public void run(String... args) throws Exception{
//		Employee employee = new Employee();
//		employee.setFirstName("Ramesh");
//		employee.setLastName("Fadatare");
//		employee.setEmailId("ram@gmail.com");
//		employeeRepository.save(employee);
//
//		Employee employee1 = new Employee();
//		employee1.setFirstName("Joh");
//		employee1.setLastName("Fadatare");
//		employee1.setEmailId("rag@gmail.com");
//		employeeRepository.save(employee1);

	}

}
