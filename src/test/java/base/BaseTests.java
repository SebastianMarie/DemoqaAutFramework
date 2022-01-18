package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.util.List;

public class BaseTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private ChromeOptions options;

    public WebDriver setUp() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--ignore-ssl-error=yes");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get("http://demoqa.com/");
        return driver;
    }

}
