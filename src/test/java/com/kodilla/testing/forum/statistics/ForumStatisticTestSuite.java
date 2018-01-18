package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticTestSuite {

    private static int testCounter = 0;
    @Before
    public void before() {
        testCounter++;
        System.out.println("Preparing to execute test #"+ testCounter);
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }
    @Test
    public void testCalculateStaticticNoPosts(){
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> list = new ArrayList<String>();
        list.add("Jan Kowalski");
        when(statisticMock.usersNames()).thenReturn(list);
        when(statisticMock.commentsCount()).thenReturn(0);
        when(statisticMock.postsCount()).thenReturn(0);

        //When
        CalculateStatistic calculateStatistic = new CalculateStatistic();
        calculateStatistic.calculateAdvStatistics(statisticMock);

        //Then
        Assert.assertEquals(0.0, calculateStatistic.getAverageCommentsPerPost(), 0);
        Assert.assertEquals(0.0, calculateStatistic.getAverageCommentsPerUser(), 0);
        Assert.assertEquals(0.0, calculateStatistic.getAveragePostPerUser(),0 );
    }
    @Test
    public void testCalculateStatictic1000Posts(){
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> list = new ArrayList<String>();
        list.add("Jan Kowalski");
        when(statisticMock.usersNames()).thenReturn(list);
        when(statisticMock.commentsCount()).thenReturn(0);
        when(statisticMock.postsCount()).thenReturn(1000);

        //When
        CalculateStatistic calculateStatistic = new CalculateStatistic();
        calculateStatistic.calculateAdvStatistics(statisticMock);

        //Then
        Assert.assertEquals(0.0, calculateStatistic.getAverageCommentsPerPost(), 0);
        Assert.assertEquals(0.0, calculateStatistic.getAverageCommentsPerUser(), 0);
        Assert.assertEquals(1000.0, calculateStatistic.getAveragePostPerUser(),0 );
    }
    @Test
    public void testCalculateStaticticComentsMoreThenPosts(){
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> list = new ArrayList<String>();
        list.add("Jan Kowalski");
        when(statisticMock.usersNames()).thenReturn(list);
        when(statisticMock.commentsCount()).thenReturn(2000);
        when(statisticMock.postsCount()).thenReturn(1000);

        //When
        CalculateStatistic calculateStatistic = new CalculateStatistic();
        calculateStatistic.calculateAdvStatistics(statisticMock);

        //Then
        Assert.assertEquals(2.0, calculateStatistic.getAverageCommentsPerPost(), 0);
        Assert.assertEquals(2000.0, calculateStatistic.getAverageCommentsPerUser(), 0);
        Assert.assertEquals(1000.0, calculateStatistic.getAveragePostPerUser(),0 );
    }
    @Test
    public void testCalculateStaticticPostsMoreThenComents(){
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> list = new ArrayList<String>();
        list.add("Jan Kowalski");
        when(statisticMock.usersNames()).thenReturn(list);
        when(statisticMock.commentsCount()).thenReturn(1000);
        when(statisticMock.postsCount()).thenReturn(2000);

        //When
        CalculateStatistic calculateStatistic = new CalculateStatistic();
        calculateStatistic.calculateAdvStatistics(statisticMock);

        //Then
        Assert.assertEquals(0.5, calculateStatistic.getAverageCommentsPerPost(), 1);
        Assert.assertEquals(1000.0, calculateStatistic.getAverageCommentsPerUser(), 0);
        Assert.assertEquals(2000.0, calculateStatistic.getAveragePostPerUser(),0 );
    }
    @Test
    public void testCalculateStaticticnoUsers(){
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> list = new ArrayList<String>();

        when(statisticMock.usersNames()).thenReturn(list);
        when(statisticMock.commentsCount()).thenReturn(0);
        when(statisticMock.postsCount()).thenReturn(0);

        //When
        CalculateStatistic calculateStatistic = new CalculateStatistic();
        calculateStatistic.calculateAdvStatistics(statisticMock);

        //Then
        Assert.assertEquals(0.0, calculateStatistic.getAverageCommentsPerPost(), 0);
        Assert.assertEquals(0.0, calculateStatistic.getAverageCommentsPerUser(), 0);
        Assert.assertEquals(0.0, calculateStatistic.getAveragePostPerUser(),0 );
    }
    @Test
    public void testCalculateStaticticno100Users(){
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> list = new ArrayList<String>();

        for(int i=0; i<99;i++) {
            list.add("Jan Kowalski");
        }
        when(statisticMock.usersNames()).thenReturn(list);
        when(statisticMock.commentsCount()).thenReturn(100);
        when(statisticMock.postsCount()).thenReturn(100);

        //When
        CalculateStatistic calculateStatistic = new CalculateStatistic();
        calculateStatistic.calculateAdvStatistics(statisticMock);

        //Then
        Assert.assertEquals(1.0, calculateStatistic.getAverageCommentsPerPost(), 0);
        Assert.assertEquals(1.0, calculateStatistic.getAverageCommentsPerUser(), 0);
        Assert.assertEquals(1.0, calculateStatistic.getAveragePostPerUser(),0 );
    }
}
