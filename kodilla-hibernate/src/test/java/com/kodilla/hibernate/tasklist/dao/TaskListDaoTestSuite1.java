package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite1 {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Kodilla module 13.2:  begin"); }
    @AfterClass
    public static void afterClass() {
        System.out.println("\n Test  module 13.3: end \n");
    }
    @Before
    public void before() {
        System.out.println("\n Preparing to execute test `Tworzymy encję list zadań` : \n " );
    }
    @After
    public void after() {
        System.out.println("\n Test 'Tworzymy encję list zadań': end  " );
    }

    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Test:LearnHibernate";
    private static final String LISTNAME = "Tabela_nr_1";
    private TaskDao taskDao;


     @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(LISTNAME, "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        taskListDao.delete(id);
    }



}