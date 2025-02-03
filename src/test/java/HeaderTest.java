import model.constants.Data;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import model.constants.Urls;

public class HeaderTest {
    private WebDriver driver;

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkEmailHeader() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get(Urls.URL);

        LoginPageMesto objLoginPage = new LoginPageMesto(driver);
        objLoginPage.login(Data.EMAIL, Data.PASSWORD);

        HeaderPageMesto objHeader = new HeaderPageMesto(driver);
        objHeader.waitForLoadHeader();
        String headerText = objHeader.getHeaderText();

        Assertions.assertEquals(Data.EMAIL, headerText);
    }
}
