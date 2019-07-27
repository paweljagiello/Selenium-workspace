package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

//Wszystkie lokatory i metody strony Account Page.
public class AccountPanelPage {

    WebDriver driver;
    By settings =By.xpath("/html/body/div[3]/section/section/div/div[1]/div[1]/nav/ul/li[3]/a");
    By slidesup = By.xpath("/html/body/div[3]/footer/div[2]/div[2]/a");
    List<WebElement> WishlistList = driver.findElements(By.className("sl-nb-name"));


    public AccountPanelPage(WebDriver driver){
        this.driver = driver;
    }

    public void GoSettings(){
        driver.findElement(settings).click();
    }

    public void GoSlideUp(){
        driver.findElement(slidesup).click();
    }

}
