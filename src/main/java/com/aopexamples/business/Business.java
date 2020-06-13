package com.aopexamples.business;

import com.aopexamples.aspect.TrackTime;
import com.aopexamples.data.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Dao dao;

    @TrackTime
    public void getBusiness()
    {
        logger.info("Business method called");
        dao.retriveData();
    }
}
