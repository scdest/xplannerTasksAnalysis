package xplanner_page_object;

import Configs.Configs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IterationsListPage {
    private WebDriver driver;

    private By iterationIdLink = By.xpath(String.format("//a[text()='%s']",Configs.getInstance().getIterationId()));


    public IterationsListPage(WebDriver driver) {
        this.driver = driver;
    }

    public StoriesListPage clickIterationIdLink(){
        driver.findElement(iterationIdLink).click();
        return new StoriesListPage(driver);
    }


}
