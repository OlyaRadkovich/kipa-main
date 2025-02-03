import model.constants.Data;
import model.constants.Urls;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProfilePageTest {
    private WebDriver driver;

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void checkActivity() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        driver.get(Urls.URL);

        LoginPageMesto objLoginPage = new LoginPageMesto(driver);
        objLoginPage.login(Data.EMAIL, Data.PASSWORD);

        HomePageMesto objHomePage = new HomePageMesto(driver);
        objHomePage.waitForLoadProfileData();
        objHomePage.openProfileData();

        ProfilePageMesto objProfilePage = new ProfilePageMesto(driver);
        objProfilePage.changeActivity(Data.NEW_ACTIVITY);
        objProfilePage.saveProfileChanges();

        objHomePage.waitForChangedActivity(Data.NEW_ACTIVITY);

    }
}
