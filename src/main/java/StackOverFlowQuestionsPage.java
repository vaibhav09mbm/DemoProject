import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StackOverFlowQuestionsPage {


	WebDriver driver;
	By mostPopularBtn = By.xpath("//a[@title='most popular tags']");
	By questionTiles = By.xpath("//*[contains(@class,'s-card')]");
	
	public StackOverFlowQuestionsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * this method checks if the popular button is clicked
	 * @return
	 */
	public  boolean isPopularClicked() {
		String color = driver.findElement(mostPopularBtn).getCssValue("background-color");
		return color.equals("rgba(228, 230, 232, 1)");
	}
	
	public void clickPopular() {
		driver.findElement(mostPopularBtn).click();
	}
	
	/**
	 * The Method accepts the rank of the tag
	 * @param index integer
	 * @return the text in the tile
	 */
	public String getDataFromTile(int index) {
	WebElement questionTiles =	driver.findElement(By.xpath("//*[contains(@class,'s-card')]["+ index + "]" ));
	return questionTiles.getText();
		
	}
	

}
