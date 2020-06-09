package com.testfeature;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class testApplication {

    public static void main(String[] args)
    {
        ApplicationContext applicationContext = SpringApplication.run(testApplication.class, args);

        BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
        //int result = binarySearch.binarySearch(new int[]{1,2,3,4},2);
        //System.out.println("Element AT: "+result);
    }

}
