package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    WebDriver driver;
    By wishList=By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a");
    By addToCart= By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[1]/form[1]/div/table/tbody/tr/td[5]/div/button/span/span");
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

   public void GoWishList(){
        driver.findElement(wishList).click();
   }
   public void AddToCart(){
        driver.findElement(addToCart).click();
   }

}
