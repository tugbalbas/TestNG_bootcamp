package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*
Bu siteye gidin :    [https://www.hotels.com/](https://www.hotels.com/)
Para birimi menüsüne tıklayın (currency menu)

Random bir para birimi seçin. (Random kullanın)

Rastgele para birimine göre metin de değişir.
 Para birimi menüsünde para birimi metninin değiştiğini doğrulayın
 */
public class _02_Currency extends hworkBaseDriver{

    @Test
    void currency(){
        startingWebSite("https://www.hotels.com/");

        WebElement currencyMenu= driver.findElement(By.xpath("(//button[@class='_3gE-EQ _2lnvSN'])[2]"));
        currencyMenu.click();

        //Random bir para birimi seçin. (Random kullanın)
        List<WebElement> birimler=driver.findElements(By.xpath("//a[@class='_2Q07ec']"));
        int a=birimler.size();
        WebElement secilen= birimler.get(RandomNumberGenerator(a));
        secilen.click();

        WebDriverWait wait=new WebDriverWait(driver,10);

        WebElement secilenCheck=driver.findElement(By.cssSelector("a[class='_2Q07ec']>span"));
        wait.until(ExpectedConditions.stalenessOf(secilenCheck));
        bekle(10);
        Assert.assertEquals(secilen.getText(),secilenCheck.getText());



    }

}
