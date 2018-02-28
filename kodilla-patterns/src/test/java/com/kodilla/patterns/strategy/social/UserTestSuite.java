package com.kodilla.patterns.strategy.social;


import static org.junit.Assert.*;

import com.kodilla.patterns.strategy.social.networks.FacebookPublisher;
import com.kodilla.patterns.strategy.social.networks.SnapchatPublisher;
import org.junit.*;

public class UserTestSuite {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Kodilla module 11.3:  begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Spring module 11.3: end");
    }
    @Before
    public void before() {
        System.out.println("Preparing to execute Strategy  ");
    }
    @After
    public void after() {
        System.out.println("Test to execute Strategye: end");
    }

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User steven = new Millenials("Steven Links");
        User john = new YGeneration("John Hemerald");
        User karoline = new ZGeneration("Karoline");

        //When
        String stevenPublish = steven.sharePost();
        System.out.println("Steven publish in: " + stevenPublish);
        String johnPublish = john.sharePost();
        System.out.println("John publish in: " + johnPublish);
        String karolinePublish = karoline.sharePost();
        System.out.println("Karoline publish in: " + karolinePublish);

        //Then
        assertEquals("TwarzoKsiazka", stevenPublish);
        assertEquals("Snapchat", johnPublish);
        assertEquals("Twitter", karolinePublish);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User steven = new Millenials("Steven Links");

        //When
        String stevenPublish = steven.sharePost();
        System.out.println("Steven publish in: " + stevenPublish);
        steven.setPublisher(new SnapchatPublisher());
        stevenPublish = steven.sharePost();
        System.out.println("Steven now should: " + stevenPublish);

        //Then
        assertEquals("Snapchat", stevenPublish);
    }
}

