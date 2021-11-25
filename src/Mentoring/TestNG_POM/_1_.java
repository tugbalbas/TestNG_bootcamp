package Mentoring.TestNG_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _1_ {
    public static WebDriver driver;
    @BeforeClass
    public void beforeClass()
    {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("http://demowebshop.tricentis.com/");
    }

    @Test
    public void test1() throws InterruptedException {
        //Komutları burda da verebiliriz ama method oluşturup buraya çağırmak çok daha iyi

        pom pom = new pom(driver);

        pom.clickComputer();
        Thread.sleep(1000);
        pom.setDesktops();
        Thread.sleep(1000);
        pom.setProduct();
        Thread.sleep(1000);
        pom.setAddToCart();
        Thread.sleep(1000);
        pom.setShoppingCart();
        Thread.sleep(1000);
        pom.setRemoveButton();
        Thread.sleep(1000);
        pom.setUpdateCart();
        Thread.sleep(1000);
        pom.assertEmptyMessage();
        Thread.sleep(1000);
    }

    @AfterClass
    public void after() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

}
