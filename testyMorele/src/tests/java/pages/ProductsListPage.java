package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

//Wszystkie lokatory i metody strony Product Page.
public class ProductsListPage {

    WebDriver driver;
    By priceMinimumSort =By.xpath("/html/body/main/div/div[3]/div[2]/div[1]/div[4]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/input");
    By priceMaximumSort =By.xpath("/html/body/main/div/div[3]/div[2]/div[1]/div[4]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/input");
    By sortButton = By.xpath("/html/body/main/div/div[3]/div[2]/div[1]/div[4]/div[1]/div[2]/div[2]/div[2]/div[2]/button");
    By chooseSortType = By.xpath("/html/body/main/div/div[3]/div[2]/div[1]/div[4]/div[1]/div[3]/div/div[1]/button");
    By priceSorting = By.xpath("/html/body/main/div/div[3]/div[2]/div[1]/div[4]/div[1]/div[3]/div/div[2]/ul/li[3]");
    By brandSortCheck = By.xpath("/html/body/main/div/div[3]/div[2]/aside[2]/form/div[1]/div/div[2]/div[3]/div[2]/div/div[1]/label/span[3]/span[1]");
    By brandSortName = By.xpath("/html/body/main/div/div[3]/div[2]/aside[2]/form/div[1]/div/div[2]/div[3]/div[2]/div/div[1]/label/span[3]/span[1]");
    By pricesClass = By.className("price-new");
    By productsClass = By.className("cat-product-name");

    public ProductsListPage(WebDriver driver){
        this.driver = driver;
    }

    public void SetMinimumPrice(String valueZloty){
        driver.findElement(priceMinimumSort).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(priceMinimumSort).sendKeys(valueZloty);
    }
    public void SetMaximumPrice(String valueZloty){
        driver.findElement(priceMaximumSort).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(priceMaximumSort).sendKeys(valueZloty);
    }
    public void SortButton(){
        driver.findElement(sortButton).click();
    }
    public void SetPriceSorting(){
        driver.findElement(chooseSortType).click();
        driver.findElement(priceSorting).click();
    }
    public List<WebElement> GetPricesList(){
        List<WebElement> pricesList =driver.findElements(pricesClass);
        return pricesList;
    }
    public String BrandSort(){
        driver.findElement(brandSortCheck).click();
        return driver.findElement(brandSortName).getText();
    }

    public List <WebElement> ProductNamesList(){
        List<WebElement> nameList =driver.findElements(productsClass);
        return nameList;
    }

}
