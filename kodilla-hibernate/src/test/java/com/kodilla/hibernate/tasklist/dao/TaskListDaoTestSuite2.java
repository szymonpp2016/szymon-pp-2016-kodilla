package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.TaskHQL;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskDaoHQL;
import com.kodilla.hibernate.tasklist.TaskListHQL;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite2 {
    @Autowired
    private TaskListDaoHQL taskListDao;
    @Autowired
    private TaskDaoHQL taskDao;
    private static final String DESCRIPTION = "Test:LearnHibernate";
    private static final String LISTNAME = "Tabela_nr_1";


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




    @Test
    public void testNamedQueries() {
        //Given
        TaskHQL task1 = new TaskHQL("Test: Study Hibernate", 3);
        TaskHQL task2 = new TaskHQL("Test: Practice Named Queries", 6);
        TaskHQL task3 = new TaskHQL("Test: Study native queries", 7);
        TaskHQL task4 = new TaskHQL("Test: Makse some tests", 13);

        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(5), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        TaskFinancialDetails tfd3 = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd4 = new TaskFinancialDetails(new BigDecimal(15), false);

        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        task3.setTaskFinancialDetails(tfd3);
        task4.setTaskFinancialDetails(tfd4);

        TaskListHQL taskList = new TaskListHQL(LISTNAME, DESCRIPTION);
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        taskList.getTasks().add(task3);
        taskList.getTasks().add(task4);

        task1.setTaskList(taskList);
        task2.setTaskList(taskList);
        task3.setTaskList(taskList);
        task4.setTaskList(taskList);

        taskListDao.save(taskList);
        int id = taskList.getId();

        //When
        List<TaskHQL> longTasks = taskDao.retrieveLongTasks();
        List<TaskHQL> shortTasks = taskDao.retrieveShortTasks();
        List<TaskHQL> enoughTimeTasks = taskDao.retrieveTasksWithEnoughTime();
        List<TaskHQL> durationLongerThenTasks = taskDao.retrieveTasksWithDurationLongerThan(6);
        //Then
        try {
            Assert.assertEquals(1, longTasks.size());
            Assert.assertEquals(3, shortTasks.size());
            Assert.assertEquals(3, enoughTimeTasks.size());
            Assert.assertEquals(2, durationLongerThenTasks.size());
        } finally {
            //CleanUp
            taskListDao.delete(id);
        }
    }


}