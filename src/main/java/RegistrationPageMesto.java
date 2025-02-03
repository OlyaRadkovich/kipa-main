import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageMesto {
    private WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By registrationButton = By.xpath("//a[@class='header__auth-link']");

    public RegistrationPageMesto(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(emailField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickSignUpButton() {
        driver.findElement(registrationButton).click();
    }

    public void register(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickSignUpButton();
    }

    public void checkTextRegistrationButton() {
        String textRegistrationButton = "Регистрация";
        Assertions.assertEquals(textRegistrationButton, driver.findElement(registrationButton).getText(), "Текст соответствует ожидаемому: " + textRegistrationButton);
    }

}
