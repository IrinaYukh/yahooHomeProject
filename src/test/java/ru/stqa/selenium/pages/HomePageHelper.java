package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class HomePageHelper extends PageBase {

  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  @FindBy(id = "uh-logo")
  WebElement siteLogo;


  public HomePageHelper(WebDriver webDriver) {
    super(webDriver);
  }

  public HomePageHelper waitUntilHomePageIsLoaded()
  {
    waitUntilElementIsloaded(driver,siteLogo,15);
    return this;
  }


}
