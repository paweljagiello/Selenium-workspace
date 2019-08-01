package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    WebDriver driver;

    By typeEmail = By.id("email");
    By typePassword = By.id("pass");
    By confrimButton = By.name("send");

    public LogInPage(WebDriver driver){
        this.driver = driver;
    }

   public void LogIn(String email, String password){
        driver.findElement(typeEmail).sendKeys(email);
        driver.findElement(typePassword).sendKeys(password);
        driver.findElement(confrimButton).click();
   }

   public void Confirm(){
        driver.findElement(confrimButton).click();
   }

}
