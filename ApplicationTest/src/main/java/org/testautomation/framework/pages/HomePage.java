package org.testautomation.framework.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testautomation.framework.common.SelectionMenu;

public class HomePage extends PageBase {

	private By logoField = By.xpath("//img[@src='/themes/custom/groupm/logo.png']");
	private By menuField = By.xpath("//nav[@id='block-groupm-main-menu']");
	private By menuItemField = By.xpath("//li");

	/**
	 * Navigates to home page.
	 */
	public void goTo() {
		driver.navigate().to(BaseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * Checks if the home page is displayed
	 * 
	 * @return {@link True} if home page can be reached, {@link False} otherwise
	 */
	public boolean isAt() {
		return driver.findElement(logoField).isDisplayed();
	}

	/**
	 * Navigates to the menu item on home page.
	 * 
	 * @param menu
	 *            type of {@link SelectionMenu}
	 */
	public void navigateTo(SelectionMenu menu) {

		List<WebElement> menuItems = driver.findElement(menuField).findElements(menuItemField);

		for (WebElement webElement : menuItems) {

			if (webElement.getText().equals(menu.text())) {
				webElement.click();
				break;
			}
		}
	}
}
