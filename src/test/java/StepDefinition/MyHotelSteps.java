package StepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class MyHotelSteps {
    private WebDriver driver;

    @Given("User open browser with My Hotel main page")         //@Given taki sam jak w pliku .feature
    public void UserOpenBrowserWithMyHotelMainPage(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);     //czekaj 5 sekund
        driver.get("https://qloapps.coderslab.pl/");
    }

    @When("User click sign in button")
    public void userClickSignInButton() {
        WebElement login = driver.findElement(By.cssSelector(".user_login.navigation-link"));
        login.click();
    }

    @When("User enter email (.*) and click create an account button")
    public void userEnterEmailAndClickCreateAnAccountButton(String email){

        WebElement emailCreate = driver.findElement(By.id("email_create"));
        emailCreate.sendKeys(email);

        WebElement button = driver.findElement(By.id("SubmitCreate"));
        button.click();
    }

    @When("User enter title (.*) on personal information page")
    public void userEnterTitleOnPersonalInformationPage(String Pan){
        WebElement title = driver.findElement(By.id("id_gender1"));
        title.click();
    }

    @When("^User enter first name (.*) on field first name$")
    public void userEnterFirstNameOnFieldFirstName(String name) {
        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        firstName.sendKeys(name);
    }

    @When("^User enter last name (.*) on field last name$")
    public void userEnterLastNameOnFieldLastName(String userlastname) {
        WebElement lastName = driver.findElement(By.id("customer_lastname"));
        lastName.sendKeys(userlastname);
    }

    @When("^User enter password (.*) on field password$")
    public void userEnterPasswordOnFieldPassword(String userpassword) {
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys(userpassword);
    }

    @When("^User enter date of birthday on field date of Birthday$")
    public void userEnterDateOfBirthdayOnFieldDateOfBirthday() {
        Select dropDownDay = new Select(driver.findElement(By.id("days")));
        dropDownDay.selectByValue("20");

        Select dropDownMonth = new Select(driver.findElement(By.id("months")));
        dropDownMonth.selectByValue("11");

        Select dropDownYear = new Select(driver.findElement(By.id("years")));
        dropDownYear.selectByValue("1956");
    }
    

    @When("^User enter in checkbox sign up for newsletter and receive special offers$")
    public void userEnterInCheckboxSignUpForNewsletterAndReceiveSpecialOffers() {
        WebElement newsletter = driver.findElement(By.id("newsletter"));
        newsletter.click();
        
        WebElement ofert = driver.findElement(By.id("optin"));
        ofert.click();
        
        WebElement submite = driver.findElement(By.id("submitAccount"));
        submite.click();
    }

    @Then("^The first one should contain create new account$")
    public void theFirstOneShouldContainCreateNewAccount() {
        System.out.println("Create new account");
    }

////    @And("^Close browser$")
////    public void closeBrowser() {
////        driver.quit();
////    }
//
//}
