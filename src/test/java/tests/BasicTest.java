package tests;

import Configs.Configs;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import xplanner_entities.Story;
import xplanner_page_object.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasicTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private IterationsListPage iterationsListPage;
    private StoriesListPage storiesListPage;
    private StoryDetailsPage storyDetailsPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", Configs.getInstance().getPathToDriver());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(Configs.getInstance().getUrlToXplanner());
        loginPage = new LoginPage(driver);


    }

    @Test
    public void login(){
        mainPage = loginPage.login();
        iterationsListPage = mainPage.clickProject();
        storiesListPage = iterationsListPage.clickIterationIdLink();
        List<Story> stories = storiesListPage.getStories(storyDetailsPage);
 /*       for(Story story : stories){
            storyDetailsPage = storiesListPage.clickStoryId(story.getStoryId());
            double estTime;
            try{
                estTime = storyDetailsPage.getEstTime(storyDetailsPage.getDescription());
            } catch (NumberFormatException e){
                System.out.println("Est appears without a number. Setting 0.0 for a story "+story.getStoryId());
                estTime = 0.0;
            }

            if(estTime > 0)
                story.setEstTime(estTime);
            System.out.println(story.toString());
            storiesListPage = storyDetailsPage.returnTostoriesList();
        } */
        Story.storiesToCsv(stories);
    }

    @After
    public void tearDown(){
        //driver.quit();
    }
}
