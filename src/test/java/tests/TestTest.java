package tests;

import Configs.Configs;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import xplanner_entities.Story;
import xplanner_page_object.*;

import java.util.concurrent.TimeUnit;

public class TestTest {
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
    public void test() {
        mainPage = loginPage.login();
        iterationsListPage = mainPage.clickProject();
        storiesListPage = iterationsListPage.clickIterationIdLink();
        storyDetailsPage = storiesListPage.clickStoryId("10063887");
        String description = storyDetailsPage.getDescription();
        String descSubstr = description.substring(description.indexOf("Est"));
        descSubstr = descSubstr.replace(":","")
                .replace(".","")
                .replace(" ","")
                .replace("Est","");
        System.out.println(descSubstr);
    }

}
