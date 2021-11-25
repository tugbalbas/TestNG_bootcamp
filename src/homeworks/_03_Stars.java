package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;

//Bu siteye gidin. https://www.hotels.com/
//        Atlanta'yı arayın.
//        Check-in tarihini bugünden 2 gün sonraya ayarlayın.
//
//        Check-out tarihini bugünden 5 gün sonraya ayarlayın.
//
//        Searh butonuna tıklayın.
//
//        5 yıldızlı ve 4 yıldızlı butonlarına tıklayın.(filtreleyin)
//
//        Aşağı kaydırın ve en az 50 otel gözüktüğünden emin olun.
//
//        Tüm otellerin 4 ila 5 yıldız olduğunu doğrulayın.
public class _03_Stars extends hworkBaseDriver{

    @Test
    void starts(){
        startingWebSite("https://tr.hotels.com/");

        WebElement searchBox=driver.findElement(By.name("q-destination"));
        searchBox.clear();
        searchBox.sendKeys("Atlanta");


        WebElement option=driver.findElement(By.xpath("//span[@class='OB1XAq _2agSNy']"));
        option.click();

        //        Check-in tarihini bugünden 2 gün sonraya ayarlayın.

        LocalDateTime day=LocalDateTime.now();
        int day1= day.getDayOfMonth();








    }


}
