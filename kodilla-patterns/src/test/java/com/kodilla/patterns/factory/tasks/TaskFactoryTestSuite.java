package com.kodilla.patterns.factory.tasks;

import static  org.junit.Assert.*;

import org.junit.*;

public class TaskFactoryTestSuite {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Kodilla module 11.4:  begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test  module 11.4: end");
    }
    @Before
    public void before() { System.out.println("Preparing to execute `Factory`  ");
    }
    @After
    public void after() {
        System.out.println("Test 'Factory': end");
    }

    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task drivingTask = taskFactory.makeTask(TaskFactory.DRIVINGTASK);
        assert drivingTask != null;
        drivingTask.executeTask();
        //Then
        assertEquals("DRIVINGTASK", drivingTask.getTaskName());
        assertEquals(true, drivingTask.isTaskExecuted());
    }

    @Test
    public void testFactoryDrivingTaskNoFactory() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task drivingTask = taskFactory.makeTask("DRIVINGTASK");
        assert drivingTask != null;
        drivingTask.executeTask();
        //Then
        assertEquals("DRIVINGTASK", drivingTask.getTaskName());
        assertEquals(true, drivingTask.isTaskExecuted());
    }


    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task paintingTask = taskFactory.makeTask(TaskFactory.PAINTINGTASK);
        assert paintingTask != null;
        paintingTask.executeTask();
        //Then
        assertEquals("PAINTINGTASK", paintingTask.getTaskName());
        assertEquals(true, paintingTask.isTaskExecuted());
    }


    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPINGTASK);
        assert shoppingTask != null;
        shoppingTask.executeTask();
        //Then
        assertEquals("SHOPPINGTASK", shoppingTask.getTaskName());
        assertEquals(true, shoppingTask.isTaskExecuted());
    }
}
