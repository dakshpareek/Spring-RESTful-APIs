package com.testfeature;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = testApplication.class)
class BinarySearchImplTest {

    @BeforeClass
    public static void beforeClass()
    {
        System.out.println("Before Initializing Class");
    }

    @Before
    public void beforeMethod()
    {
        System.out.println("Before Running Any Test Case");
    }

    @Autowired
    BinarySearchImpl binarySearch;

    @Test
    void test1() {
        assertEquals(1,binarySearch.binarySearch(new int[]{1,2,3,4},2));
    }

    @Test
    void test2() {

        assertTrue( binarySearch.binarySearch(new int[]{1,2,3,4,5},8) < 0);
    }


    @AfterClass
    public static void afterClass()
    {
        System.out.println("Before closing Class");

    }

    @After
    public void afterMethod()
    {
        System.out.println("After running all test methods");
    }

}