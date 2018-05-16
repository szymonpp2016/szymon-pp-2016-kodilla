package kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CrudAppTestSuite {
    private static final String CRUDAPP_HOME = "https://szymonpp2016.github.io/index.html";
    private final String TRELLO_URL = "https://trello.com/login";
    private WebDriver webDriverTaskCrudApp;
    private Random generator;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Automation: suite Task and Trello Api (XPATH): begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Automation: suite Task and Trello Api (XPATH): end");
    }

    @Before
    public void initTests() {
        System.out.println("Test Case: begin");
        WebDriver webDriverTaskCrudApp = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        if (webDriverTaskCrudApp != null) {
            webDriverTaskCrudApp.get(CRUDAPP_HOME);
        }
        generator = new Random();
        this.webDriverTaskCrudApp = webDriverTaskCrudApp;
    }

    @After
    public void cleanUpAfterTest() {
        System.out.println("Test Case: end");
        webDriverTaskCrudApp.close();
    }

    @Test
    public void test1shouldCreateTrelloCard() throws InterruptedException {
        //Given
        String taskNameTest1 = createCrudAppTestTask();
        //When
        sendTestTaskToTrello(taskNameTest1);

        //Then
        assertTrue(checkTaskExistsInTrello(taskNameTest1));
        //clenup
        deleteCrudTestTask(taskNameTest1);
    }

    @Test
    public void test2CreataAndDeleteTask() throws InterruptedException {
        //Given
        String taskNameTest2 = createCrudAppTestTask();
        int resultNumberOfTaskAfterCraeted;
        int resultNumberOfTaskAfterDeleted;
        while (!webDriverTaskCrudApp.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        //When
        resultNumberOfTaskAfterCraeted= findCurrentTask(taskNameTest2);
        deleteCrudTestTask(taskNameTest2);
        while (!webDriverTaskCrudApp.findElement(By.xpath("//select[1]")).isDisplayed()) ;
        resultNumberOfTaskAfterDeleted=findCurrentTask(taskNameTest2);
        //Then
        assertEquals(resultNumberOfTaskAfterDeleted, resultNumberOfTaskAfterCraeted - 1);
    }





    private int  findCurrentTask(String taskNameTest2) throws InterruptedException {
        Thread.sleep(2000);
        return webDriverTaskCrudApp.findElements(By.xpath("//form[contains(@class, \"datatable__row\")]")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskNameTest2))
                .collect(Collectors.toList())
                .size();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME_ABSLOTU = "//html/body/main/section[1]/form/fieldset[1]/input";
        final String XPATH_TASK_NAME_RELATIV = "//div[contains(@actions, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"createTas\")]/fieldset[3]/button";
        String taskName = "Task number" + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = webDriverTaskCrudApp.findElement(By.xpath(XPATH_TASK_NAME_ABSLOTU));
        name.sendKeys(taskName);
        WebElement content = webDriverTaskCrudApp.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);
        WebElement addButton = webDriverTaskCrudApp.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);
        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        webDriverTaskCrudApp.navigate().refresh();
        while (!webDriverTaskCrudApp.findElement(By.xpath("//select[1]")).isDisplayed()) ;
        webDriverTaskCrudApp.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        webDriverTaskCrudApp.navigate().refresh();
        Thread.sleep(5000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {

        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        if (driverTrello != null) {
            driverTrello.get(TRELLO_URL);
            driverTrello.findElement(By.id("user")).sendKeys("szymon.pp.2016@interia.pl");
            driverTrello.findElement(By.id("password")).sendKeys("testtesttest");
            driverTrello.findElement(By.id("login")).submit();
            Thread.sleep(5000);
            driverTrello.findElements(By.xpath("//a[contains(@class,\"board-tile \")]")).stream()
                    .filter(aHref -> aHref.findElements(By.xpath(".//span[@title=\"Kodilla Application\"]")).size() > 0)
                    .forEach(aHref -> aHref.click());

          /*  driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                    // .filter(aHref -> aHref.findElements(By.xpath(".//span[@title=\"Kodilla Application\"]")).size()>0) //"board-tile"- not working becouse of pattern in KOdilla button (sky))!!!! current name "board-tile mod-light-background\""
                    .forEach(aHref -> aHref.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div[1]/ul/li[1]")).click());  -this work fine */
            Thread.sleep(5000);
            result = driverTrello.findElements(By.xpath("//span[contains(@class, \"list-card-title\")]")).stream()
                    .filter(theSpan -> theSpan.getText().contains(taskName))
                    .collect(Collectors.toList())
                    .size() > 0;
            Thread.sleep(5000);
            driverTrello.close();
        }
        return result;
    }

    private void deleteCrudTestTask(String taskName) throws InterruptedException {
        webDriverTaskCrudApp.navigate().refresh();
        if (webDriverTaskCrudApp == null) webDriverTaskCrudApp.get(CRUDAPP_HOME);

        while (!webDriverTaskCrudApp.findElement(By.xpath("//select[1]")).isDisplayed()) ;
        webDriverTaskCrudApp.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement deleteButton = theForm.findElement(By.xpath(".//button[4]"));
                    deleteButton.click();
                });
        Thread.sleep(5000);
    }
}
