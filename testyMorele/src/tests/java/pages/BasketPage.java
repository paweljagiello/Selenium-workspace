package pages;

import Functions.GetDoubleFromStringPrice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

//Wszystkie lokatory i metody strony Basket Page.
public class BasketPage {

    WebDriver driver;
    By chooseQtyButton =By.xpath("/html/body/main/div/div/div[3]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div[1]/div/div[2]/button");
    By basetValue = By.xpath("/html/body/main/div/div/div[3]/aside/div[2]/div[4]/div[2]");
    By cleanBasket = By.xpath("/html/body/main/div/div/div[3]/div[2]/div[1]/div[1]/div[2]/button[2]");

    public BasketPage(WebDriver driver){
        this.driver = driver;
    }

    public void ChooseQty(String qty){
        Select drpQty = new Select(driver.findElement(By.xpath("//*[@id=\"basket-main\"]/div[1]/div[2]/div[3]/div[2]/div/div[1]/div/div[2]/select")));
        drpQty.selectByVisibleText(qty);
    }

    public double GetWholeBasketAmount(){
        GetDoubleFromStringPrice dts = new GetDoubleFromStringPrice();
        return dts.StrToDouble(driver.findElement(basetValue).getText());
    }

    public void GetBasketClean(){
        driver.findElement(cleanBasket).submit();
    }


}
