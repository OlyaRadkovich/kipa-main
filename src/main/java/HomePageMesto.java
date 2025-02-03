import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageMesto {
    private WebDriver driver;
    private By profileTitle = By.className("profile__title");
    private By editProfileButton = By.className("profile__edit-button");
    private By profileActivity = By.className("profile__description");

    public HomePageMesto(WebDriver driver) {
        this.driver = driver;
    }

    public void openProfileData() {
        driver.findElement(editProfileButton).click();
    }

    public void waitForLoadProfileData() {
        new WebDriverWait(driver, Duration.ofSeconds(7)).until(driver ->
                (driver.findElement(profileTitle).getText() != null
                        && !driver.findElement(profileTitle).getText().isEmpty()
                ));
    }

    public void waitForChangedActivity(String changed) {
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.textToBePresentInElementLocated(profileActivity, changed));
    }
}
