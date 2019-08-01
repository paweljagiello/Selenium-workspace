package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;
    By price=By.id("product-price-1");
    By qtyField = By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input");
    By addToCartButton = By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button");
    By error =  By.className("error-msg");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String GetProductPrice(){
       return driver.findElement(price).getText();
    }

    public void ChangeQty(String i){
        driver.findElement(qtyField).clear();
        driver.findElement(qtyField).sendKeys(i);
    }
    public void AddToCart(){
        driver.findElement(addToCartButton).submit();
    }

    public String GetErrorMsg(){
        return driver.findElement(error).getText();
    }
}
