package org.testautomation.framework.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testautomation.framework.common.Driver;

/**
 * Abstract class for all pages for common operations
 * 
 * @author Sabahattin Kasapoglu
 *
 */
public abstract class PageBase {

	protected static final String BaseUrl = "https://www.groupm.com/";
	protected final WebDriver driver;

	PageBase() {
		driver = Driver.driver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
