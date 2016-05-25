package com.complete;

import com.complete.domain.Solution;
import com.complete.domain.User;
import com.complete.repository.SolutionRepository;
import com.complete.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableSpringConfigured
@SpringBootApplication(scanBasePackages = "com.complete")
@EnableJpaRepositories("com.complete.repository")
public class CompleteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompleteApplication.class, args);
	}
/*
    @Bean
    public CommandLineRunner loadData(UserRepository userRepository, SolutionRepository solutionRepository) {
        return (args) -> {
            User user1 = new User("Evgeny","ev","ava","uku","ulka");
            userRepository.save(user1);
            User user2 = new User("Julia","ev","ava","uku","ulka");
            userRepository.save(user2);
            Solution solution = new Solution();
            solutionRepository.save(solution);
            user1.getSolution().add(solution);
            userRepository.save(user1);
            System.out.println(user1.getId());
            System.out.println(user2.getId());
            System.out.println(solution.toString());
            System.out.println("__________________");

            Iterable<User> users=userRepository.findAll();
            for(User x:users) {
                System.out.println(x);
            }
            for(Solution s:solutionRepository.findAll()) {
                System.out.println(s);
            }
            // <3 Женечка-няшечка. Люблю его <3
            System.out.println("__________________");
        };

    }
    */
}
