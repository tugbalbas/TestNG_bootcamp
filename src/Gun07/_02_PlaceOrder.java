package Gun07;

/*
    Senaryo :
    1- Siteyi açınız.
    2- Sitede "ipod" kelimesini aratınız
    3- Çıkan sonuçlardan ilkini sepete atınız.
    4- Shopping Chart a tıklatınız.
    5- Checkout yapınız.
    6- Continue butonalarına tıklatıp bilgileri giriniz.
    7- En confirm ile siparişi verdiğinizi doğrulayınız.
       doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
 */

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_PlaceOrder extends GenelWebDriver {

    @Test
    void ProceedToCheckout()
    {
        WebElement searchInput=driver.findElement(By.cssSelector("input[placeholder='Search']"));
        searchInput.sendKeys("ipod");

        WebElement searchBtn=driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        searchBtn.click();

        WebElement addToCart=driver.findElement(By.xpath("//span[text()='Add to Cart']"));
        addToCart.click();

        WebElement shopingCart= driver.findElement(By.cssSelector("a[title='Shopping Cart']"));
        shopingCart.click();

        WebElement checkOut=driver.findElement(By.linkText("Checkout"));
        checkOut.click();

        WebDriverWait wait=new WebDriverWait(driver, 10);

        WebElement continue1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));
        continue1.click();

        WebElement continue2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address")));
        continue2.click();

        WebElement continue3 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
        continue3.click();

        WebElement agree = driver.findElement(By.cssSelector("input[type='checkbox']"));
        agree.click();

        WebElement continue4 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-method")));
        continue4.click();

        WebElement confirm=driver.findElement(By.id("button-confirm"));
        confirm.click();

        wait.until(ExpectedConditions.urlContains("success"));

        WebElement text= driver.findElement(By.cssSelector("div[id='content']>h1"));
        Assert.assertEquals(text.getText(),"Your order has been placed!");
    }









}


