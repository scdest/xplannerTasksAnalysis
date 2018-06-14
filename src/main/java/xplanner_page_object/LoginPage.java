package xplanner_page_object;

import Configs.Configs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//input[@name='userId']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//input[@id='login']");

    public MainPage login() {
        driver.findElement(loginField).sendKeys(Configs.getInstance().getLogin());
        driver.findElement(passwordField).sendKeys(Configs.getInstance().getPassword());
        driver.findElement(loginButton).click();
        return new MainPage(driver);

    }
}
