package xplanner_page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import xplanner_entities.Story;

import java.util.ArrayList;
import java.util.List;

public class StoriesListPage {
    private WebDriver driver;
    private By storyTable = By.xpath("//tr[@class='odd' or @class='even']");
    private String storyIdElement = "//tr[@class='odd' or @class='even']/td/a[text() = '%s']";
    private String storyDetailsPath = "//a[text() = '%s']/parent::td/following-sibling::*";
    private By storyIdsElements = By.xpath("//tr[@class='odd' or @class='even']/td[2]/a");
    public StoriesListPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<Story> getStories(StoryDetailsPage storyDetailsPage){
        /*List<WebElement> tableRows = driver.findElements(storyTable);
        List<Story> storiesList = new ArrayList<>();
        for(WebElement element : tableRows) {
            String storyId = element.findElement(By.xpath(".//td[2]")).getText();
            storyDetailsPage = this.clickStoryId(storyId);
            double estTime = storyDetailsPage.getEstTime(storyDetailsPage.getDescription());
            storyDetailsPage.returnTostoriesList();
            String name = element.findElement(By.xpath(".//td[4]")).getText();
            String responsible = element.findElement(By.xpath(".//td[14]")).getText();
            String customer = element.findElement(By.xpath(".//td[6]")).getText();
            String status = element.findElement(By.xpath(".//td[16]")).getText();
            double actTime = Double.valueOf(element.findElement(By.xpath(".//td[9]")).getText().replace(",", "."));
            boolean isFromPreviousIteration = false;
            Story story = new Story(storyId, name, responsible, customer, status, estTime, actTime, isFromPreviousIteration);
            storiesList.add(story);
            System.out.println(story.toString());
        }*/

        List<String> storiesIdsListText = getStoryIds();
        List<Story> storiesList = new ArrayList<>();
        for(String element : storiesIdsListText){
            String storyId = element;
            storyDetailsPage = this.clickStoryId(element);
            double estTime = storyDetailsPage.getEstTime(storyDetailsPage.getDescription());
            storyDetailsPage.returnTostoriesList();
            String name = driver.findElement(By.xpath(String.format(storyDetailsPath+"[2]",element))).getText();
            String customer = driver.findElement(By.xpath(String.format(storyDetailsPath+"[4]",element))).getText();;

            double actTime = Double.valueOf(driver.findElement(By.xpath(String.format(storyDetailsPath+"[7]",element))).getText().replace(",", "."));
            boolean isFromPreviousIteration = false;
            String responsible = driver.findElement(By.xpath(String.format(storyDetailsPath+"[12]",element))).getText();;

            String status = driver.findElement(By.xpath(String.format(storyDetailsPath+"[14]",element))).getText();;

            Story story = new Story(storyId, name, responsible, customer, status, estTime, actTime, isFromPreviousIteration);
            storiesList.add(story);
            System.out.println(story.toString());
        }

        return storiesList;
    }

    public List<String> getStoryIds(){
        List<WebElement> storiesIdsList = driver.findElements(storyIdsElements);
        List<String> storiesIdsListText = new ArrayList<>();
        for(WebElement element : storiesIdsList){
            storiesIdsListText.add(element.getText());
        }
        return storiesIdsListText;
    }

    public StoryDetailsPage clickStoryId(String storyId) {
        driver.findElement(By.xpath(String.format(storyIdElement, storyId))).click();
        return new StoryDetailsPage(driver);
    }
}
