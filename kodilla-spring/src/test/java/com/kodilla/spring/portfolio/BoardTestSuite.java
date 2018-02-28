package com.kodilla.spring.portfolio;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class BoardTestSuite {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Spring module 10.3:  begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Spring module 10.3: end");
    }
    @Before
    public void before() {
        System.out.println("Preparing to execute SPRING (Bean) -  getList");
    }
    @After
    public void after() {
        System.out.println("Test SPRING (Bean) getList: end");
    }

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Board board = context.getBean(Board.class);
        List<String> toDoList = board.getToDoList().getTasks();   // a moze właściwsze jest ToDoList toDoList = board.getToDoList(); i potem toDoList.getTask().add("task1");??
        List<String> inProgressList =board.getInProgressList().getTasks();
        List<String> doneList =board.getDoneList().getTasks();
        List<String> tmpList = new ArrayList<>();
        //When
        toDoList.add("task1");
        inProgressList.add("task1");
        doneList.add("task1");
        tmpList.add("task1");
        //Then

        assertEquals(tmpList, toDoList );
        assertEquals(tmpList, inProgressList );
        assertEquals(tmpList, doneList );

        System.out.println("===== Beans list: START ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list: END ====");
    }

}
