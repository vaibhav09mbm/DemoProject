import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestStackOverflow {

	public static final int TAG_RANK =3;
	public static final String STACK_OVER_URL = "https://stackoverflow.com/tags";
	WebDriver driver;
    File driverExe = new File ("src/main/resources/chromedriver.exe");
	@Test
	public void getDataForThirdPopularTag() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				driverExe.getAbsolutePath());

		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(STACK_OVER_URL);
		StackOverFlowQuestionsPage stackOve = new StackOverFlowQuestionsPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(stackOve.mostPopularBtn));
		if(!stackOve.isPopularClicked())
		stackOve.clickPopular();	
		stackOve.getDataFromTile(TAG_RANK);
	}
	
	@AfterTest
	public void close() {
		driver.close();
		driver.quit();

	}
}
