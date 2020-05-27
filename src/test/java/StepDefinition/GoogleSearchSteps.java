package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchSteps {
    public String keyword;
    private WebDriver driver;

    @Given("an open browser with google.com")
    public void openGoogleSearch() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        driver = new FirefoxDriver();       //driver działa z różnymi przeglądarkami ChromeDriver()


        driver.manage().window().maximize();        // Zmaksymalizuj
        driver.get("http://www.google.com");}    //definicje metod


    @When("a keyword (.*) is entered in input field")
    public void enterKeyword(String keyword) {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("q"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();
        // Wpisz informacje do wyszukania
        element.sendKeys(keyword);
        // Prześlij formularz
        element.submit();}

        @Then("the first one should contain (.*)")
    public void theFirstOneShouldContainKeyword(String keyword) {
        System.out.println(keyword);}

        @And("close browser")
    public void closeBrowser(){
        driver.quit();
    }
}