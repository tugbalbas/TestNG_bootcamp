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

public class Test2 {
    public static WebDriver driver;

    @Test
    void Senaryo2(){
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        driver.get("http://demowebshop.tricentis.com/");

        WebDriverWait wait=new WebDriverWait(driver,10);
        POM_Class pom=new POM_Class(driver);

        wait.until(ExpectedConditions.elementToBeClickable(pom.login)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.email)).sendKeys("tech123@tech.com");
        wait.until(ExpectedConditions.elementToBeClickable(pom.password)).sendKeys("123456");

        wait.until(ExpectedConditions.elementToBeClickable(pom.apperelShoes)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.blueAndGreen)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.addWishList)).click();

        wait.until(ExpectedConditions.elementToBeClickable(pom.apperelShoes)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.rockabilly)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.rockAddWishList)).click();
        wait.until(ExpectedConditions.elementToBeClickable(pom.wishList)).click();

        WebElement product1= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div[1]/form/table/tbody/tr[1]/td[4]/a"));
        WebElement product2= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div[1]/form/table/tbody/tr[2]/td[4]/a"));
        Assert.assertTrue(product1.getText().contains("Blue and green Sneaker"));
        Assert.assertTrue(product2.getText().contains("50's Rockabilly Polka Dot Top JR Plus Size"));

    }
}
