package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

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
    private static final String DESCRIPTION = "Test: Learn Hibernate";
    private static final String FILENAME = "Tabela nr 1";

    @Test
    public void testTaskDaoSave() {
        //Given
        TaskList taskList = new TaskList(FILENAME,DESCRIPTION);

        //When
        taskListDao.save(taskList);

        //Then
        int id = taskList.getId();
        TaskList readTask = taskListDao.findOne(id);
        Assert.assertEquals(id, readTask.getId());

        //CleanUp
        taskListDao.deleteAll();
    }
}
