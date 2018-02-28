package com.kodilla.spring.forum;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ForumUserTestSuite {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Spring module 10.1:  begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Spring module 10.1: end");
    }
    @Before
    public void before() {
        System.out.println("Preparing to execute SPRING (Bean) -  getUsername");
    }
    @After
    public void after() {
        System.out.println("Test SPRING (Bean) getUsername: end");
    }

    @Test
    public void testGetUsername() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.forum");
        ForumUser forumUser = context.getBean(ForumUser.class);
        //When
        String username = forumUser.getUsername();
        //Then
        assertEquals("John Smith", username);
    }
}
