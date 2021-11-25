package Gun03;

 /*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son eklenen adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son eklenen adresi siliniz.
     */


import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class _02_AddressFunctionality extends GenelWebDriver {

    @Test
    void AddAddress(){
        WebElement AddressBookButton= driver.findElement(By.linkText("Address Book"));
        AddressBookButton.click();

        WebElement NewAddressButton= driver.findElement(By.linkText("New Address"));
        NewAddressButton.click();

        WebElement inputFirstName= driver.findElement(By.id("input-firstname"));
        inputFirstName.sendKeys("ismet");

        WebElement inputLastName= driver.findElement(By.id("input-lastname"));
        inputLastName.sendKeys("yılmaz");

        WebElement inputComppany= driver.findElement(By.id("input-company"));
        inputComppany.sendKeys("Techno Study");

        WebElement inputAddress1= driver.findElement(By.id("input-address-1"));
        inputAddress1.sendKeys("21a London Road");

        WebElement inputAddress2= driver.findElement(By.id("input-address-2"));
        inputAddress2.sendKeys("RG1 5BJ");

        WebElement inputCity= driver.findElement(By.id("input-city"));
        inputCity.sendKeys("Reading");

        WebElement inputProstCode= driver.findElement(By.id("input-postcode"));
        inputProstCode.sendKeys("12345");

        WebElement selectCountry= driver.findElement(By.id("input-country"));
        Tools.selectByRandomIndex(selectCountry);
//        Select sc=new Select(selectCountry);
//        sc.selectByIndex(10);

        WebDriverWait bekle=new WebDriverWait(driver, 10);
        bekle.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("select[id='input-zone']>option"), 108));
        // option ların sayısı 108 den küçük olana kadar bekle : yeni durum gelene kadar bekle

        //bekle.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("select[id='input-zone']>option"))));
        // bayat eleman kaybolana kadar bekle : ilk durum kaybolana bekle

        WebElement selectState = driver.findElement(By.id("input-zone"));
        Tools.selectByRandomIndex(selectState);
//        Select ss=new Select(selectState);
//        ss.selectByIndex(5);

        // inceleme yukarıdaki wait için
//        System.out.println("ss size="+ss.getOptions().size());
//        // stale Element hatasını aşağıdaki foru yazdığımızda anladık ve gördük: yani eleman bayatlamış yani değişmiş
//        //
//        for(WebElement e: ss.getOptions())
//        {
//            System.out.println("options:"+ e.getText());
//        }


        WebElement ctnBtn=driver.findElement(By.cssSelector("input[value=Continue]"));
        ctnBtn.click();

        Tools.successMessageValidation(driver);

    }

    @Test (dependsOnMethods = {"AddAddress"})
    void EditAddress(){

        WebElement address = driver.findElement(By.linkText("Address Book"));
        address.click();

        List<WebElement> editAll = driver.findElements(By.xpath("//a[text()='Edit']"));
        WebElement edit = editAll.get(editAll.size() - 1);
        edit.click();

        WebElement inputFirstName= driver.findElement(By.id("input-firstname"));
        inputFirstName.sendKeys("ismet2");

        WebElement inputLastName= driver.findElement(By.id("input-lastname"));
        inputLastName.sendKeys("yılmaz2");

        WebElement ctnBtn=driver.findElement(By.cssSelector("input[value=Continue]"));
        ctnBtn.click();

        Tools.successMessageValidation(driver);

    }

    @Test (dependsOnMethods = {"EditAddress"})
    void DeleteAddress(){
        WebElement address = driver.findElement(By.linkText("Address Book"));
        address.click();

        List<WebElement> deleteAll = driver.findElements(By.linkText("Delete"));
        WebElement delete = deleteAll.get(deleteAll.size() - 1);
        delete.click();

        Tools.successMessageValidation(driver);

    }


}
