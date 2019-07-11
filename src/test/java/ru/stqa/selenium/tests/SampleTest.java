package ru.stqa.selenium.tests;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.selenium.pages.FinancePageHelper;
import ru.stqa.selenium.pages.HomePageHelper;
import ru.stqa.selenium.pages.NavigationMenuHelper;

public class SampleTest extends TestBase {

  private HomePageHelper homepage;
  private NavigationMenuHelper navigation;
  private FinancePageHelper financePage;

  @BeforeMethod
  public void initPageObjects()
  {
    homepage = PageFactory.initElements(driver, HomePageHelper.class);
    navigation = PageFactory.initElements(driver,NavigationMenuHelper.class);
    financePage = PageFactory.initElements(driver, FinancePageHelper.class);
  }


  @Test
  public void testHomePageHasAHeader()
  {
    homepage.waitUntilHomePageIsLoaded();
    Assert.assertTrue("Yahoo".equals(homepage.header.getText()));
    navigation.clickFinanceButton();
    financePage.enterSearchElement("BA");
    financePage.clickSearchButton();
    financePage.clickHistoricalDataButton();
    financePage.selectDataRowFromTable("Jul 01, 2019");
    financePage.verifyRowValues("Jul 01, 2019", "364.88","365.23","353.32",
                                "356.46","356.46", "6,409,600");

  }


}
