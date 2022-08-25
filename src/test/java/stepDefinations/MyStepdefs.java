package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    public WebDriver driver;

    @Given("User launch Chrome browser")
    public void userLaunchChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @When("^user open URL (.*)$")
    public void userOpenURLHttpsDemoqaCom(String url) {
        driver.get(url);
    }
    @Then("User Validate Total count of Cards {int}")
    public void userValidateTotalCountOfCards(int expectedcount) {
        List<WebElement> AllElements = driver.findElements(By.cssSelector(".card-body"));
        int ActualcountofWebelement = AllElements.size();
        Assert.assertEquals(ActualcountofWebelement, expectedcount);

    }

    @Then("close browser")
    public void closeBrowser() {
        driver.quit();
    }
}
