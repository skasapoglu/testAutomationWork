package org.testautomation.test;

import org.testautomation.framework.common.Driver;
import org.testautomation.framework.common.Market;
import org.testautomation.framework.common.SelectionMenu;
import org.testautomation.framework.pages.HomePage;
import org.testautomation.framework.pages.MarketsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TrialUserInterfaceTest {

	@AfterMethod
	public void afterMethod() {
		Driver.quit();
	}

	@Test
	public void userCanOpenUpHomePage() {

		// GIVEN
		HomePage homePage = new HomePage();

		// WHEN
		homePage.goTo();

		// THEN
		Assert.assertTrue(homePage.isAt(), "Home page for the application cannot be displayed");
	}

	@Test
	public void userCanNavigateToSelectedMarket() {

		// GIVEN
		HomePage homePage = new HomePage();
		homePage.goTo();

		// WHEN
		homePage.navigateTo(SelectionMenu.MARKETS);
		MarketsPage marketPage = new MarketsPage();
		
		// AND
		marketPage.goToMarket(Market.CANADA);

		// THEN
		Assert.assertTrue(marketPage.isNavigatedToMarket(Market.CANADA), "Corresponding market cannot be navigated");

	}

}
