package com.training.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.training.project.entity.BugResource;
import com.training.project.ifaces.IBugResource;

@SpringBootApplication
public class BugTrackerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackerServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			private IBugResource repository;
			
			@Override
			public void run(String... args) throws Exception {
				
				repository.save(new BugResource(100, "Ramesh", "Bug Description1", "P1", "Project-1", "High", "Bug1"));
				repository.save(new BugResource(101, "Suresh", "Bug Description10", "P3", "Project-2", "Low", "Bug1"));
				repository.save(new BugResource(102, "Rajesh", "Bug Description2", "P2", "Project-12", "High", "Bug1"));
				repository.save(new BugResource(103, "Rakesh", "Bug Description3", "P1", "Project-13", "High", "Bug1"));
				repository.save(new BugResource(104, "Saketh", "Bug Description4", "P1", "Project-1", "High", "Bug1"));
				repository.save(new BugResource(105, "Radhikesh", "Bug Description5", "P3", "Project-10", "Low", "Bug1"));
				repository.save(new BugResource(106, "Rishikesh", "Bug Description6", "P2", "Project-1001", "Medium", "Bug1"));
				repository.save(new BugResource(107, "Sukesh", "Bug Description7", "P4", "Project-3", "Low", "Bug1"));
				repository.save(new BugResource(108, "Shikhar", "Bug Description8", "P1", "Project-2", "High", "Bug1"));
				
			}
		};
	}
}
