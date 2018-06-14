package xplanner_page_object;

import Configs.Configs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StoryDetailsPage {
    private WebDriver driver;
    private By returnToStoriesListLink = By.xpath(String.format("//a[text() = \"%s\"]", Configs.getInstance().getIterationName()));
    private By storyDescription = By.xpath("//html//table[@width='100%']/tbody/tr[3]/td[1]");
    public StoryDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public StoriesListPage returnTostoriesList(){
        driver.findElement(returnToStoriesListLink).click();
        return new StoriesListPage(driver);
    }

    public String getDescription(){
        return driver.findElement(storyDescription).getText();
    }
    public double getEstTime(String description){

        if(description.contains("Est")) {
            String estTime = description.substring(description.indexOf("Est"))
                    .replace(":", "")
                    .replace(".", "")
                    .replace(" ", "")
                    .replace("Est", "");
            try {
                return Double.valueOf(estTime);
            } catch (NumberFormatException e){
                System.out.println("Est appears without a number. Setting 0.0 for a story");
                return 0.0;
            }
        } else {
            return 0.0;
        }
    }

}
