package org.sid.customerservice;

import org.sid.customerservice.dao.CustomerRepository;
import org.sid.customerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        return args ->{
            restConfiguration.exposeIdsFor(Customer.class);
            customerRepository.save(new Customer(null,"ENSET","enset@gmail.com"));
            customerRepository.save(new Customer(null,"ibm","ibm@gmail.com"));
            customerRepository.save(new Customer(null,"hp","hp@hp.com"));
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}