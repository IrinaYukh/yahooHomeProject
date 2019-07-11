package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FinancePageHelper extends PageBase{
    public FinancePageHelper(WebDriver driver) {
        super(driver);
    }

    Actions action = new Actions(driver);

    @FindBy(xpath = "//input[@id='yfin-usr-qry']")
    WebElement searchField;

    @FindBy(xpath = "//button[@id='search-button']")
    WebElement searchButton;

    @FindBy(xpath = "//span[contains(text(),'Historical Data')]")
    WebElement historicalDataButton;

    @FindBy(xpath = "//span[contains(text(),'Time Period')]")
    WebElement periodTimeRange;

    @FindBy(xpath = "//span[contains(text(),value)]")
    WebElement data;

    @FindBy(xpath = "//tr//span[contains(text(),value)]")
    WebElement row;

    public FinancePageHelper enterSearchElement(String searchElement)
    {
        enterValueToField(searchField,searchElement);
        return this;
    }

    public FinancePageHelper clickSearchButton()
    {
        action.moveToElement(searchButton).click().build().perform();
        waitUntilElementIsloaded(driver,historicalDataButton,20);
        return this;
    }

    public FinancePageHelper clickHistoricalDataButton()
    {
        action.moveToElement(historicalDataButton).click().build().perform();
        waitUntilElementIsloaded(driver,periodTimeRange,20);
        return this;
    }

    public FinancePageHelper selectDataRowFromTable(String value)
    {
        action.moveToElement(data).click().build().perform();
        return this;
    }

    public FinancePageHelper verifyRowValues(String value,String open,String high,
                                             String low, String close, String adjClose, String volume)
    {
        List<WebElement> row = driver.findElements(By.xpath("//body//tr[8]"));
        // //tr//span[contains(text(),value)]
        for (WebElement el:row)
        {
            System.out.println(el.getText());
        }

        List<String> arr = new ArrayList<>();
            arr.add(0,value);
            arr.add(1,open);
            arr.add(2,high);
            arr.add(3,low);
            arr.add(4,close);
            arr.add(5,adjClose);
            arr.add(6,volume);

            if (row.equals(arr))
            {
                System.out.println("All values in the row with data " + value + " is correct");
            }
            else
            {
                System.out.println("Some values is not correct for data " + value);
            }

        return this;
    }

    public FinancePageHelper arrValues(String value,String open,String high,
                                             String low, String close, String adjClose, String volume)
    {
        ArrayList<String> arr = new ArrayList<>();
        arr.add(0,value);
        arr.add(1,open);
        arr.add(2,high);
        arr.add(3,low);
        arr.add(4,close);
        arr.add(5,adjClose);
        arr.add(6,volume);
        return this;
    }

}
