package Gun01;
/*
   Senaryo ;
     1- http://opencart.abstracta.us/index.php?route=account/login  sitesini açınız.
     2- asd@gmail.com  ve 123qweasd   bilgileri ile login olan test metodunu yazınız.
     3- Login olup olmadığınızı assert ile kontrol ediniz.
     Sonra;
     4- bir utils paketi açınız ve buraya beforeClass ve afterClass metdolarını yazarak
        genel kullanım için GenelWebDriver isimli test klasını tanımlayınız.
 */


import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _05_Ornek extends GenelWebDriver {



    // 3- Login olup olmadığınızı assert ile kontrol ediniz.
    @Test
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