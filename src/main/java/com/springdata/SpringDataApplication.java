package com.springdata;

import com.springdata.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonSpringDataRepository personSpringDataRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("User id 10001 -> {}", personSpringDataRepository.findById(10001));

        logger.info("Inserting -> {}",
                personSpringDataRepository.save(new Person("Tara", "Berlin", new Date())));

        logger.info("Update 10003 -> {}",
                personSpringDataRepository.save(new Person(10003, "Pieter", "Utrecht", new Date())));

        personSpringDataRepository.deleteById(10002);

        logger.info("All users -> {}", personSpringDataRepository.findAll());
    }
}
