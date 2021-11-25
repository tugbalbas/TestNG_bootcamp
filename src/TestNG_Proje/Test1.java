package TestNG_Proje;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public static WebDriver driver;

    @Test
    void Senaryo1(){

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        driver.get("http://demowebshop.tricentis.com/");;

        WebDriverWait wait=new WebDriverWait(driver,10);
        POM_Class pom=new POM_Class(driver);

        wait.until(ExpectedConditions.elementToBeClickable(pom.login)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.email)).sendKeys("tech123@tech.com");
        wait.until(ExpectedConditions.elementToBeClickable(pom.password)).sendKeys("123456");
        wait.until(ExpectedConditions.elementToBeClickable(pom.loginBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.contactUs)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.messageBx)).sendKeys("Hello World");
        wait.until(ExpectedConditions.elementToBeClickable(pom.messageSubmit)).click();

        WebElement success=driver.findElement(By.xpath("//div[@class='result']"));
        Assert.assertTrue(success.getText().contains("successfully"));

    }



}
