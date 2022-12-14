package utilities;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;


public class Functions {

static WebDriver driver;
	public static String test_type;
	@Step("open url {0} in web browser")
	public static void openURL(String url){
		driver.get(url);
	}
	@Step("click on element - {0}")
	public static void click(WebElement element) throws InterruptedException{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	public static void setText(WebElement locator, String value) throws InterruptedException{
		Thread.sleep(1000);
		locator.clear();
		locator.sendKeys(value);
	}
	public static void mousehover(WebElement element) throws InterruptedException{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public static void doubleClick(WebElement element) throws InterruptedException{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	@Step("verify element displayed")
	public static void verifyElementDisplayed(WebElement element) throws InterruptedException{
		Thread.sleep(1000);
		Assert.assertTrue(element.isDisplayed());
	}
	public static void verifyText(WebElement element, String text) throws InterruptedException{
		Thread.sleep(1000);
		Assert.assertEquals(element.getText(), text);
	}
	public static void takescreenshot(String testname) throws IOException
	{
		File myfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(myfile, new File("Screenshots\\"+testname+"fail.png"));
	}
	@Attachment
	public static byte[] saveFailureScreenShot()
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
		public static void initPageFactory(Class page)
		{
			PageFactory.initElements(driver, page);
		}

	@Step("{0}")
	public static void logStep(String message){
		// intentionally kept empty
	}

	}

