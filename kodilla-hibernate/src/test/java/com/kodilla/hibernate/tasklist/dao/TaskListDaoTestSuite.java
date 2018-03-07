package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

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
    private static final String LISTNAME = "Tabela nr 1";

    @Test
    public void testTaskDaoSave() {
        //Given
        TaskList taskList = new TaskList(LISTNAME,DESCRIPTION);

        //When
        taskListDao.save(taskList);

        //Then
        int id = taskList.getId();
        TaskList readTask = taskListDao.findOne(id);
        assertEquals(id, readTask.getId());

        //CleanUp
        taskListDao.deleteAll();
    }

    @Test
    public void testTaskDaoFindByListName_1() {
        //Given
        TaskList taskList = new TaskList(LISTNAME,DESCRIPTION);
        taskListDao.save(taskList);

        //When
        List<TaskList> readTasks = taskListDao.findByListName(LISTNAME);

        //Then
        assertEquals(LISTNAME, readTasks.get(0).getlistName());

        //CleanUp
        int id = readTasks.get(0).getId();
        taskListDao.delete(id);
    }

    @Test
    public void testTaskDaoFindByListName_2() {
        //Given
        TaskList taskList = new TaskList(LISTNAME,DESCRIPTION);
        taskListDao.save(taskList);

        //When
        Boolean listName =   taskListDao.findByListName(LISTNAME).stream()
                .findFirst()
                .isPresent();

        //Then
        assertEquals(true, listName);

        //CleanUp
        taskListDao.deleteAll();
    }

    @Test
    public void testTaskDaoFindByListName_3() {
        //Given
        TaskList taskList = new TaskList(LISTNAME,DESCRIPTION);
        taskListDao.save(taskList);

        //When
        int listNameInt = Math.toIntExact(taskListDao.findByListName(LISTNAME).stream()
                .count());

        //Then
        assertEquals(1, listNameInt);
        //CleanUp
        taskListDao.deleteAll();
    }
    @Test
    public void testTaskDaoFindByListName_4() {
        //Given
        TaskList taskList = new TaskList(LISTNAME, DESCRIPTION);
        taskListDao.save(taskList);

        //When
        int listNameInt = taskListDao.countByListName(LISTNAME);

        //Then
        assertEquals(1, listNameInt);
        //CleanUp
        taskListDao.deleteAll();
    }

}
