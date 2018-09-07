package org.testautomation.framework.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testautomation.framework.common.Market;

/**
 * Class for representing the markets page and the interactions on it.
 * 
 * @author Sabahattin Kasapoglu
 *
 */
public class MarketsPage extends PageBase {

	private final static String HeaderField = "Local Markets";
	private By headerField = By.xpath("//h1[@class='strip_header']");
	private By viewField = By.xpath("//section[contains(@class,'section--grey')]");

	public void goToMarket(Market market) {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement element = driver.findElement(viewField)
				.findElement(By.xpath("//a[@href='/" + market.getPath() + "']"));
		wait.until(ExpectedConditions.visibilityOf(element));

		element.click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

	}

	/**
	 * Checks if the current url is same with the /baseUrl/{marketurl} via checking
	 * the getUrl
	 * 
	 * @param market
	 *            selected type of {@link Market}
	 * @return {@link True} if correct url is navigated, {@link False} otherwise
	 */
	public boolean isNavigatedToMarket(Market market) {
		return driver.getCurrentUrl().equals(BaseUrl + market.getPath());
	}

	public boolean isAt() {
		return driver.findElement(headerField).getText().equals(HeaderField);
	}

}
