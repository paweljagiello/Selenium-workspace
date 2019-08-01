package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class MobilePage {

    WebDriver driver;
    By firstProductPrice =By.id("product-price-1");
    By firstProduct = By.id("product-collection-image-1");
    By randomToBasket = By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button");
    By pageTitle = By.className("page-title");
    By productsNames = By.cssSelector("ul.products-grid h2.product-name");
    By xperiaCompare = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a");
    By iphoneCompare = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a");
    By compareButton = By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/div[1]/div[2]/div/button");
    By iphoneWish = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[1]/a");

    public MobilePage(WebDriver driver) {
        this.driver = driver;
    }

    public String GetProductPrice(){
        return driver.findElement(firstProductPrice).getText();
    }
    public void GoProductPage(){
        driver.findElement(firstProduct).click();
    }
    public void AddRandomToBasket(){
        driver.findElement(randomToBasket).click();
    }
    public String GetPageTitle(){
        return driver.findElement(pageTitle).getText();
    }
    public void SelectSorting(String s){
        Select chooseSort = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
        chooseSort.selectByVisibleText(s);
    }
    public List<WebElement> GetProductsNames(){
       return driver.findElements(productsNames);
    }
    public void XperiaCompare(){
        driver.findElement(xperiaCompare).click();
    }
    public void IphoneCompare(){
        driver.findElement(iphoneCompare).click();
    }
    public void CompareSubmit(){
        driver.findElement(compareButton).click();
    }
    public void IphoneWishAdd(){
        driver.findElement(iphoneWish).click();
    }
}
