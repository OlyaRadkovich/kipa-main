import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePageMesto {

    private WebDriver driver;
    private By activity = By.id("owner-description");
    private By save = By.xpath("//form[@name='edit']/button[@type='submit']");

    public ProfilePageMesto(WebDriver driver) {
        this.driver = driver;
    }

    public void changeActivity(String newActivity) {
        driver.findElement(activity).isEnabled();
        driver.findElement(activity).clear();
        driver.findElement(activity).sendKeys(newActivity);
    }

    public void saveProfileChanges() {
        driver.findElement(save).click();
    }
}
