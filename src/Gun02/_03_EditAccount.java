package Gun02;

 /*
      1- Siteyi açınız.
      2- Edit Account a tıklatınız.
      3- Yeni isim ve soyisim göndererek Continue yapınız.
      4- İşlem sonucunu kontrol ediniz.
      5- Bu işlemi 2 kez çalıştırarak eski haline getiriniz.
     */

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _03_EditAccount extends GenelWebDriver {


//    @Test
//    void EditAccount(){
//
//        WebElement edit= driver.findElement(By.linkText("Edit Account"));
//        edit.click();
//
//        WebElement firstName=driver.findElement(By.xpath("//input[@id='input-firstname']"));
//        firstName.clear();
//        firstName.sendKeys("asdf");
//
//        WebElement lastName=driver.findElement(By.xpath("//input[@id='input-lastname']"));
//        lastName.clear();
//        lastName.sendKeys("fdsa");
//
//        WebElement continueBtn=driver.findElement(By.cssSelector("input[value='Continue']"));
//        continueBtn.click();
//
//        Tools.successMessageValidation(driver);
//
//    }

    // Önce yukarıdaki gibi yaptık ama bu işlemi 2 kez tekrarla dediği için yukarıdakini metoda çeviriyoruz


    @Test
    void EditAccount(){

        editAccount("ismet","temur");
        Tools.Bekle(2);
        editAccount("ali","veli");

    }

    void editAccount(String ad, String soyad){

        WebElement edit= driver.findElement(By.linkText("Edit Account"));
        edit.click();

        WebElement firstName=driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.clear();
        firstName.sendKeys(ad);

        WebElement lastName=driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.clear();
        lastName.sendKeys(soyad);

        WebElement continueBtn=driver.findElement(By.cssSelector("input[value='Continue']"));
        continueBtn.click();

        Tools.successMessageValidation(driver);

    }



}
