package frstExcercise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


public class DataListSecondTest {

    private WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        this.driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }


    @Test

    public void loginTest() {

        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.click();
        firstName.sendKeys(DataListOneTest.getRandomName());
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();       // Zamknij przeglądarkę
    }
}
