package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class GenelWebDriver {
    public static WebDriver driver;

    @BeforeClass
    public void BaslangicIslemleri()
    {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        LoginTest();

    }

    @AfterClass
    public void BitisIslemleri() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }

    void LoginTest()
    {
        WebElement inputEmail= driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("asd@gmail.com");

        WebElement password= driver.findElement(By.id("input-password"));
        password.sendKeys("123qweasd");

        WebElement login=driver.findElement(By.cssSelector("input[value='Login']"));
        login.click();

        WebElement gelismis= driver.findElement(By.id("details-button"));
        gelismis.click();

        WebElement link= driver.findElement(By.id("proceed-link"));
        link.click();
    }

}
