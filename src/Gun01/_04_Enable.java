package Gun01;

import Utils.GenelWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _04_Enable extends GenelWebDriver {


    @Test
    void test1(){

        System.out.println(driver.getCurrentUrl());
    }

    @Test(enabled = false) // bu utesti şimdilik pas geç
    void test2(){

        System.out.println(driver.getTitle());
    }

    @Test
    void test3(){

        System.out.println(driver.getWindowHandle());
    }

}
