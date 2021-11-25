package Gun06;

/*
   Senaryo
   1- Siteye gidiniz
   2- Specials tiklayiniz
   3- Cikan urun sayisi ile indirimli urun sayisi ayni mi dogrulayiniz
   4- Yukarıdaki işlemden sonra her ürünün önceki fiyatının şu andaki fiyattan yüksek olduğunu doğrulayınız.
*/

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _06_Task3 extends GenelWebDriver {
    @Test
    void specialsValidation1()
    {
        WebElement speCial= driver.findElement(By.linkText("Specials"));
        speCial.click();

        List<WebElement> oldPriceList = driver.findElements(By.className("price-old")); // eski fiyatlar
        List<WebElement> productList  =driver.findElements(By.className("product-thumb")); // ürün isimleri

        Assert.assertEquals(oldPriceList.size(),productList.size());

        /*** Eski fiyat yeni fiyat karşılaştırması *****/
        List<WebElement> newPriceList=driver.findElements(By.cssSelector("span[class='price-new']")); // yeni fiyatlar


        for (int i=0; i<newPriceList.size(); i++) {
            Assert.assertTrue(cevir(newPriceList.get(i)) < cevir(oldPriceList.get(i)));
        }

    }

    public double cevir(WebElement element){
        String result=element.getText();
        result=result.replaceAll("[^\\d]","");
        return Double.parseDouble(result);
    }

}