package com.kodilla.jdbc;

import static  org.junit.Assert.*;
import org.junit.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeClass() {

        System.out.println("Test Kodilla module 12.6:  begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("\n Test  module 12.6: end \n");
    }
    @Before
    public void before() {
        testCounter++;
        System.out.println("\n Preparing to execute `JDBC` #" +testCounter);
    }
    @After
    public void after() {
        System.out.println("Test 'JBDC': end #"+testCounter);
    }

    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        //When
        String sqlQuery = "SELECT  U.FIRSTNAME, U.LASTNAME, I.USER_ID_ASSIGNEDTO AS USER_ID, COUNT(*) AS POST_NUMBER\n" +
                "FROM issuess I, users U\n" +
                "WHERE I.USER_ID_ASSIGNEDTO = U.ID\n" +
                "GROUP BY U.FIRSTNAME, U.LASTNAME\n" +
                "HAVING COUNT(*) > 1;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
        //Then
        int counter = 0;
        while(rs.next()) {
            counter++;
            System.out.println(counter+". "+rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
        }
        rs.close();
        statement.close();
        assertEquals(2, counter);
    }

}