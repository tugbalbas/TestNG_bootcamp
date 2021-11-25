package Gun05;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */
public class _02_ContactUs extends GenelWebDriver {

    @Test
    @Parameters("mesaj") // XMLden alacağı parametrenin adı buraya yazıldı
    void contactUs(String gelenMesaj) // parametre alabilir hale getirildi
    {
        WebElement contactUs= driver.findElement(By.linkText("Contact Us"));
        contactUs.click();

        WebElement textArea= driver.findElement(By.id("input-enquiry"));
        //textArea.sendKeys("Hello World"); // parametreli yapıyoruz
        textArea.sendKeys(gelenMesaj);

        WebDriverWait wait=new WebDriverWait(driver,30);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input.btn"))));
        WebElement submitButton=driver.findElement(By.cssSelector("input[class='btn btn-primary']"));
        submitButton.click();

        WebElement contactUsText=driver.findElement(By.cssSelector("div[id='content']>h1"));
        Assert.assertEquals("Contact Us",contactUsText.getText());

    }

}
