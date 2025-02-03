import model.constants.Data;
import model.constants.Urls;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BaseTest {

    private WebDriver driver;

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void loginTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        driver.get(Urls.URL);
        LoginPageMesto objLoginPage = new LoginPageMesto(driver);
        objLoginPage.login(Data.EMAIL, Data.PASSWORD);
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));
        String text = driver.findElement(By.className("header__logout")).getText();
        System.out.println("Текст кнопки: " + text);
        WebElement element = driver.findElement(By.tagName("footer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", element);
        driver.findElement(By.className("profile__image")).click();
        driver.findElement(By.id("owner-avatar")).sendKeys("https://dzen.ru/lz5XeGt8f/19nqH6373/cb1078k48/TP8HzQzdP1HhwRyOVF9INtpueD1KnZGdSzeFO4bozb6cQCNfqkxANdZEnC6-9sDQ0Dj7uDdTnSvq6iz3jMJ_PUn6HrFt9SsQsMRYO01-OTrKTzwcB5z19RYv9H-H7L3H0GzTWqoNcXiHEQAyuta8bHi0gmTSjjGLYxfY4rmWV1RU67ZZMdl_qaUVqPItJxT2-voUKYp1tGEHpvmLovUx3rQQEws2GbVs06nJ86tDpPisBCb84m7BO-9TJNqNYjq4IGPuqHnZZ1FdLYSmOUNMPnqacJ16QVCNVzax8_J5RXpsoMcvrk1xyKu15SPPq8xAJDQeJBJ2HQszO1wyRbauSBRf7jgheY_dbTEMSrUruD7m_ky9krUMrdfa3euueZniVFx_E17JdWxvPSHL33Nc-GRQQnx6PuFHc69kNhkW5iyE65JEtcGLATkhRBKxLwgSakZILXKBGI23MmmL9qnJeqCgC9ce2THUk0GVKy-PHMQgJCLYzpY9c7On9DZlYmrYRKfimBFpc5XVPTB-eWtknv4axI3e8SwBR9rhL9rZwYJc7GcnumXJ6APtNd83w6j0NPQmBHLyzesn9_BabRLKvNwDUoTxRR9BdT3QHjV7ZJL2XmxVasHQYYtGIU_CoblOXNj3e8KB0STf1fErl5O4wESEjlxKavUT4_cIUuFGrqRYX4KsFdFjISUdVCbdP3DiggbYvWb1EI0bZhHPpl25jlg8w0dOKZ3YLx1ps0uruCzA4B4sfnKpqyeTZJZdikqg_LsCEBnNJ6FVXbSCjeNIGhr6TElieQzNt-oRs4bt1c4oUE_zWo3FtKNB7X-TM6BEOAzO0O72QXcXb3wm9da6NJg3HggpQWftWd0oLg2v_GaW0uwR-hHEtT_O0e_CIb3qEHxXq74d2cwf3clPxxvUuBhgCuDOJsFj9wtcrgU2wnS8GxIA_UGDtWmhkJYtx7jymsqAJZa9iL3jPhkL2ompfqDMQxsaISVEdy1B60szHDQkNNJg8poZP_N31DrVNjbUPB_-cOnZN5XpGTzOJcPoNvr-5Mne7SDtjwrRB74tOYa8THMrttVxeP-JFVPvN-CA5ADCoLIaEZejcyQWeeq6cDznqkCd2XO98XWoXql_UEIm-lDF3j0sQS9mYb86pXWONCzz35JhZXAbrc3vX6cs3FSEEuSCVjGL7ztIOmkWOsQA8wqM-XmDkXmpBGadswzWWna0qbKZDLnbUjWbpgUhxoS4DwM-6SHMfxF5k-_PKKC8fKL0Hpop-7ebKKZp5tZMgDcq4GG5o0U9VQQuBTtMFsJKjA2Kxczti-YhE8Z9XeK88GP_hh2VZKcdvf__G9xYFGwOoP5-SRPHq_iuCcLCrNBr0sClJe-x8T3YpkWryIZWNtDh5j0QRVumoaMWPe1m1EDDZ455Mej3mU3b6_PA1KToyojy8mkTP594romWOnQob05w-c0vDSH58IK9p2CSDvIcOXpRRDETeqHH8nWxxlRYG-v-kc34d8Hl33vflICUUAo8qnrJD8cPvCI5FjI0QKvyRO39j0n9wVwKiYN0tgoylElGDbCVu-7pf3aF0T5ISGOPPg05VOPJda-zp9gkpKSuxHoOMTfvl0BaHTaiqJgzjmSp_Y-1UZmk9iEP3BLmzkjd9jXceSdaBau27XESXCTr7zJtNSCXOR0Xr89QsFj41uAqplETX-tk0h3OejREc_qsEXVnBUEBDMrVo2DCVnqIIepxSBWfLim7OtlhEiRYRxMOZW00L8G9P_sToJQYoBboCualB6O_-DYVxkr4OB9SzC3ZX-G1wdDiRePw6maaPIFyBVyt22ph445RveZgmEcDioVF0PtRMadPS_RYEAgOCIrq4eN3H2hWxaLOZMyX8iABBZs9XbWI-o339JJKgpQlHlmQod_OaQuqiRliNDz_AyZNGWTfvV2XL4_IOOCQOoTGCi1L8ys4Xl0GYsD0F3J8PQUfpa0FJGYk");
        driver.findElement(By.xpath("//form[@name='edit-avatar']/button[text()='Сохранить']")).click();


    }
}
