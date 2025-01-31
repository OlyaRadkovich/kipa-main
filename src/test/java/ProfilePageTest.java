import model.HomePageMesto;
import model.LoginPageMesto;
import model.ProfilePageMesto;
import model.constants.Urls;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProfilePageTest {
   private WebDriver driver;

   @Test
   public void checkActivity() {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--no-sandbox","--headless", "--disable-dev-shm-usage");
      driver = new ChromeDriver(options);

      driver.get(Urls.URL);

      LoginPageMesto objLoginPage = new LoginPageMesto(driver);
      String email = "radkovich@gmail.com";
      String password = "123456";
      objLoginPage.login(email, password);

      HomePageMesto objHomePage = new HomePageMesto(driver);
      objHomePage.waitForLoadProfileData();
      objHomePage.editProfileData();


   }
}
