import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPageMesto {
    private WebDriver driver;
    private By headerUser = By.className("header__user");

    public HeaderPageMesto(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForLoadHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(headerUser));
    }

    public String getHeaderText() {
        return driver.findElement(headerUser).getText();
    }
}
