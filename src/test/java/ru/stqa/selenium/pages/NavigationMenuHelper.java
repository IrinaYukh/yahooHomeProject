package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NavigationMenuHelper extends  PageBase
{
    Actions action = new Actions(driver);

   @FindBy(xpath = "//a[contains(text(),'Finance')]")
   WebElement financeMenuButton;

    public NavigationMenuHelper(WebDriver driver) {
        super(driver);
    }

    public NavigationMenuHelper clickFinanceButton()
    {
        waitUntilElementIsloaded(driver,financeMenuButton,50);
        action.moveToElement(financeMenuButton).click().build().perform();
        return this;
    }

}
