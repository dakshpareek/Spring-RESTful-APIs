package com.aopexamples.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class Dao {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String retriveData()
    {
        logger.info("dao called");
        return "Dao called.. !!";
    }
}
