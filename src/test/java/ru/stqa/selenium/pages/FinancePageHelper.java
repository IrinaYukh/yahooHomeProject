package ru.stqa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.stqa.selenium.model.Row;

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
        //1. Create object
        Row newR = new Row(value, open, high, low, close, adjClose, volume);

        //2. Scanning web page
        //2.1. Get first row
        List <WebElement> row = driver.findElements(By.xpath("//body//tr[8]"));
        //2.2 Get all td in the 'row'
        List <WebElement> list_of_elements = row.get(0).findElements(By.xpath("//body//tr[8]/td"));
        // //tr//span[contains(text(),value)]
        System.out.println("Size of the list_of_elements " + list_of_elements.size());
        System.out.println("Compare " + newR.getData() + " vs. "+ list_of_elements.get(0).getText());
        boolean a1 = newR.getData().equals(list_of_elements.get(0).getText());

        System.out.println("Compare " + newR.getOpen() + " vs. "+ list_of_elements.get(1).getText());
        boolean a2 = newR.getOpen().equals(list_of_elements.get(1).getText());

        System.out.println("Compare " + newR.getHigh() + " vs. "+ list_of_elements.get(2).getText());
        boolean a3 = newR.getHigh().equals(list_of_elements.get(2).getText());
        boolean a4 = newR.getLow().equals(list_of_elements.get(3).getText());
        boolean a5 = newR.getClose().equals(list_of_elements.get(4).getText());
        boolean a6 = newR.getAdjClose().equals(list_of_elements.get(5).getText());
        boolean a7 = newR.getVolume().equals(list_of_elements.get(6).getText());
        if (a1 && a2 && a3 && a4 && a5 && a6 && a7 )
        {
            System.out.println("Equal");
        }
        else
        {
            System.out.println("JOPA");
        }
        return this;
    }


}
