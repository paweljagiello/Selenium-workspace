package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//Wszystkie lokatory i metody strony Login Page.
public class LoginPage {

    WebDriver driver;
    By username =By.id("username");
    By password =By.id("password-log");
    By confirmButton =By.xpath("//*[@id=\"login_form\"]/button");
    By forgotPassword =By.xpath("//*[@id=\"login_form\"]/div[3]/a");
    By fbLogin =By.id("facebook-login");
    By backToHomepageButton = By.xpath("//*[@id=\"login_form\"]/div[4]/div[2]/a");


    public LoginPage(WebDriver driver){
        this.driver = driver;
        driver.get("https://www.morele.net/login");
    }

    public void TypeUsername(String name){
        driver.findElement(username).sendKeys(name);
    }
    public void TypePassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void SubmitLogin(){
        driver.findElement(confirmButton).submit();
    }
    public void GoForgotPassword(){
        driver.findElement(forgotPassword).click();
    }
    public void GoHomePage(){
        driver.findElement(backToHomepageButton).click();
    }

    public String GetLoginErrorMsg(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       return driver.findElement(By.className("mn-body")).getText();
    }

    public void GoFbLogin(){
        driver.findElement(fbLogin).click();
    }

}
