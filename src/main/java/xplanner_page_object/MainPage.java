package xplanner_page_object;

import Configs.Configs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By projectIdLink = By.xpath(String.format("//a[text()='%s']", Configs.getInstance().getProjectId()));

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public IterationsListPage clickProject(){
        driver.findElement(projectIdLink).click();
        return new IterationsListPage(driver);
    }
}
