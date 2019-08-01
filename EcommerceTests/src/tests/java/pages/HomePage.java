package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By mobile =By.xpath("/html/body/div[1]/div/header/div/div[3]/nav/ol/li[1]/a");
    By tv =By.xpath("/html/body/div[1]/div/header/div/div[3]/nav/ol/li[2]/a");
    By account =By.xpath("/html/body/div[1]/div/header/div/div[2]/div/a/span[2]");
    By cart = By.xpath("/html/body/div[1]/div/header/div/div[2]/div/div/a/span[2]");
    By pageTitle = By.className("page-title");
    By register = By.xpath("/html/body/div[1]/div/header/div/div[5]/div/ul/li[5]/a");
    By logIn = By.xpath("//*[@id=\"header-account\"]/div/ul/li[6]/a");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void GoMobile(){
        driver.findElement(mobile).click();
    }
    public void GoTV(){
        driver.findElement(tv).click();
    }
    public void GoRegisterAccount(){
        driver.findElement(account).click();
        driver.findElement(register).click();
    }
    public void GoLogin(){
        driver.findElement(account).click();
        driver.findElement(logIn).click();
    }
    public void GoCart(){
        driver.findElement(cart).click();
    }
    public String GetPageTitle(){
       return driver.findElement(pageTitle).getText();
    }

}
