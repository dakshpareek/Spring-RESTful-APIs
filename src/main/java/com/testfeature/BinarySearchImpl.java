package com.testfeature;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;


@Component
public class BinarySearchImpl
{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public int binarySearch(int[] arr,int n)
    {
        return Arrays.binarySearch(arr, n);
    }

    @PostConstruct
    public void postMethod()
    {
        logger.info("postConstruct");
        System.out.println("Do this before construction of Bean");
    }

    @PreDestroy
    public void preDestroy()
    {
        logger.info("PreDestroy");
        System.out.println("Do this before construction deleting bean");
    }

}
