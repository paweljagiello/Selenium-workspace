package pages;

import Functions.GetDoubleFromStringPrice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

//Wszystkie lokatory i metody strony Product Page.
public class ProductPage {

    WebDriver driver;
    By qTychooseButton = By.xpath("/html/body/main/div/section[1]/div[1]/div[6]/aside/div[2]/div/div[7]/div/div[2]/button");
    By productPrice = By.xpath("//*[@id=\"product_price_brutto\"]");
    By basketValue = By.xpath("/html/body/header/div[1]/div/div/div/div[2]/div/div[2]/div/div[5]/a/span");
    By addToBasketButton =By.xpath("//*[@id=\"product\"]/div[1]/div[6]/aside/div[2]/div/div[7]/a");
    By addToCompare =By.xpath("//*[@id=\"product\"]/div[1]/div[6]/div/div/div/div[2]/div/div[1]/button");
    By askForProduct =By.xpath("//*[@id=\"product\"]/div[1]/div[6]/aside/div[2]/div/div[8]/a[1]");
    By getProductID =By.xpath("//*[@id=\"product\"]/div[1]/div[6]/div/div/div/div[2]/div/div[3]/div");
    By twoyearsGuaranteePrice = By.xpath("//*[@id=\"ws-container\"]/div/div[2]/div[2]/div/label/span[3]/span[2]");
    By systemInstallationPrice = By.xpath("//*[@id=\"ws-container\"]/div[1]/div[2]/div[3]/div/label/span[3]/span");
    By addToWishListButton = By.xpath("//*[@id=\"product\"]/div[1]/div[6]/div/div/div/div[1]/button[1]/i[1]");
    By addToWishListChooseList = By.xpath("//*[@id=\"catalog_product\"]/div[8]/div[2]/div/div");
    By add2MoreGuaranteeYear = By.xpath("//*[@id=\"ws-container\"]/div/div[2]/div[2]/div/label/span[2]");
    By AcceptBuyandGoToBasketbtn = By.xpath("/html/body/div[7]/div/div/div[2]/div[3]/button");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void AddToBasket(){
        driver.findElement(addToBasketButton).click();
    }

    public void ConfirmBuyGoToBasket(){
        driver.findElement(AcceptBuyandGoToBasketbtn).submit();
    }

    public double getBasketDoubleValue(){
        GetDoubleFromStringPrice gd  = new GetDoubleFromStringPrice();
        return gd.StrToDouble(driver.findElement(basketValue).getText());
    }

    public void QuantityChoose(String qty){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        driver.findElement(qTychooseButton).click();
        List<WebElement> qTyList = driver.findElements(By.className("md-list-item"));

        for(WebElement q: qTyList){
            if(q.getText().equals(qty)==true){
                q.click();
            }
        }
    }

    public void AddToCompare(){
        driver.findElement(addToCompare).submit();
    }
    public void AskForProduct(){
        driver.findElement(askForProduct).click();
    }
    public void Add2YearGuarantee(){
        driver.findElement(add2MoreGuaranteeYear).click();
    }

    public String GetProductID(){
       String id = driver.findElement(getProductID).getText();
       return id; }

    public Double GetProductPriceDouble(){
        GetDoubleFromStringPrice dts = new GetDoubleFromStringPrice();
        return dts.StrToDouble(driver.findElement(productPrice).getText());
    }

    public Double Get2YearsGuaranteeDoublePrice(){
        GetDoubleFromStringPrice dts = new GetDoubleFromStringPrice();
        return dts.StrToDouble(driver.findElement(twoyearsGuaranteePrice).getText());
    }
    public Double GetSystemInstallDoublePrice(){
        GetDoubleFromStringPrice dts = new GetDoubleFromStringPrice();
        return dts.StrToDouble(driver.findElement(systemInstallationPrice).getText());
    }
    public void AddProductToWishList(){
        driver.findElement(addToWishListButton).click();
        driver.findElement(addToWishListChooseList).click();
    }

}
