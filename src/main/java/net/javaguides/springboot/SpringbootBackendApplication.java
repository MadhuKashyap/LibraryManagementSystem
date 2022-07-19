package net.javaguides.springboot;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//CommandLineRunner is a simple Spring Boot interface with a run method. Spring Boot will automatically call the run method of all beans implementing this interface after the application context has been loaded
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
	@Autowired
	EmployeeRepository empr;

	@Override
	public  void run(String... args) throws Exception
	{
		Employee emp1=new Employee();
		emp1.setId(1);
		emp1.setFName("Ramesh");
		emp1.setLName("Singh");
		emp1.setEmail("ramesh@gmail.com");
		empr.save(emp1);

		Employee emp2=new Employee();
		emp2.setId(2);
		emp2.setFName("Suresh");
		emp2.setLName("Singh");
		emp2.setEmail("suresh@gmail.com");
		empr.save(emp2);

		Employee emp3=new Employee();
		emp3.setId(3);
		emp3.setFName("Sukesh");
		emp3.setLName("Singh");
		emp3.setEmail("sukesh@gmail.com");
		empr.save(emp3);

	}

}
